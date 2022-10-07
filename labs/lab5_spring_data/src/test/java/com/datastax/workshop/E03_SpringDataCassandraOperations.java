package com.datastax.workshop;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraOperations;

import com.datastax.workshop.todo.TodoEntity;
import com.datastax.workshop.todo.TodoRepositorySimpleCassandra;

@SpringBootTest
public class E03_SpringDataCassandraOperations {

    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E02_SpringDataRepository.class);
    
    @Autowired
    CassandraOperations cassandraOps;
    
    @Autowired
    TodoRepositorySimpleCassandra todoRepoSimple;
    
    @Test
    public void testCassandraOperations() {
        LOGGER.info("Utilisation de CassandraOperations");
        cassandraOps.select("select * from todos", TodoEntity.class)
                    .stream()
                    .map(Object::toString)
                    .forEach(LOGGER::info);
    }
    
    @Test
    public void testSimpleCassandraRepository() {
        TodoEntity e = todoRepoSimple.save(new TodoEntity("Apprendre Cassandra", 0));
        LOGGER.info("Tache enregistree avec id {}", e.getUid());
        
        LOGGER.info("Liste des Taches");
        todoRepoSimple.findAll().stream().map(Object::toString).forEach(LOGGER::info);
    }
    
}
