package com.datastax.samples;

import static com.datastax.samples.schema.SchemaUtils.createTableCommentByUser;
import static com.datastax.samples.schema.SchemaUtils.createTableCommentByVideo;
import static com.datastax.samples.schema.SchemaUtils.createTableUser;
import static com.datastax.samples.schema.SchemaUtils.createTableVideo;
import static com.datastax.samples.schema.SchemaUtils.createTableVideoViews;
import static com.datastax.samples.schema.SchemaUtils.createUdtVideoFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample code to create tables, types and objects in a keyspace.
 * 
 * Pre-requisites:
 * - Cassandra running locally (127.0.0.1, port 9042)
 * - Keyspace killrvideo created {@link SampleCode4x_CONNECT_CreateKeyspace}
 */
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.samples.schema.SchemaConstants;

public class E01_CreateSchema implements SchemaConstants {
    
    private static Logger LOGGER = LoggerFactory.getLogger(E01_CreateSchema.class);
    
    public static void main(String[] args) {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
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
