package com.datastax.devoxx;

import static com.datastax.devoxx.schema.SchemaUtils.createTableVideoViews;
import static com.datastax.devoxx.schema.SchemaUtils.truncateTable;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.devoxx.schema.SchemaConstants;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;

/**
 * !! WARNING Tests with no Assertions here (I assume) !!
 * 
 * @author cedricklunven
 */
public class E05_CountersTest implements SchemaConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(E05_CountersTest.class);

    private static PreparedStatement stmtIncrement;
    private static PreparedStatement stmtDecrement;
    private static PreparedStatement stmtFindById;
    private static PreparedStatement stmtDelete;
    
    @BeforeAll
    public static void shout_init_statements() {
    	
    	try(CqlSession cqlSession = CqlSession.builder().build()) {
            
            // Create tables for tests
            createTableVideoViews(cqlSession);
            
            // Empty tables for tests
            truncateTable(cqlSession, VIDEO_VIEWS_TABLENAME);

            // Prepare your statements once and execute multiple times 
            prepareStatements(cqlSession);
    	}
    }
    
    @Test
    public void should_test_counters() {
           
    	try(CqlSession cqlSession = CqlSession.builder().build()) {

            // We cannot insert in a table with a counter
            UUID videoId = UUID.randomUUID();
            LOGGER.info("+ Video views {}", findById(cqlSession, videoId));
            
            // ========= UPDATE ============
            
            incrementBy(cqlSession, videoId, 10);
            LOGGER.info("+ Video views : {}", findById(cqlSession, videoId).get());
            
            decrementBy(cqlSession, videoId, 8);
            LOGGER.info("+ Video views : {}", findById(cqlSession, videoId).get());
            
            // ========= DELETE ============
            
            delete(cqlSession, videoId);
            LOGGER.info("+ Video views {}", findById(cqlSession, videoId));
           
        }
    }
    
    private static Optional <Long> findById(CqlSession cqlSession, UUID videoid) {
        Row record = cqlSession.execute(stmtFindById.bind(videoid)).one();
        if (null != record) {
            return Optional.of(record.getLong(VIDEO_VIEWS_VIEWS));
        }
        return Optional.empty();
    }
    
    private static void incrementBy(CqlSession cqlSession, UUID videoid, long val) {
        cqlSession.execute(stmtIncrement.bind(val, videoid));
    }
    
    private static void decrementBy(CqlSession cqlSession, UUID videoid, long val) {
        cqlSession.execute(stmtDecrement.bind(val, videoid));
    }
    
    private static void delete(CqlSession cqlSession, UUID videoid) {
        cqlSession.execute(stmtDelete.bind(videoid));
    }
    
    private static void prepareStatements(CqlSession cqlSession) {

        // update videos_views SET views =  views + X WHERE videoid=... 
        stmtIncrement = cqlSession.prepare(QueryBuilder
                .update(VIDEO_VIEWS_TABLENAME)
                .increment(VIDEO_VIEWS_VIEWS, QueryBuilder.bindMarker())
                .whereColumn(VIDEO_VIEWS_VIDEOID).isEqualTo(QueryBuilder.bindMarker())
                .build());

        // update videos_views SET views =  views + X WHERE videoid=..
        stmtDecrement =  cqlSession.prepare(QueryBuilder
                .update(VIDEO_VIEWS_TABLENAME)
                .decrement(VIDEO_VIEWS_VIEWS, QueryBuilder.bindMarker())
                .whereColumn(VIDEO_VIEWS_VIDEOID).isEqualTo(QueryBuilder.bindMarker())
                .build());
        
        // SELECT views FROM videos_views WHERE videoid=... 
        stmtFindById = cqlSession.prepare(QueryBuilder
                .selectFrom(VIDEO_VIEWS_TABLENAME).column(VIDEO_VIEWS_VIEWS)
                .whereColumn(VIDEO_VIEWS_VIDEOID).isEqualTo(QueryBuilder.bindMarker())
                .build());
                
        // DELETE FROM videos_views WHERE videoid=... 
        stmtDelete = cqlSession.prepare(QueryBuilder
                .deleteFrom(VIDEO_VIEWS_TABLENAME)
                .whereColumn(VIDEO_VIEWS_VIDEOID).isEqualTo(QueryBuilder.bindMarker())
                .build());
        
    }

}
