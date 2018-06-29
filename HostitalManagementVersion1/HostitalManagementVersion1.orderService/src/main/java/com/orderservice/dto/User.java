package com.orderservice.dto;

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
	String password;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name ="cartForiegnKey")
	Cart shoppingCart;
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Order> orders;
	
	public int getId() {
		return id;
	}
	public User(int id, String name, String email, long contactNo) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.contactNo = contactNo;
}
	public User() {
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}