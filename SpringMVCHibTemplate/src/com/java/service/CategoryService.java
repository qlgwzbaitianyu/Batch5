package com.java.service;

import java.util.List;

import org.hibernate.Session;

import com.java.bean.Category;
import com.java.bean.Customer;
import com.java.bean.Product;

public interface CategoryService {
	/*
	 * get all the category objects from the db
	 * input: null
	 * output: list of Category objects
	 * */
	public List<Category> findAllCategory();
	
	
	public List<Product> findAllProduct(String first, String max);
	
	
	public Product findProductById(String productId);
	
	public Category findCategoryById(String categoryId);
}