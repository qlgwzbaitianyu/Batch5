package com.gatewayAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;



@SpringBootApplication
@EntityScan("com")
@EnableEurekaClient
@EnableZuulProxy
public class GatewayAPIAPP {
	public static void main(String[] args) {
		SpringApplication.run(GatewayAPIAPP.class, args);
	}
}
