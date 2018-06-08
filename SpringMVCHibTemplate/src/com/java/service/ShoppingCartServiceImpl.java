package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
