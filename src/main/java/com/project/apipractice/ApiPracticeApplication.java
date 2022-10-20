package com.project.apipractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableConfigurationProperties
@SpringBootApplication
public class ApiPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPracticeApplication.class, args);
	}

}
