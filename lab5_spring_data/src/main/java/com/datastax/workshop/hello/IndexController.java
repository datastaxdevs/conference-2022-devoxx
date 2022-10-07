package com.datastax.workshop.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String hello() {
        return "Todo endpoint is /api/v1/todos/";
    }
    
}