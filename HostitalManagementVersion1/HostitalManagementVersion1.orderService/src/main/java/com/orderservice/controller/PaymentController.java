package com.orderservice.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.orderservice.dto.Cart;
import com.orderservice.dto.Order;
import com.orderservice.dto.User;
import com.orderservice.repository.CartRepository;
import com.orderservice.repository.OrderRepository;
import com.orderservice.repository.UserRepository;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.OK, reason="making payment successful")
	/*@HystrixCommand(fallbackMethod="addProduct_fallback", commandProperties= {
			
	})*/
	public void checkOut(@PathVariable int id) {
		System.out.println(id);
		// get user
		User u = userRepository.findOne(id);
		System.out.println(u.getName());
		// update shoping cart
		Cart c = u.getShoppingCart();
		// create order
		Order o = new Order(c.getTotalPrice(), u);
		// update shopping cart
		c.setTotalPrice(0);
		orderRepository.save(o);
		
		/* update cart service */
		HttpEntity<Cart> request = new HttpEntity<>(c);
		restTemplate.postForObject("http://CartService/carts/clear/{userId}", request, Cart.class, id);
	}
	
	
	/* add product to shopping cart, update totalprice in cart*/
	@RequestMapping(
			value="/addproduct/{id}",
			method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.OK, reason="update cart")
	public void addProduct(@PathVariable int id, @RequestBody Cart cart) {
		User u = userRepository.findOne(id);
		Cart c = u.getShoppingCart();
		c.setTotalPrice(cart.getTotalPrice());
		cartRepository.save(c);
	}
	
	
	
	

}
