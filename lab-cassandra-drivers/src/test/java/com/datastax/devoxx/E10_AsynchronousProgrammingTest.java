package com.datastax.devoxx;

import static com.datastax.devoxx.schema.SchemaUtils.createTableUser;
import static com.datastax.devoxx.schema.SchemaUtils.truncateTable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.devoxx.dto.UserDto;
import com.datastax.devoxx.schema.SchemaConstants;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.AsyncResultSet;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;

/**
 * !! WARNING Tests with no Assertions here (I assume) !!
 * 
 * @author cedricklunven
 */
@TestMethodOrder(OrderAnnotation.class)
public class E10_AsynchronousProgrammingTest implements SchemaConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(E10_AsynchronousProgrammingTest.class);
    
    private static PreparedStatement stmtCreateUser;
    private static PreparedStatement stmtUpsertUser;
    private static PreparedStatement stmtExistUser;
    private static PreparedStatement stmtDeleteUser;
    private static PreparedStatement stmtFindUser;
    
    String userEmail = "clun@sample.com";
    String userEmail2 = "eram@sample.com";
    
    @BeforeAll
    public static void shout_init_statements() {
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
    public void should_create_async() 
    throws InterruptedException, ExecutionException {
    	try(CqlSession cqlSession = CqlSession.builder().build()) {   
            existUserAsync(cqlSession, userEmail)
                .thenAccept(exist -> LOGGER.info("+ '{}' exists ? (expecting false): {}", userEmail, exist))
                .thenCompose(r->createUserAsync(cqlSession, userEmail, "Cedric", "Lunven"))
                .thenCompose(r->existUserAsync(cqlSession, userEmail))
                .thenAccept(exist -> LOGGER.info("+ '{}' exists ? (expecting true): {}", userEmail, exist))
                .toCompletableFuture().get(); // enforce blocking call to have logs.
    	}
    }
    
    @Test
    @Order(2)
    public void should_update_async() 
    throws InterruptedException, ExecutionException {
    	try(CqlSession cqlSession = CqlSession.builder().build()) {          
            existUserAsync(cqlSession, userEmail2)
                .thenAccept(exist -> LOGGER.info("+ '{}' exists ? (expecting false): {}", userEmail2, exist))
                .thenCompose(r->updateUserAsync(cqlSession, userEmail2,  "Eric", "Ramirez"))
                .thenCompose(r->existUserAsync(cqlSession, userEmail2))
                .thenAccept(exist -> LOGGER.info("+ '{}' exists ? (expecting true): {}", userEmail2, exist))
                .toCompletableFuture().get(); // enforce blocking call to have logs.
    	}
    }
    
    
    @Test
    @Order(3)
    public void should_delete_async() 
    throws InterruptedException, ExecutionException {
    	try(CqlSession cqlSession = CqlSession.builder().build()) {     
            deleteUserAsync(cqlSession, userEmail2)
                .thenCompose(r->existUserAsync(cqlSession, userEmail2))
                .thenAccept(exist -> LOGGER.info("+ '{}' exists ? (expecting false) {}", userEmail2, exist))
                .get(); // enforce blocking call to have logs.
    	}
    }
    
    @Test
    @Order(4)
    public void should_read_async() 
    throws InterruptedException, ExecutionException {
    	try(CqlSession cqlSession = CqlSession.builder().build()) {   
    		
            findUserByIdAsync(cqlSession, "eram@sample.com")
                .thenAccept(erick -> LOGGER.info("+ Retrieved '{}': (expecting Optional.empty) {}", userEmail2, erick))
                .get(); // enforce blocking call to have logs.
        
            findUserByIdAsync(cqlSession, "clun@sample.com")
                .thenAccept(erick -> LOGGER.info("+ Retrieved '{}': (expecting result) {}", userEmail2, erick))
                .get(); // enforce blocking call to have logs.
            
            // Read all (first upserts)
            updateUserAsync(cqlSession, userEmail2, "Eric", "Ramirez");
            updateUserAsync(cqlSession, userEmail, "Cedrick", "Lunven");
            List<UserDto > allUsers = cqlSession
                    .execute(QueryBuilder.selectFrom(USER_TABLENAME).all().build())
                    .all().stream().map(UserDto::new)
                    .collect(Collectors.toList());
            LOGGER.info("+ Retrieved users count {}", allUsers.size());
            
        }
    }
    
    private static CompletionStage<Boolean> existUserAsync(CqlSession cqlSession, String email) {
        return cqlSession.executeAsync(stmtExistUser.bind(email))
                      .thenApply(ars -> ars.one() != null);
    }
    
    private static CompletableFuture<Void> createUserAsync(CqlSession cqlSession, String email, String firstname, String lastname) {
        return cqlSession.executeAsync(stmtCreateUser.bind(email, firstname, lastname))
                .thenAccept(rs -> {
                        if (!rs.wasApplied()) {
                            throw new IllegalArgumentException("Email '" + email + 
                                    "' already exist in Database. Cannot create new user");
                        }
                        LOGGER.info("+ User {} has been created", email);
                      }).toCompletableFuture();
    }
    
    private static CompletableFuture<Void> updateUserAsync(CqlSession cqlSession, String email, String firstname, String lastname) {
        return cqlSession.executeAsync(stmtUpsertUser.bind(email, firstname, lastname))
                .thenAccept(rs -> LOGGER.info("+ User {} has been updated", email))
                .toCompletableFuture();
    }
    
    private static CompletableFuture<Void> deleteUserAsync(CqlSession cqlSession, String email) {
        return cqlSession.executeAsync(stmtDeleteUser.bind(email))
                .thenAccept(rs -> LOGGER.info("+ User {} has been deleted", email))
                .toCompletableFuture();
    }
    
    private static CompletableFuture< Optional < UserDto > > findUserByIdAsync(CqlSession cqlSession, String email) {
        return cqlSession.executeAsync(stmtFindUser.bind(email))
                      .thenApply(E10_AsynchronousProgrammingTest::mapUserDtoRow)
                      .toCompletableFuture();
    }
    
    private static Optional < UserDto > mapUserDtoRow(AsyncResultSet asyncRS) {
        Row myRow = asyncRS.one();
        if (myRow == null) {
            return Optional.empty();
        }
        return Optional.of(new UserDto(myRow));
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
