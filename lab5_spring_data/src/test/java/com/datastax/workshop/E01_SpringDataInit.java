package com.datastax.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.datastax.oss.driver.api.core.CqlSession;

@SpringBootTest
public class E01_SpringDataInit {

    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E01_SpringDataInit.class);
    
    @Autowired
    CqlSession cqlSession;
    
    @Test
    public void testCqlSession() {
        LOGGER.info("Creating your CqlSession to Cassandra...");
        Assertions.assertTrue(cqlSession.getKeyspace().isPresent());
        LOGGER.info("+ [OK] Your are connected to keyspace {}", cqlSession.getKeyspace().get());
    }
}
