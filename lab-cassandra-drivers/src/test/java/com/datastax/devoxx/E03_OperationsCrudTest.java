package com.datastax.devoxx;

import static com.datastax.devoxx.schema.SchemaUtils.createTableUser;
import static com.datastax.devoxx.schema.SchemaUtils.truncateTable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.devoxx.dto.UserDto;
import com.datastax.devoxx.schema.SchemaConstants;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;

/**
 * !! WARNING Tests with no Assertions here (I assume) !!
 * 
 * @author cedricklunven
 */
@TestMethodOrder(OrderAnnotation.class)
public class E03_OperationsCrudTest implements SchemaConstants {

    private static Logger LOGGER = 
    		LoggerFactory.getLogger(E03_OperationsCrudTest.class);

    private static PreparedStatement stmtCreateUser;
    private static PreparedStatement stmtUpsertUser;
    private static PreparedStatement stmtExistUser;
    private static PreparedStatement stmtDeleteUser;
    private static PreparedStatement stmtFindUser;
    
    String userEmail  = "clun@sample.com";
    String userEmail2 = "eram@sample.com";
    
    @BeforeAll
    public void should_prepare_statements() {
    	 try(CqlSession cqlSession = CqlSession.builder().build()) {
             
             // Create working table User (if needed)
             createTableUser(cqlSession);
             
             // Empty tables for tests
             truncateTable(cqlSession, USER_TABLENAME);
             
             // Prepare your statements once and execute multiple times 
             prepareStatements(cqlSession);
             
         }
    }
    
    @Test
    @Order(1)
    public void should_create_statements() {
    	
    	try(CqlSession cqlSession = CqlSession.builder().build()) {
            
	        if (!existUser(cqlSession, userEmail)) {
	            LOGGER.info("+ {} does not exists in table 'user'", userEmail);
	        }
	        
	        createUser(cqlSession, userEmail, "Cedric", "Lunven");
	        
	        if (existUser(cqlSession, userEmail)) {
	            LOGGER.info("+ {}  now exists in table 'user'", userEmail);
	        }
    	}
    }
    	
    @Test
    @Order(2)
    public void should_update_statements() {
    	
    	try(CqlSession cqlSession = CqlSession.builder().build()) {
            
            

            if (!existUser(cqlSession, userEmail2)) {
                LOGGER.info("+ {} does not exists in table 'user'", userEmail2);
            } 
            
            updateUser(cqlSession, userEmail2, "Eric", "Ramirez");
            
            if (existUser(cqlSession, userEmail2)) {
                LOGGER.info("+ {}  now exists in table 'user'", userEmail2);
            }
    	}
    }
    
    @Test
    @Order(3)
    public void should_delete_statements() {
    	
    	try(CqlSession cqlSession = CqlSession.builder().build()) {
            
            // Delete an existing user by its email (if email does not exist, no error)
            deleteUser(cqlSession, userEmail2);
            if (!existUser(cqlSession, userEmail2)) {
                LOGGER.info("+ {} does not exists in table 'user'", userEmail2);
            }
    	}
    }
    
    
    @Test
    @Order(4)
    public void should_read_statements() {
    	
    	try(CqlSession cqlSession = CqlSession.builder().build()) {
            
            // ========= READ ==============
            
            // Will be empty as we have deleted it
            Optional<UserDto> erick = findUserById(cqlSession, userEmail2);
            LOGGER.info("+ Retrieved {}: {}", userEmail2,erick); // Expected Optiona.empty()
            
            // Not null
            Optional<UserDto> cedrick = findUserById(cqlSession, userEmail);
            LOGGER.info("+ Retrieved {}: {}", userEmail, cedrick.get().getEmail()); 
            
            // Read all (first upserts)
            updateUser(cqlSession, userEmail2, "Eric", "Ramirez");
            updateUser(cqlSession, userEmail, "Cedrick", "Lunven");
            List<UserDto > allUsers = cqlSession
                    .execute(QueryBuilder.selectFrom(USER_TABLENAME).all().build())
                    .all().stream().map(UserDto::new)
                    .collect(Collectors.toList());
            LOGGER.info("+ Retrieved users count {}", allUsers.size());
        }
    }
    
    private static boolean existUser(CqlSession cqlSession, String email) {
        return cqlSession.execute(stmtExistUser.bind(email)).getAvailableWithoutFetching() > 0;
    }
    
    private static void createUser(CqlSession cqlSession, String email, String firstname, String lastname) {
        ResultSet rs = cqlSession.execute(stmtCreateUser.bind(email, firstname, lastname));
        if (!rs.wasApplied()) {
            throw new IllegalArgumentException("Email '" + email + "' already exist in Database. Cannot create new user");
        }
        LOGGER.info("+ User {} has been created", email);
    }
    
    private static void updateUser(CqlSession cqlSession, String email, String firstname, String lastname) {
        cqlSession.execute(stmtUpsertUser.bind(email, firstname, lastname));
        LOGGER.info("+ User {} has been updated", email);
    }
    
    private static void deleteUser(CqlSession cqlSession, String email) {
        cqlSession.execute(stmtDeleteUser.bind(email));
        LOGGER.info("+ User {} has been deleted", email);
    }
    
    private static Optional < UserDto > findUserById(CqlSession cqlSession, String email) {
        ResultSet rs = cqlSession.execute(stmtFindUser.bind(email));
        // We query by the primary key ensuring unicity
        Row record = rs.one();
        return (null != record) ? Optional.of(new UserDto(record)) :Optional.empty();
    }
    
    private static void prepareStatements(CqlSession cqlSession) {
        stmtCreateUser = cqlSession.prepare(QueryBuilder.insertInto(USER_TABLENAME)
                .value(USER_EMAIL, QueryBuilder.bindMarker())
                .value(USER_FIRSTNAME, QueryBuilder.bindMarker())
                .value(USER_LASTNAME, QueryBuilder.bindMarker())
                .ifNotExists().build());
        // Using a - SLOW - lightweight transaction to check user existence
        stmtUpsertUser = cqlSession.prepare(QueryBuilder.insertInto(USER_TABLENAME)
                .value(USER_EMAIL, QueryBuilder.bindMarker())
                .value(USER_FIRSTNAME, QueryBuilder.bindMarker())
                .value(USER_LASTNAME, QueryBuilder.bindMarker())
                .build());
        stmtExistUser = cqlSession.prepare(QueryBuilder
                .selectFrom(USER_TABLENAME).column(USER_EMAIL)
                .whereColumn(USER_EMAIL)
                .isEqualTo(QueryBuilder.bindMarker())
                .build());
        stmtDeleteUser = cqlSession.prepare(QueryBuilder
                .deleteFrom(USER_TABLENAME)
                .whereColumn(USER_EMAIL)
                .isEqualTo(QueryBuilder.bindMarker())
                .build());
        stmtFindUser = cqlSession.prepare(QueryBuilder
                .selectFrom(USER_TABLENAME).all()
                .whereColumn(USER_EMAIL)
                .isEqualTo(QueryBuilder.bindMarker())
                .build());
    }
  
}
