package com.datastax.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import com.datastax.todo.todo.Todo;

/**
 * Implementation of integration test
 *
 * @author Cedrick LUNVEN (@clunven)
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class E04_SpringControllerTest {
    
    public static String SPRING_DATA_URL = System.getenv("SPRING_DATA_URL");
    
    @LocalServerPort
    public int port;
    
    @Test
    public void should_retrieve_todolist() {
        System.out.println(port);
        if (!StringUtils.hasLength(SPRING_DATA_URL)) {
            SPRING_DATA_URL = "http://localhost:" + port;
        }
        Assertions.assertEquals(HttpStatus.OK, 
                new TestRestTemplate().exchange(SPRING_DATA_URL + "/api/v1/todos/", 
                        HttpMethod.GET, new HttpEntity<String>(null, new HttpHeaders()), 
                        Todo[].class).getStatusCode());
    }

}

