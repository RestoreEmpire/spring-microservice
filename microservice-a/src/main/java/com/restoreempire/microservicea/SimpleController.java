package com.restoreempire.microservicea;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.apache.catalina.mapper.Mapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Autowired
    AmqpTemplate template;
    
    @GetMapping("/")
    ObjectNode index() {
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("hello", "world");
        json.put("it is", "index page");
        json.put("microservice", "A");
        return json;
    }

    @GetMapping("/library")
    ObjectNode library() {
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("page", "library");
        return json;
    }

    public record MessageRequest(String message) {
    }

    @GetMapping("/rabbit")
    String rabbit(){
        var req = new MessageRequest("Hi");
        template.convertAndSend("spring-queue", "Hi");
        return req.message();
    }
    
}
