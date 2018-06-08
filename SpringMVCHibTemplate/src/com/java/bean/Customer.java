package com.java.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
/*import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TermVector;*/
import org.springframework.stereotype.Component;

import com.java.bean.IsValidPhoneNumber;

import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column(name="userName", unique=true, nullable=false)
	@NotBlank
	@Size(min=4, max=6)
	String userName;
	
	@NotBlank
	String passWord;
	
	//@NotBlank
	//@Email
	String email;
	
	@OneToOne
	@JoinColumn(name ="shippingForiegnKey")
	//@IsValidPhoneNumber(message="wrong shipping address")
	ShippingAddress shippingAddress;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name ="cartForiegnKey")
	//@Fetch(FetchMode.SELECT)
    //@BatchSize(size = 10)
	ShoppingCart shoppingCart;
	
	String phoneNumber;

	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
		this.shippingAddress = new ShippingAddress();
		this.shoppingCart = new ShoppingCart();
	}
	
	
	
	public Customer(Integer customerId, @NotBlank @Size(min = 4, max = 6) String userName, @NotBlank String passWord,
			String email, ShippingAddress shippingAddress, ShoppingCart shoppingCart, String phoneNumber) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.shippingAddress = shippingAddress;
		this.shoppingCart = shoppingCart;
		this.phoneNumber = phoneNumber;
	}



	public Customer(Integer customerId, String userName, String passWord, String email,
			ShippingAddress shippingAddress) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.shippingAddress = shippingAddress;
	}
	
	public Customer(Integer customerId, @NotBlank @Size(min = 4, max = 6) String userName, @NotBlank String passWord,
			@NotBlank @Email String email, ShippingAddress shippingAddress, String phoneNumber) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.shippingAddress = shippingAddress;
		this.phoneNumber = phoneNumber;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}



	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	@Override
	public String toString() {
		return this.userName + " " + this.passWord + " " + this.getShippingAddress().getStreet() + " " + this.getShippingAddress().getCity();
	}
	
	

}
