package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.bean.Product;
import com.java.bean.ShoppingCart;
import com.java.repository.CategoeryRepository;
import com.java.repository.ShoppingCartRepository;

@Transactional
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Override
	public ShoppingCart findShoppingCartById(int id) {
		return shoppingCartRepository.findShoppingCartById(id);
	}

	@Override
	public void addProductToCart(ShoppingCart shoppingCart, Product product) {
		shoppingCartRepository.addProductToCart(shoppingCart, product);
	}

	@Override
	public void removeProductInCart(ShoppingCart shoppingCart, Product product) {
		shoppingCartRepository.removeProductInCart(shoppingCart, product);
	}

	@Override
	public void makePayment(ShoppingCart shoppingCart) {
		shoppingCartRepository.makePayment(shoppingCart);
	}
	
	

}
