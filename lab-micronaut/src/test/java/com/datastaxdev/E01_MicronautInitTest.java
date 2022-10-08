package com.datastaxdev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;

import io.micronaut.context.BeanContext;
import io.micronaut.context.annotation.Property;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest(application=TodoApplication.class)
public class E01_MicronautInitTest {

    @Inject
    EmbeddedApplication<?> application;
    
    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E01_MicronautInitTest.class);
    
    @Inject
    BeanContext beanContext;
    
    @Inject
    CqlSession cqlSession;

    @Inject
    @Property(name = "cassandra.default.basic.session-keyspace")
    String keyspace;
    
    @Test
    public void testConnectCassandra() {
        LOGGER.info("Creating your CqlSession to Cassandra...");
        Assertions.assertNotNull(beanContext);
        Assertions.assertNotNull(cqlSession);
        Assertions.assertTrue(cqlSession.getKeyspace().isPresent());
        LOGGER.info("+ [OK] Your are connected to keyspace {}", cqlSession.getKeyspace().get());
        Assertions.assertEquals(keyspace, cqlSession.getKeyspace().get().toString());
    }
    
    
}
