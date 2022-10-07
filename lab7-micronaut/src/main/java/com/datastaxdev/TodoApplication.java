package com.datastaxdev;

import io.micronaut.runtime.Micronaut;

public class TodoApplication {

    public static void main(String[] args) {
        Micronaut.run(TodoApplication.class, args);
    }
}
