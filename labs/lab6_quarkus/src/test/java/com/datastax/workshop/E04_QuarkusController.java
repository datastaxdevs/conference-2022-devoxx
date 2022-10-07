package com.datastax.workshop;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class E04_QuarkusController {
    
    @Test
    public void testApi() {
        given().when().get("/api/v1/clun/todos/")
               .then()
               .statusCode(200);
    }

}
