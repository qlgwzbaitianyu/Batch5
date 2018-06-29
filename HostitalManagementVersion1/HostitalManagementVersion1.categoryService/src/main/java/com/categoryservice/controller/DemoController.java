package com.categoryservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cat")
public class DemoController {
	@RequestMapping("/test")
	public String test() {
		return "hello";
	}
}
