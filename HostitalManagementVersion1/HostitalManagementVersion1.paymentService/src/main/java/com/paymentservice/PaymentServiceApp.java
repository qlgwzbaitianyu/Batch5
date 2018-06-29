package com.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableEurekaClient
@EntityScan("com")
@EnableJpaRepositories(basePackages="com")
public class PaymentServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApp.class, args);
	}

}
