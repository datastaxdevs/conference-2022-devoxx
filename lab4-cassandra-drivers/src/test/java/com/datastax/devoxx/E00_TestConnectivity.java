package com.datastax.devoxx;

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
public class E00_TestConnectivity {
    
    private static Logger LOGGER = 
            LoggerFactory.getLogger(E00_TestConnectivity.class);
    
    @Test
    @DisplayName("Connect to Cassandra Cluster")
    public void should_connect_to_cluster() {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            Assertions.assertTrue(cqlSession.getKeyspace().isPresent());
            LOGGER.info("[SUCCESS]");
        } 
    }

}
