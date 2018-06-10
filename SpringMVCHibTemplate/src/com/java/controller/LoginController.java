package com.java.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

import com.java.bean.Category;
import com.java.bean.Customer;
import com.java.bean.ShippingAddress;
import com.java.bean.Employee;
import com.java.bean.Login;
import com.java.bean.Product;
import com.java.dbutil.HibernateUtil;
import com.java.service.CategoryService;
import com.java.service.CustomerService;
import com.java.service.CustomerServiceImpl;

@Controller
public class LoginController {
	@Autowired
	CustomerService customerService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/")
	public ModelAndView startPage(Model model, String first, String max) { 
		ModelAndView mv = new ModelAndView("homePage");
		List<Product> productList = null;
		long productCount;
		
		List<Category> categoryList = categoryService.findAllCategory(); 	/* read the category from db and add to model*/
		if(first == null) {				/* pass pagenation param*/
			productList = categoryService.findAllProduct("1", "4");
		}
		else {
			productList = categoryService.findAllProduct(first, max);
		}
		productCount = categoryService.findProductCount();	/*get the number of products*/
		
		mv.addObject("categoryList", categoryList);
		mv.addObject("productList", productList);
		mv.addObject("productCount", productCount);
		return mv;
	}
	
	
	@RequestMapping("/log")
	public ModelAndView toLogIn(HttpServletRequest request) { 
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginMsg", "Welcome to log in page");
		//mv.addObject("customer", new Customer());
		mv.addObject("loginobj", new Login());
		return mv;
	}
	@RequestMapping(path="/login")
	public String login(@ModelAttribute("loginobj") Login login, HttpServletRequest request, BindingResult result, Model model) { 
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.addObject("errorMsg", "Invalid Format of Input Try it again");
			return "errors";
		}
		
		if(login.getUserName().equals(null) || login.getPassWord().equals(null)) {
			mv.addObject("errorMsg", "UserName or PassWord Can Not Be Empty");
			return "errors";
		}
		
		Customer customer = new Customer();
		customer.setUserName(login.getUserName());
		customer.setPassWord(login.getPassWord());
		
		Customer customerResult = customerService.validation(customer, null);
		if(customerResult != null) {			 //valid user save into session 
			System.out.println(customerResult);
			HttpSession session = request.getSession();
			session.setAttribute("customer", customerResult);
			return "forward:/";
		}
		else {
			model.addAttribute("errorMsg", "wrong name or password");
			return "error";
		}
	}
	/*@RequestMapping(path="/login")
	public String login(@Valid @ModelAttribute("customer") Customer customer, HttpServletRequest request, BindingResult result, Model model) { 
		System.out.println("~~ in login controller ~~");
		if(result.hasErrors()) {
			System.out.println("!!! in error !!!!");
			return "login";
		}
		
		ModelAndView mv = new ModelAndView();
		Customer customerResult = customerService.validation(customer, null);
		if(customerResult != null) {			 //valid user save into session 
			System.out.println(customerResult);
			HttpSession session = request.getSession();
			session.setAttribute("customer", customerResult);
			return "forward:/";
		}
		else {
			model.addAttribute("errorMsg", "wrong name or password");
			//mv.addObject("errorMsg", "wrong name or password");
			return "error";
		}
	}*/
	
	
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
			return "forward:/";
		}
		
		return "error";
	}
	
	@RequestMapping("/goHome")
	public String toHome() { 
		return "forward:/";
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "forward:/";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMsg", "General Exception: Please try again");

		return model;

	}
}
