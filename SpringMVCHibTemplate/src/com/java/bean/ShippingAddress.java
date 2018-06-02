package com.java.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ShippingAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shippingAddressId;
	@NotBlank
	@NotNull (message="wrong street !!")
	private String street;
	@NotBlank
	@NotNull (message="wrong city !!")
	private String city;
	private String state;
	private int zipcode;
	
	
	public ShippingAddress(Integer shippingAddressId, String street, String city, String state, int zipcode) {
		super();
		this.shippingAddressId = shippingAddressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public ShippingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	

}
