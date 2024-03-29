package com.datastax.devoxx;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.devoxx.schema.SchemaConstants;
import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.shaded.guava.common.collect.ImmutableMap;

/**
 * !! WARNING Tests with no Assertions here (I assume) !!
 *
 * @author cedricklunven
 */
public class E02_StatementsTest implements SchemaConstants {
    
    private static Logger LOGGER = LoggerFactory.getLogger(E02_StatementsTest.class);
    
    @Test
    public void should_execute_simple_statements() {
    	
        try(CqlSession cqlSession = CqlSession.builder().build()) {
            
            // Execute Queries as STRING (never do THAT)
            cqlSession.execute(""
                    + "INSERT INTO users (email, firstname, lastname) "
                    + "VALUES ('clun@sample.com', 'Cedrick', 'Lunven')");
            LOGGER.info("+ Insert as a String");
            
            // String is actually a Statement
            cqlSession.execute(SimpleStatement.newInstance(
                      "INSERT INTO users (email, firstname, lastname) "
                    + "VALUES ('clun2@sample.com', 'Cedrick', 'Lunven')"));
            LOGGER.info("+ Insert as a Statement");
            
            // #2.a Externalize parameters with '?'
            
            // -- option1: one by one
            cqlSession.execute(SimpleStatement
                           .builder("INSERT INTO users (email, firstname, lastname) VALUES (?,?,?)")
                           .addPositionalValue("clun3@gmail.com")
                           .addPositionalValue("Cedrick")
                           .addPositionalValue("Lunven").build());
            LOGGER.info("+ Insert and externalize var with ?, option1");

            // -- option2: all at once
            cqlSession.execute(SimpleStatement
                    .builder("INSERT INTO users (email, firstname, lastname) VALUES (?,?,?)")
                    .addPositionalValues("clun4@gmail.com", "Cedrick", "Lunven").build());
            LOGGER.info("+ Insert and externalize var with ?, option2");
            
            // #2.b Externalize parameters with labels:name
          
            // -- option1: one by one
            cqlSession.execute(SimpleStatement
                    .builder("INSERT INTO users (email, firstname, lastname) VALUES (:e,:f,:l)")
                    .addNamedValue("e", "clun5@gmail.com")
                    .addNamedValue("f", "Cedrick")
                    .addNamedValue("l", "Lunven").build());
            LOGGER.info("+ Insert and externalize var with :labels, option1");
            
            // -- option2: all at once
            cqlSession.execute(SimpleStatement
                    .builder("INSERT INTO users (email, firstname, lastname) VALUES (:e,:f,:l)")
                    .setConsistencyLevel(ConsistencyLevel.LOCAL_QUORUM)
                    .setTimeout(Duration.ofSeconds(2))
                    .build()
                    .setNamedValues(ImmutableMap.<String, Object>of(
                                                "e", "clun6@gmail.com",
                                                "f", "Cedrick", 
                                                "l", "Lunven")));
            LOGGER.info("+ Insert and externalize var with :labels, option2");
        }
    }
    
    @Test
    public void should_execute_query_builder() {
    	
    	 try(CqlSession cqlSession = CqlSession.builder().build()) {
    	    // Utilisation du QueryBuilder pour construire les requetes
            cqlSession.execute(QueryBuilder
                    .insertInto(USER_TABLENAME)
                    .value(USER_EMAIL, QueryBuilder.literal("clun5@gmail.com"))
                    .value(USER_FIRSTNAME, QueryBuilder.literal("Cedrick"))
                    .value(USER_LASTNAME, QueryBuilder.literal("Lunven"))
                    .build());
            LOGGER.info("+ Insert with QueryBuilder");
    	 }
    }
    
    @Test
    public void should_prepare_statements() {
         
    	 try(CqlSession cqlSession = CqlSession.builder().build()) {
            // #5. il faut preparer ses statements

            // 5.a Parameteres avec `?`
            PreparedStatement ps1 = cqlSession.prepare("INSERT INTO users (email, firstname, lastname) "
                                                  + "VALUES (?,?,?)");
            BoundStatement bs1 = ps1.bind("clun6@gmail.com", "Cedrick", "Lunven");
            cqlSession.execute(bs1);
            LOGGER.info("+ Insert with PrepareStatements");
            
           
            // 5.b Pour utiliser un prepare statement par la suite on bind les valeurs avec 'bindMarker'
            PreparedStatement ps2 = cqlSession.prepare(QueryBuilder
                    .insertInto(USER_TABLENAME)
                    .value(USER_EMAIL, QueryBuilder.bindMarker())
                    .value(USER_FIRSTNAME, QueryBuilder.bindMarker())
                    .value(USER_LASTNAME, QueryBuilder.bindMarker())
                    .build());
            cqlSession.execute(ps2.bind("clun7@gmail.com", "Cedrick", "Lunven"));
            LOGGER.info("+ Insert with PrepareStatements + QueryBuilder");
        }
    }
    
    
    
   
  
}
