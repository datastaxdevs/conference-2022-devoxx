package com.datastax.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;

public class E00_TestConnectivity {
    
    private static Logger LOGGER = LoggerFactory.getLogger(E00_TestConnectivity.class);
    
    public static void main(String[] args) {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            LOGGER.info("[SUCCESS]");
        }   
    }
    

}
