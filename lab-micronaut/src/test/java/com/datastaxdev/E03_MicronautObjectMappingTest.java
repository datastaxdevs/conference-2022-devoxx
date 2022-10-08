package com.datastaxdev;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastaxdev.todo.cassandra.TodoServicesCassandraOM;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
public class E03_MicronautObjectMappingTest {

    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E03_MicronautObjectMappingTest.class);
    
    @Inject
    CqlSession quarkusCqlSession;
    
    @Inject
    TodoServicesCassandraOM todoService;
    
    @Test
    public void testExecuteCql() {
        LOGGER.info("Inserting Data");
        TodoDto dto = new TodoDto();
        dto.setUserId("clun");
        dto.setCompleted(false);
        dto.setTitle("Apprendre Mapping Objet Micronaut");
        todoService.save(dto);
        LOGGER.info("+ [OK]");
    }
    
}
