package com.restoreempire.microserviceab;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {

    private List<String> list;
    
    public SimpleController() {
       list = new ArrayList<>();
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    String index() {
        String microserviceA = restTemplate.getForObject("http://SERVICE-A/", String.class);
        return microserviceA;
    }

    @GetMapping("/rabbit")
    List<String> rabbit() {
        return list;
    }

    @RabbitListener(queues = "spring-queue")
    private void listener(String input) {
        list.add(input);
    }

}
