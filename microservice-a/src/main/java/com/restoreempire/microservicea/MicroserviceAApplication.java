package com.restoreempire.microservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAApplication.class, args);
	}

}
