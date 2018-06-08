package com.java.bean;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cartId;
	
	double totalPrice = 0;
	
	@ElementCollection
	@CollectionTable(name="cartProducts", joinColumns=@JoinColumn(name="cartId"))
	private Map<String, Integer> productsInCart;

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

	public ShoppingCart(int cartId, Map<String, Integer> productsInCart) {
		super();
		this.cartId = cartId;
		this.productsInCart = productsInCart;
	}

	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ShoppingCart(int cartId, double totalPrice, Map<String, Integer> productsInCart) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.productsInCart = productsInCart;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", productsInCart=" + productsInCart + "]";
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
	
}
