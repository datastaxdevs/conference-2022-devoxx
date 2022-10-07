package com.datastax.todo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraOperations;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.todo.todo.TodoEntity;
import com.datastax.todo.todo.TodoRepositorySimpleCassandra;

@SpringBootTest
public class E03_SpringDataCassandraOperationsTest {

    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E02_SpringDataRepositoryTest.class);
    
    @Autowired
    CassandraOperations cassandraOps;
    
    @Autowired
    CqlSession cqlSession;
    
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
        //TodoRepositorySimpleCassandra todoRepoSimple = 
        //        new TodoRepositorySimpleCassandra(cqlSession, cassandraOps);
        TodoEntity e = todoRepoSimple.save(new TodoEntity("Apprendre Cassandra", 0));
        LOGGER.info("Tache enregistree avec id {}", e.getUid());
        
        LOGGER.info("Liste des Taches");
        todoRepoSimple.findAll().stream().map(Object::toString).forEach(LOGGER::info);
    }
    
}
