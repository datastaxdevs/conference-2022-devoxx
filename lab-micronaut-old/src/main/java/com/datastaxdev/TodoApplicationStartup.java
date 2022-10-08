package com.datastaxdev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastaxdev.todo.cassandra.TodoServiceCassandraCql;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceReadyEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

/**
 * Execute some Action and application startup.
 *
 * @author Cedrick LUNVEN (@clunven)
 */
@Singleton
public class TodoApplicationStartup  implements ApplicationEventListener<ServiceReadyEvent> {

    /** Logger for the class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TodoApplicationStartup.class);
    
    @Inject 
    private CqlSession cqlSession;
    
    /** {@inheritDoc} */
    @Override
    public void onApplicationEvent(final ServiceReadyEvent event) {
        LOGGER.info("Startup Initialization");
        TodoServiceCassandraCql.createTableTodo(cqlSession);
        LOGGER.info("+ Table TodoItems created if needed.");
        LOGGER.info("[OK]");
    }


}




