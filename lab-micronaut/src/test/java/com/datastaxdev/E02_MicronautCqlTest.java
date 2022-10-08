package com.datastaxdev;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastaxdev.todo.cassandra.TodoServiceCassandraCql;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
public class E02_MicronautCqlTest {
    
    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E02_MicronautCqlTest.class);
    
    @Inject
    CqlSession cqlSession;
    
    @Inject
    TodoServiceCassandraCql todoService;
    
    @Test
    public void testExecuteCql() {
        LOGGER.info("Creating the schema...");
        TodoServiceCassandraCql.createTableTodo(cqlSession);
        LOGGER.info("+ [OK]");
        
        LOGGER.info("Inserting Data");
        TodoDto dto = new TodoDto();
        dto.setUserId("clun");
        dto.setCompleted(false);
        dto.setTitle("Apprendre Micronaut");
        todoService.save(dto);
        LOGGER.info("+ [OK]");
    }
}
