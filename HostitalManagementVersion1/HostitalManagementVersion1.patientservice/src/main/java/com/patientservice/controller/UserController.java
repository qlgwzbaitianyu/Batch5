package com.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.patientservice.dto.User;
import com.patientservice.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository repository;
	@Autowired
	RestTemplate restTemplate;
	
	/*@RequestMapping
	public String test() {
		return "hello";
	}*/
	
	@RequestMapping(method = RequestMethod.POST,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(code=HttpStatus.OK, reason="add user successfully")
	public void addUser(@RequestBody User user) {
		repository.save(user);
		/*update carservice*/
		HttpEntity<User> request = new HttpEntity<>(user);
		//restTemplate.postForObject("http://localhost:8773/users", request, User.class);
		restTemplate.postForObject("http://CartService/users", request, User.class);
		
		/*update orderservice*/
		HttpEntity<User> request2 = new HttpEntity<>(user);
		restTemplate.postForObject("http://OrderService/users", request2, User.class);
	}
	
}
