package com.restoreempire.microserviceb;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.apache.catalina.mapper.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    

    @GetMapping("/")
    ObjectNode index() {
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("hello", "world");
        json.put("it is", "index page");
        json.put("microservice", "B");
        return json;
    }
}
