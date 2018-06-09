package com.java.repository;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import com.java.bean.Product;
import com.java.bean.*;

public interface CategoeryRepository {
	
	/*
	 * get all the category objects from the db
	 * input: null
	 * output: list of Category objects
	 * */
	public List<Category> findAllCategory();
	/*
	 * get all the category objects from the db
	 * input: null
	 * output: list of Category objects
	 * */
	public List<Product> findAllProduct(String first, String max);
	
	/*
	 * get all the category objects from the db
	 * input: String productId
	 * output: corresponding Product Object
	 * */
	public Product findProductById(String productId);
	/*
	 * find prduct base on name
	 * input: String productName
	 * output: corresponding Product Object
	 * */
	public Product findProductByName(String productName);
	/*
	 * get all the category objects from the db
	 * input: String productId
	 * output: corresponding Product Object
	 * */
	public Category findCategoryById(String categoryId);


}
