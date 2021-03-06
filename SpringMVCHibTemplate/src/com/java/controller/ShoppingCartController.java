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
import org.springframework.http.HttpRequest;
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

import com.java.bean.Category;
import com.java.bean.Customer;
import com.java.bean.ShippingAddress;
import com.java.bean.ShoppingCart;
import com.java.bean.Employee;
import com.java.bean.Login;
import com.java.bean.Product;
import com.java.dbutil.HibernateUtil;
import com.java.service.CategoryService;
import com.java.service.CustomerService;
import com.java.service.CustomerServiceImpl;
import com.java.service.ShoppingCartService;

@Controller

public class ShoppingCartController {
	@Autowired
	ShoppingCartService shoppingCartService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/showCart")
	public ModelAndView displayProduct(HttpServletRequest request) { 
		ModelAndView mv = new ModelAndView("displayCart");
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		if(customer == null) {
			mv.addObject("loginobj", new Login());
			mv.setViewName("login");
		}
		else {
			ShoppingCart cart = shoppingCartService.findShoppingCartById(customer.getShoppingCart().getCartId());
			mv.addObject("shoppingCart", cart);
		}
		return mv;
	}
	
	@RequestMapping("/addProductToCart")
	public ModelAndView addProductToCart(HttpServletRequest request) { 
		ModelAndView mv = new ModelAndView("productAdded");
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		if(customer == null) {
			mv.addObject("loginobj", new Login());
			mv.setViewName("login");
		}
		else {
			String productId = request.getParameter("productId");
			Product product = categoryService.findProductById(productId);
			ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(customer.getShoppingCart().getCartId());
			shoppingCartService.addProductToCart(shoppingCart, product);
		}
		return mv;
	}
	
	
	@RequestMapping("/removeProductFromCart")
	public ModelAndView removeProductFromCart(HttpServletRequest request) { 
		ModelAndView mv = new ModelAndView("productRemoved");
		HttpSession session = request.getSession();
		
		Customer customer = (Customer)session.getAttribute("customer");
		String productName = request.getParameter("productName");
		Product product = categoryService.findProductByName(productName);
		ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(customer.getShoppingCart().getCartId());
		shoppingCartService.removeProductInCart(shoppingCart, product);
		return mv;
	}
	
	
	@RequestMapping("/checkOut")
	public ModelAndView checkOut(@RequestParam("totalPrice") String totalPrice) { 
		ModelAndView mv = new ModelAndView("checkOut");
		mv.addObject("totalPrice", totalPrice);
		return mv;
	}
	
	@RequestMapping("/pay")
	public String makePayment(HttpServletRequest request) { 
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(customer.getShoppingCart().getCartId());
		
		shoppingCartService.makePayment(shoppingCart);				/*empty the shopping cart*/
		return "forward:/";
	}

}
