package com.ak.eventapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.ak.eventapi.config", 
		"com.ak.eventapi.service.impl", 
		"com.ak.eventapi.dao.impl", 
		"com.ak.eventapi.api",
		"com.ak.eventapi.security.jwt"}
		)
public class EventAPISpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(EventAPISpringBootApplication.class, args);
	}
}
