package com.datastax.workshop;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.quarkus.runtime.api.session.QuarkusCqlSession;
import com.datastaxdev.todo.TodoDto;
import com.datastaxdev.todo.cassandra.TodoServiceCassandraCql;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class E02_QuarkusCql {
    
    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E02_QuarkusCql.class);
    
    @Inject
    QuarkusCqlSession quarkusCqlSession;
    
    @Inject
    TodoServiceCassandraCql todoService;
    
    @Test
    public void testExecuteCql() {
        LOGGER.info("Creating the schema...");
        TodoServiceCassandraCql.createTableTodo(quarkusCqlSession);
        LOGGER.info("+ [OK]");
        
        LOGGER.info("Inserting Data");
        TodoDto dto = new TodoDto();
        dto.setUserId("clun");
        dto.setCompleted(false);
        dto.setTitle("Apprendre Quarkus");
        todoService.save(dto);
        LOGGER.info("+ [OK]");
    }
}
