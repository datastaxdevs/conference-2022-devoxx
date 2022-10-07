package com.datastax.devoxx;

import java.net.InetSocketAddress;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;

/**
 * Connect to your cluster.
 *
 * @author Cedrick LUNVEN (@clunven)
 */
public class E00_ConnectivityTest {
    
    private static Logger LOGGER = 
            LoggerFactory.getLogger(E00_ConnectivityTest.class);
    
    @Test
    @DisplayName("Explicit connection")
    public void should_connect_to_cluster_explicit() {
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("127.0.0.1", 9042))
                .withKeyspace("system")
                .withLocalDatacenter("dc1")
                .build()) {
            cqlSession.getMetadata()
                      .getNodes()
                      .entrySet()
                      .stream()
                      .forEach(e -> LOGGER.info("NODE {} listening at {}" , 
                              e.getKey(), e.getValue().getListenAddress().getClass().getCanonicalName()));
        }

    }
    
    @Test
    @DisplayName("Connect to Cassandra Cluster")
    public void should_connect_to_cluster() {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            Assertions.assertTrue(cqlSession.getKeyspace().isPresent());
            LOGGER.info("[SUCCESS]");
        } 
    }

}
