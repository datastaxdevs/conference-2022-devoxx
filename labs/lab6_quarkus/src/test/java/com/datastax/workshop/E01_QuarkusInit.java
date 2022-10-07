package com.datastax.workshop;

import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.quarkus.runtime.api.session.QuarkusCqlSession;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class E01_QuarkusInit {

    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E01_QuarkusInit.class);
    
    @Inject
    QuarkusCqlSession quarkusCqlSession;
    
    @Inject
    @ConfigProperty(name = "quarkus.cassandra.keyspace")
    String keyspace;
    
    @Test
    public void testCqlSession() {
        LOGGER.info("Creating your CqlSession to Cassandra...");
        Assertions.assertNotNull(keyspace);
        Assertions.assertTrue(quarkusCqlSession.getKeyspace().isPresent());
        LOGGER.info("+ [OK] Your are connected to keyspace {}", quarkusCqlSession.getKeyspace().get());
        Assertions.assertEquals(keyspace, quarkusCqlSession.getKeyspace().get().toString());
    }
 
}
