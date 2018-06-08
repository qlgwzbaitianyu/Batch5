package com.java.repository;

import java.util.List;

import com.java.bean.Category;
import com.java.bean.ShoppingCart;

public interface ShoppingCartRepository {
	/*
	 * get all the category objects from the db
	 * input: null
	 * output: list of Category objects
	 * */
	public ShoppingCart findShoppingCartById(int id);

}
