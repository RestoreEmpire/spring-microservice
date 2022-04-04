package com.restoreempire.microserviceab;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceABApplication {


	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}

	

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceABApplication.class, args);
	}

}
