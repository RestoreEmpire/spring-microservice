package com.restoreempire.microserviceab;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public Queue queue() {
        return new Queue("spring-queue", false);
    }
    
}