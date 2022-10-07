package com.datastax.workshop;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.quarkus.runtime.api.session.QuarkusCqlSession;
import com.datastaxdev.todo.TodoDto;
import com.datastaxdev.todo.cassandra.TodoServicesCassandraOM;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class E03_QuarkusObjectMapping {

    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E02_QuarkusCql.class);
    
    @Inject
    QuarkusCqlSession quarkusCqlSession;
    
    @Inject
    TodoServicesCassandraOM todoService;
    
    @Test
    public void testExecuteCql() {
        LOGGER.info("Inserting Data");
        TodoDto dto = new TodoDto();
        dto.setUserId("clun");
        dto.setCompleted(false);
        dto.setTitle("Apprendre Mapping Objet Quarkus");
        todoService.save(dto);
        LOGGER.info("+ [OK]");
    }
    
}
