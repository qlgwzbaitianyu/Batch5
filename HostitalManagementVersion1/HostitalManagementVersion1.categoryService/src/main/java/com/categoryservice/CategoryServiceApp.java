package com.categoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.categoryservice.dto")
@EnableJpaRepositories(basePackages="com.categoryservice.repository")
@EnableEurekaClient
public class CategoryServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(CategoryServiceApp.class, args);
	}

}
