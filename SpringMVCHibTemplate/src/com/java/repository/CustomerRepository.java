package com.java.repository;

import org.hibernate.Session;

import com.java.bean.Customer;
import com.java.bean.ShippingAddress;

public interface CustomerRepository {
	/*
	 * verify whether the customer is valid in database
	 * input: customer obj
	 * output: the corresponing customer obj if valid or NUll
	 * */
	public Customer validation(Customer customer);
	
	/*
	 * register customer in database
	 * input: customer obj
	 * output: registation success or not
	 * */
	public boolean register(Customer customer, ShippingAddress shippingAddress);
}
