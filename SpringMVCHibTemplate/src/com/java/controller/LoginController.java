package com.java.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.java.bean.Customer;
import com.java.bean.ShippingAddress;
import com.java.bean.Employee;
import com.java.dbutil.HibernateUtil;
import com.java.service.CustomerService;
import com.java.service.CustomerServiceImpl;

@Controller
public class LoginController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/")
	public ModelAndView startPage(Model model) { 
		ModelAndView mv = new ModelAndView("homePage");
		 mv.addObject("Customer", new Customer());
		return mv;
	}
	
	
	@RequestMapping("/log")
	public ModelAndView toLogIn(HttpServletRequest request) { 
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginMsg", "Welcome to log in page");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute ("Customer")Customer customer, HttpServletRequest request, BindingResult result) { 
		ModelAndView mv = new ModelAndView("homePage");
		Customer customerResult = customerService.validation(customer, null);
		if(customerResult != null) {			/* valid user save into session */
			System.out.println(customerResult);
			HttpSession session = request.getSession();
			session.setAttribute("customer", customerResult);
			mv.setViewName("homePage");
		}
		else {
			mv.setViewName("error");
			mv.addObject("errorMsg", "wrong name or password");
		}
		
		return mv;
	}
	
	
	
	@RequestMapping("/upd")
	public ModelAndView toUpdate() { 
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("Customer", new Customer());
		return mv;
	}
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String saveEmployee(@Valid  @ModelAttribute ("Customer")Customer customer, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "update";
		}
		if(customerService.register2(customer, customer.getShippingAddress())) {	/* register success */
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			return "homePage";
		}
		
		return "error";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/goHome")
	public ModelAndView toHome() { 
		ModelAndView mv = new ModelAndView("homePage");
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logOut(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("homePage");
		HttpSession session = request.getSession();
		//session.setAttribute("customer", null);
		session.invalidate();
		return mv;
	}
	

	
	
	
	
	
	
	/*@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView submit(@ModelAttribute("file") MultipartFile file, ModelMap modelMap) {
		ModelAndView mv = new ModelAndView("fileUploadView");
		mv.addObject("file", file);
	    //modelMap.addAttribute("file", file);
	    return mv;
	}*/

}
