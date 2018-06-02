package com.java.service;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.java.bean.Customer;
import com.java.bean.ShippingAddress;
import com.java.bean.Employee;
import com.java.dbutil.HibernateUtil;

public interface CustomerService {
	/*
	 * verify whether the customer is valid in database
	 * input: customer obj
	 * output: the corresponing customer obj if valid or NUll
	 * */
	public Customer validation(Customer customer, Session hibernateSession);
	
	/*
	 * register customer in database
	 * input: customer obj
	 * output: registation success or not
	 * */
	public boolean register(Customer customer, ShippingAddress shippingAddress, Session hibernateSession);
	
	
	public boolean register2(Customer customer, ShippingAddress shippingAddress);

}
