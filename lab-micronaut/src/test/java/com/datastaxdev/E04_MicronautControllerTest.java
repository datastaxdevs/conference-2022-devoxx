package com.datastaxdev;


import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
public class E04_MicronautControllerTest {
    
    /** Logger for the class. */
    static Logger LOGGER = LoggerFactory.getLogger(E04_MicronautControllerTest.class);
    
    @Inject
    EmbeddedApplication<?> application;
    
    @Inject
    @Client("/api/v1/")
    HttpClient client;
    
    @Test
    public void testRunApplication() {
        Assertions.assertTrue(application.isRunning());
        HttpRequest<String> request = HttpRequest.GET("/clun/todos");
        List<TodoDto> todos = client.toBlocking().retrieve(request, Argument.listOf(TodoDto.class));
        assertFalse(todos.isEmpty());
        LOGGER.info("{} task retrieved", todos.size());
    }

}
