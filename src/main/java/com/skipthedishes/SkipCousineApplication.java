package com.skipthedishes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SkipCousineApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SkipCousineApplication.class, args);
	}
}
