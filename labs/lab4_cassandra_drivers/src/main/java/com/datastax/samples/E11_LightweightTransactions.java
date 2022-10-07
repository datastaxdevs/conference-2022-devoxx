package com.datastax.samples;

import static com.datastax.samples.schema.SchemaUtils.createTableUser;
import static com.datastax.samples.schema.SchemaUtils.truncateTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.samples.schema.SchemaConstants;

public class E11_LightweightTransactions implements SchemaConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(E11_LightweightTransactions.class);
    
    private static PreparedStatement stmtCreateUser;
    private static PreparedStatement stmtUpdateUserLwt;
    
    public static void main(String[] args) {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            
            // Use PreparedStatement for queries that are executed multiple times in your application
            prepareStatements(cqlSession);
            
            // Create working table User (if needed)
            createTableUser(cqlSession);
            
            // Empty tables for tests
            truncateTable(cqlSession, USER_TABLENAME);
            
            // Insert if not exist
            boolean first  = createUserIfNotExist(cqlSession, "clun@sample.com", "Cedric", "Lunven");
            boolean second = createUserIfNotExist(cqlSession, "clun@sample.com", "Cedric", "Lunven");
            LOGGER.info("+ Created first time ? {} and second time {}", first, second);
            
            // Update if condition
            boolean applied1 = updateIf(cqlSession, "clun@sample.com", "Cedric", "BEST");
            boolean applied2 = updateIf(cqlSession, "clun@sample.com", "Cedrick", "Lunven");
            LOGGER.info("+ Applied when correct value ? {} and invalid value {}", applied1, applied2);
            
        }
    }
    
    /**
     * The resultset is applied only if the record is created. If not the resultSet is populated
     * with existing data in DB (read)
     */
    private static boolean createUserIfNotExist(CqlSession cqlSession, String email, String firstname, String lastname) {
        return cqlSession.execute(stmtCreateUser.bind(email, firstname, lastname)).wasApplied();
    }
    
    /**
     * Note: we named the parameters as they are not in the same order in the query.
     */
    private static boolean updateIf(CqlSession cqlSession, String email, String expectedFirstName, String newLastName) {
        return cqlSession.execute(stmtUpdateUserLwt.bind()
                .setString(USER_EMAIL, email)
                .setString(USER_FIRSTNAME, expectedFirstName)
                .setString(USER_LASTNAME, newLastName)).wasApplied();
    }
    
    /**
     * Documentation
     * https://docs.datastax.com/en/developer/java-driver/3.8/manual/statements/prepared/#prepared-statements
     */
    private static void prepareStatements(CqlSession cqlSession) {
        
        /* 
         * INSERT INTO users (email, firstname, lastname)
         * VALUES(?,?,?)
         * IF NOT EXISTS
         */
        stmtCreateUser = cqlSession.prepare(QueryBuilder.insertInto(USER_TABLENAME)
                .value(USER_EMAIL, QueryBuilder.bindMarker())
                .value(USER_FIRSTNAME, QueryBuilder.bindMarker())
                .value(USER_LASTNAME, QueryBuilder.bindMarker())
                .ifNotExists()
                .build());
        
        /* 
         * UPDATE users SET lastname=:lastname
         * WHERE email=:email
         * IF firstname=:firstname
         * 
         * Operators available for LWT Condition: 
         * =, <, <=, >, >=, != and IN
         */
        stmtUpdateUserLwt = cqlSession.prepare(QueryBuilder.update(USER_TABLENAME)
                .setColumn(USER_LASTNAME, QueryBuilder.bindMarker(USER_LASTNAME))
                .whereColumn(USER_EMAIL).isEqualTo(QueryBuilder.bindMarker(USER_EMAIL))
                .ifColumn(USER_FIRSTNAME).isEqualTo(QueryBuilder.bindMarker(USER_FIRSTNAME))
                .build());
    }

}
