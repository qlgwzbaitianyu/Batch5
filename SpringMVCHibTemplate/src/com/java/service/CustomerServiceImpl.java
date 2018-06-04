package com.java.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java.bean.Customer;
import com.java.bean.ShippingAddress;
import com.java.repository.CustomerRepository;
import com.java.repository.CustomerRepositoryImpl;
import com.java.repository.CustomRepositoryHibTemp;
//import com.java.repository.CustomerRepository1;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	@Qualifier("rep1")
	private CustomerRepository customerRepository;
	
	@Autowired
	@Qualifier("rep2")
	private CustomRepositoryHibTemp customerRepository2;
	
	//@Autowired
	//private CustomerRepository1 employeeRepository;
	
	@Override
	public Customer validation(Customer customer, Session hibernateSession) {
		return customerRepository2.validation(customer);
	}

	@Override
	public boolean register(Customer customer, ShippingAddress shippingAddress, Session hibernateSession) {
		return customerRepository.register(customer, shippingAddress);
	}

	@Override
	public boolean register2(Customer customer, ShippingAddress shippingAddress) {
		return customerRepository2.register(customer, shippingAddress);
	}
	
	
	
	
	
	

}
