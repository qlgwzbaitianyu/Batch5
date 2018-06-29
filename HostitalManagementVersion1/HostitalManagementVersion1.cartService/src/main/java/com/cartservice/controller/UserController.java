package com.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cartservice.dto.Cart;
import com.cartservice.dto.User;
import com.cartservice.repository.CartRepository;
import com.cartservice.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	CartRepository cartRepository;
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.POST,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(code=HttpStatus.OK, reason="add user successfully")
	public void addUser(@RequestBody User user) {
		Cart cart = new Cart();
		cartRepository.save(cart);
		user.setShoppingCart(cart);
		userRepository.save(user);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(code=HttpStatus.OK, reason="add user successfully")
	public ResponseEntity<List<User>> getUser() {
		return ResponseEntity.ok().body(userRepository.findAll());
	}


}
