package com.paymentservice.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class User {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	int id;
	String name, email;
	long contactNo;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name ="cartForiegnKey")
	Cart shoppingCart;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Order> orders;
	
	
	
//	cardDetails, //card no, expiry date, pinNo?? payment 
	
	public int getId() {
		return id;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, long contactNo, Cart shoppingCart, List<Order> orders) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.contactNo = contactNo;
	this.shoppingCart = shoppingCart;
	this.orders = orders;
}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public Cart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(Cart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	

}
