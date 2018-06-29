package com.cartservice.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cartservice.dto.Cart;
import com.cartservice.dto.Product;
import com.cartservice.dto.User;
//import com.cartservice.repository.CartHibernateRepository;
import com.cartservice.repository.CartRepository;
import com.cartservice.repository.ProductRepository;
import com.cartservice.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	//@Autowired
	//CartHibernateRepository repository;
	@Autowired
	CartRepository repository2;
	@Autowired
	UserRepository userrepository;
	@Autowired
	ProductRepository productrepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
	@RequestMapping("/test")
	@HystrixCommand(fallbackMethod="test_fallback", commandProperties= {
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="60000"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="30"),
			@HystrixProperty(name="circuitBreaker.enabled", value="true")
	})
	public ResponseEntity<String> test() {
		//String result = restTemplate.getForObject(new URI("http://OrderService/test"), String.class);
		//restTemplate.exchange("http://OrderService/test", HttpMethod.GET, null, String.class);
		return restTemplate.exchange("http://OrderService/test", HttpMethod.GET, null, String.class);
	}
	
	//@ResponseStatus(code=HttpStatus.BAD_GATEWAY, reason="Order service not responding. Plz try again later")
	public ResponseEntity<String> test_fallback() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%this is from fall call back");
		ResponseEntity<String> entity = new ResponseEntity<>("this is from fall call back", HttpStatus.ACCEPTED);
		return entity;
	}
	
	/****************************/
	
	
	@RequestMapping(value="/addproduct", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(code=HttpStatus.OK, reason="add product to cart successfully")
	public void addProduct(@RequestParam("userId") int userId, @RequestParam("productId") int productId) {
		User user = userrepository.findOne(userId);
		Cart shoppingCart = user.getShoppingCart();
		Product product = productrepository.findOne(productId);
		
		Map<String, Integer> productMap = shoppingCart.getProductsInCart();
		if(productMap.containsKey(product.getProductName())) {			/* already have item in the cart*/
			Integer value = productMap.get(product.getProductName());
			productMap.put(product.getProductName(), value+1);
		}
		else {	/* first time put this product in cart*/
			productMap.put(product.getProductName(), 1);
		}
		shoppingCart.setProductsInCart(productMap);
		shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + product.getPrice());
		repository2.save(shoppingCart);
		
		/*update payment service's cart info*/
		HttpEntity<Cart> request = new HttpEntity<>(shoppingCart);
		restTemplate.postForObject("http://OrderService/payment/addproduct/{id}", request, Cart.class, userId);
	}
	
//	@ResponseStatus(code = 500, reseaon="xxx")
//	public void addProduct_fallback(@RequestParam("userId") int userId, @RequestParam("productId") int productId) {
//		// how to handle it wile it is not 
//		// logging the error
//	}
	
	
	@RequestMapping(value="/deleteproduct", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(code=HttpStatus.OK, reason="add product to cart successfully")
	public void deleteProduct(@RequestParam("userId") int userId, @RequestParam("productId") int productId) {
		User user = userrepository.findOne(userId);
		Cart shoppingCart = user.getShoppingCart();
		Product product = productrepository.findOne(productId);
		Map<String, Integer> productMap = shoppingCart.getProductsInCart();
		
		if(productMap.containsKey(product.getProductName())) {			/* already have item in the cart*/
			Integer value = productMap.get(product.getProductName());
			if(value > 1) {
				productMap.put(product.getProductName(), value-1);
			}
			else {
				productMap.remove(product.getProductName());
			}
		}
		shoppingCart.setProductsInCart(productMap);
		shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() - product.getPrice());	/* update total price*/
		repository2.save(shoppingCart);
		
		HttpEntity<Cart> request = new HttpEntity<>(shoppingCart);
		restTemplate.postForObject("http://OrderService/payment/addproduct/{id}", request, Cart.class, userId);
	}
	
	
	
	/*clear the shopping cart base on  the request from payment service*/
	@PostMapping(value="/clear/{userId}")
	@ResponseStatus(code=HttpStatus.OK, reason="clear successfully")
	public void clear(@PathVariable("userId") int userId) {
		System.out.println("enter clear!!");
		
		User user = userrepository.findOne(userId);
		
		System.out.println("enter clear!!" + user.getEmail());
		
		Cart shoppingCart = user.getShoppingCart();
		
		System.out.println("enter clear!!" + shoppingCart.getTotalPrice());
		
		Map<String, Integer> productMap = shoppingCart.getProductsInCart();
		shoppingCart.setTotalPrice(0);
		productMap.clear();
		repository2.save(shoppingCart);
	}
	
	
	
	
	

}
