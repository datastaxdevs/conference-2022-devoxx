package com.datastax.samples;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.shaded.guava.common.collect.ImmutableMap;
import com.datastax.samples.schema.SchemaConstants;

public class E02_Statements implements SchemaConstants {
    
    private static Logger LOGGER = LoggerFactory.getLogger(E01_CreateSchema.class);
    
    public static void main(String[] args) {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            
            // #1.a Execution de requete en chaine de caracteres 
            
            cqlSession.execute(""
                    + "INSERT INTO users (email, firstname, lastname) "
                    + "VALUES ('clun@sample.com', 'Cedrick', 'Lunven')");
            LOGGER.info("+ Insert as a String");
            
            // #1.b Tout est statement
            
            cqlSession.execute(SimpleStatement.newInstance(
                      "INSERT INTO users (email, firstname, lastname) "
                    + "VALUES ('clun2@sample.com', 'Cedrick', 'Lunven')"));
            LOGGER.info("+ Insert as a Statement");
            
            // #2.a Externalisation des variables en utilisant la position et '?'
            
            // -- option1: un parametre a la fois
            cqlSession.execute(SimpleStatement
                           .builder("INSERT INTO users (email, firstname, lastname) VALUES (?,?,?)")
                           .addPositionalValue("clun3@gmail.com")
                           .addPositionalValue("Cedrick")
                           .addPositionalValue("Lunven").build());
            LOGGER.info("+ Insert and externalize var with ?, option1");

            // -- option2: tous les parametres en une fois
            cqlSession.execute(SimpleStatement
                    .builder("INSERT INTO users (email, firstname, lastname) VALUES (?,?,?)")
                    .addPositionalValues("clun4@gmail.com", "Cedrick", "Lunven").build());
            LOGGER.info("+ Insert and externalize var with ?, option2");
            
            // #2.b Externalisation en utilisant des labels:name
          
            // -- option1:  un parametre a la fois
            cqlSession.execute(SimpleStatement
                    .builder("INSERT INTO users (email, firstname, lastname) VALUES (:e,:f,:l)")
                    .addNamedValue("e", "clun5@gmail.com")
                    .addNamedValue("f", "Cedrick")
                    .addNamedValue("l", "Lunven").build());
            LOGGER.info("+ Insert and externalize var with :labels, option1");
            
            // -- option2: tous les parametres en une fois
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
                    
            
            // #4. Utilisation du QueryBuilder pour construire les requetes
            cqlSession.execute(QueryBuilder
                    .insertInto(USER_TABLENAME)
                    .value(USER_EMAIL, QueryBuilder.literal("clun5@gmail.com"))
                    .value(USER_FIRSTNAME, QueryBuilder.literal("Cedrick"))
                    .value(USER_LASTNAME, QueryBuilder.literal("Lunven"))
                    .build());
            LOGGER.info("+ Insert with QueryBuilder");
            
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
