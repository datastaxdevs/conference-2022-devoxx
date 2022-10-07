package com.datastax.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.datastax.todo.todo.TodoEntity;
import com.datastax.todo.todo.TodoRepositoryCassandra;

@SpringBootTest
public class E02_SpringDataRepositoryTest {
    
    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E02_SpringDataRepositoryTest.class);
    
    @Autowired
    TodoRepositoryCassandra todoRepo;
    
    @Test
    public void testCassandraRepository() {
        // Given
        TodoEntity te = new TodoEntity("Apprendre Cassandra", 0);
        // When
        TodoEntity e = todoRepo.save(te);
        LOGGER.info("Tache enregistree avec id {}", e.getUid());
        // Then
        Assertions.assertTrue(todoRepo.existsById(te.getUid()));
        // Listing
        LOGGER.info("Liste des Taches");
        todoRepo.findAll().stream().map(Object::toString).forEach(LOGGER::info);
    }
    
    

}
