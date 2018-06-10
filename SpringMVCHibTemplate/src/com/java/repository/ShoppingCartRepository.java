package com.java.repository;

import java.util.List;

import com.java.bean.Category;
import com.java.bean.Product;
import com.java.bean.ShoppingCart;

public interface ShoppingCartRepository {
	/*
	 * get all the category objects from the db
	 * input: null
	 * output: list of Category objects
	 * */
	public ShoppingCart findShoppingCartById(int id);
	/*
	 * add Product to shoppingCart
	 * input: product object
	 * output: void
	 * */
	public void addProductToCart(ShoppingCart shoppingCart, Product product);
	/*
	 * add Product to shoppingCart
	 * input: product object
	 * output: void
	 * */
	public void removeProductInCart(ShoppingCart shoppingCart, Product product);
	/*
	 * make payment on the shopping cart
	 * input: shoppingCart object
	 * output: void
	 * */
	public void makePayment(ShoppingCart shoppingCart);

}
