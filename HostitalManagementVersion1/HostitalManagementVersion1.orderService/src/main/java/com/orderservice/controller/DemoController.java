package com.orderservice.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {
	static Random rand = new Random();
	static int r = rand.nextInt();
	
	
	@RequestMapping()
	public String test(HttpServletRequest request) {
		return "hello from orderservice !! " + request.getRemotePort() + "xx " + request.getLocalPort() + "xx" +  request.getServerPort();
	}
}
