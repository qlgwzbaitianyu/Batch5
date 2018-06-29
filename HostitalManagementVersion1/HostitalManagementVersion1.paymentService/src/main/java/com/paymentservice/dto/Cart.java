package com.paymentservice.dto;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Cart {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	int cartId;
	
	@ElementCollection
	@CollectionTable(name="cartProducts", joinColumns=@JoinColumn(name="cartId"))
	private Map<String, Integer> productsInCart;
	
	double totalPrice = 0;

	public Cart(int cartId, User user, Map<String, Integer> productsInCart) {
		super();
		this.cartId = cartId;
		this.productsInCart = productsInCart;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Map<String, Integer> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(Map<String, Integer> productsInCart) {
		this.productsInCart = productsInCart;
	}
	
	
	

}
