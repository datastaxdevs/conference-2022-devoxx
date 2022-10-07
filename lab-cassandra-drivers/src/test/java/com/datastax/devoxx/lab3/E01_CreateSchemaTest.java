package com.datastax.devoxx.lab3;

import static com.datastax.devoxx.schema.SchemaUtils.createTableCommentByUser;
import static com.datastax.devoxx.schema.SchemaUtils.createTableCommentByVideo;
import static com.datastax.devoxx.schema.SchemaUtils.createTableUser;
import static com.datastax.devoxx.schema.SchemaUtils.createTableVideo;
import static com.datastax.devoxx.schema.SchemaUtils.createTableVideoViews;
import static com.datastax.devoxx.schema.SchemaUtils.createUdtVideoFormat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.devoxx.schema.SchemaConstants;
/**
 * Sample code to create tables, types and objects in a keyspace.
 * 
 * Pre-requisites:
 * - Cassandra running locally (127.0.0.1, port 9042)
 * - Keyspace killrvideo created {@link SampleCode4x_CONNECT_CreateKeyspace}
 */
import com.datastax.oss.driver.api.core.CqlSession;

public class E01_CreateSchemaTest implements SchemaConstants {
    
    private static Logger LOGGER = LoggerFactory.getLogger(E01_CreateSchemaTest.class);
    
    @Test
    public void should_create_schema() {
        try(CqlSession cqlSession = CqlSession.builder().build()) {
            createUdtVideoFormat(cqlSession);
            createTableUser(cqlSession);
            createTableVideo(cqlSession);
            createTableVideoViews(cqlSession);
            createTableCommentByVideo(cqlSession);
            createTableCommentByUser(cqlSession);
        }
        LOGGER.info("[OK] Success");
        System.exit(0);
    }
   
}
