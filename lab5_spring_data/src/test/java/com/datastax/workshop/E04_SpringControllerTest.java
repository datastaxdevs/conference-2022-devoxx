package com.datastax.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.datastax.workshop.todo.Todo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class E04_SpringControllerTest {

    @LocalServerPort 
    private int port;
    
    TestRestTemplate restTemplate = new TestRestTemplate();
    
    @Test
    public void should_retrieve_todolist_v0() {
        HttpHeaders        headers = new HttpHeaders();
        HttpEntity<String> entity  = new HttpEntity<String>(null, headers);
        ResponseEntity<Todo[]> response = restTemplate.exchange(
             createURLWithPort("/api/v1/todos/"), HttpMethod.GET, entity, Todo[].class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
    

}

