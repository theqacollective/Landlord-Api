package com.qa.landlordGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableDiscoveryClient
public class LandlordApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandlordApiApplication.class, args);
	}

}
