package com.java.service;

import com.java.bean.ShoppingCart;

public interface ShoppingCartService {
	/*
	 * get all the category objects from the db
	 * input: null
	 * output: list of Category objects
	 * */
	public ShoppingCart findShoppingCartById(int id);
}
