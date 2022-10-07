package com.datastax.samples;

import static com.datastax.samples.schema.SchemaUtils.createTableUser;
import static com.datastax.samples.schema.SchemaUtils.truncateTable;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.dse.driver.api.core.cql.reactive.ReactiveResultSet;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.samples.dto.UserDto;
import com.datastax.samples.schema.SchemaConstants;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class E09_Reactive implements SchemaConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(E09_Reactive.class);

    private static PreparedStatement stmtUpsertUser;
    private static PreparedStatement stmtExistUser;
    private static PreparedStatement stmtDeleteUser;
    private static PreparedStatement stmtFindUser;
    
    public static void main(String[] args)
    throws InterruptedException, ExecutionException {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            
            // Create working table User (if needed)
            createTableUser(cqlSession);
            
            // Empty tables for tests
            truncateTable(cqlSession, USER_TABLENAME);
            
            // Prepare your statements once and execute multiple times 
            prepareStatements(cqlSession);
            
            // ========== CREATE / UPDATE ===========
            
            String userEmail  = "clun@sample.com";
            String userEmail2 = "ram@sample.com";
            
            // Test existence of user 1 to false and then create user 1
            existUserReactive(cqlSession, userEmail)
                .doOnNext(exist -> LOGGER.info("+ '{}' exists ? (expecting false): {}", userEmail, exist))
                .and(upsertUserReactive(cqlSession, userEmail, "Cedric", "Lunven"))
                .block();
            
            // User 1 now exist and we log (blocking call)
            existUserReactive(cqlSession, userEmail)
                .doOnNext(exist -> LOGGER.info("+ '{}' exists ? (expecting false): {}", userEmail, exist))
                .block();
            
            // Creating user 2 to be deleted
            upsertUserReactive(cqlSession, userEmail2,  "Eric", "Ramirez")
                .doOnNext(exist -> LOGGER.info("+ '{}' exists ? (expecting false): {}", userEmail2, exist))
                .block();
            
            // ========= DELETE ============
            
            deleteUserReactive(cqlSession, userEmail2)
                .doOnNext(exist -> LOGGER.info("+ '{}' exists ? (expecting false) {}", userEmail2, exist))
                .block(); // enforce blocking call to have logs.
            
            // ========= READ ==============
            
            // User 2 has been deleted as such will be empty
            findUserByIdReactive(cqlSession, "eram@sample.com")
                .doOnNext(erick -> LOGGER.info("+ Retrieved '{}': (expecting Optional.empty) {}", userEmail2, erick))
                .block(); // enforce blocking call to have logs.
        
            // User 1 is there so we should lie 
            findUserByIdReactive(cqlSession, "clun@sample.com")
                .doOnNext(erick -> LOGGER.info("+ Retrieved '{}': (expecting result) {}", userEmail2, erick))
                .block(); // enforce blocking call to have logs.
           
            // creating user 2 again to have 2 records in the tables
            upsertUserReactive(cqlSession, userEmail2,  "Eric", "Ramirez")
                .doOnNext(exist -> LOGGER.info("+ '{}' exists ? (expecting false): {}", userEmail2, exist))
                .block();
            // Listing users
            listAllUserReactive(cqlSession)
                .map(UserDto::getEmail)
                .doOnNext(email -> LOGGER.info("+ '{}' email found", email))
                .blockLast();
            
            Thread.sleep(500);
        }
    }
    
    private static Mono<Boolean> existUserReactive(CqlSession cqlSession, String email) {
        ReactiveResultSet rrs = cqlSession.executeReactive(stmtExistUser.bind(email));
        return Mono.from(rrs).map(rs -> true).defaultIfEmpty(false);
    }
    
    private static Mono<Optional<UserDto>> findUserByIdReactive(CqlSession cqlSession, String email) {
        return Mono.from(cqlSession.executeReactive(stmtFindUser.bind(email)))
                   .doOnNext(row -> LOGGER.info("+ Retrieved '{}': (expecting result) {}", row.getString(USER_EMAIL), email))
                   .map(UserDto::new).map(Optional::of)
                   .defaultIfEmpty(Optional.empty());
    }
    
    private static Mono<Void> upsertUserReactive(CqlSession cqlSession, String email, String firstname, String lastname) {
        ReactiveResultSet rrs = cqlSession.executeReactive(stmtUpsertUser.bind(email, firstname, lastname));
        return Mono.from(rrs).then();
    }
    
    private static Mono<Void> deleteUserReactive(CqlSession cqlSession, String email) {
        return Mono.from(cqlSession.executeReactive(stmtDeleteUser.bind(email))).then();
    }
    
    private static Flux<UserDto> listAllUserReactive(CqlSession cqlSession) {
        SimpleStatement queryAllUser = QueryBuilder.selectFrom(USER_TABLENAME).all().build();
        return Flux.from(cqlSession.executeReactive(queryAllUser)).map(UserDto::new);
    }
    
    private static void prepareStatements(CqlSession cqlSession) {
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
