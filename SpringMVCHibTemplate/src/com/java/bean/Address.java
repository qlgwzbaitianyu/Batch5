package com.java.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("address1")
public class Address {
	
	@Value("caraway")
	private String street;
	@Value("12345")
	private int zipcode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, int zipcode) {
		super();
		this.street = street;
		this.zipcode = zipcode;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
