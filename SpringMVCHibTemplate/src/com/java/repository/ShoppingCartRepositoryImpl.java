package com.java.repository;

import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.bean.Category;
import com.java.bean.Product;
import com.java.bean.ShoppingCart;

@Transactional
@Repository
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {
	@Autowired
	HibernateTemplate template;
	
	
	@Override
	public ShoppingCart findShoppingCartById(int id) {
		Session session = template.getSessionFactory().getCurrentSession();
		String hql = "FROM ShoppingCart s WHERE s.id = :shoppingcart_id";
		Query query = session.createQuery(hql);
		query.setParameter("shoppingcart_id",id);
		
		ShoppingCart cart = (ShoppingCart)query.getSingleResult();
		cart.getProductsInCart();
		for (Map.Entry<String, Integer> item : cart.getProductsInCart().entrySet()) {
		}
		System.out.println(cart.getTotalPrice());
		return cart;
	}


	@Override
	public void addProductToCart(ShoppingCart shoppingCart, Product product) {
		Session session = template.getSessionFactory().getCurrentSession();
		Map<String, Integer> productMap = shoppingCart.getProductsInCart();
		
		if(productMap.containsKey(product.getName())) {			/* already have item in the cart*/
			Integer value = productMap.get(product.getName());
			productMap.put(product.getName(), value+1);
		}
		else {	/* first time put this product in cart*/
			productMap.put(product.getName(), 1);
		}
		shoppingCart.setProductsInCart(productMap);
		shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + product.getPrice());	/* update total price*/
		session.update(shoppingCart);
	}


	@Override
	public void removeProductInCart(ShoppingCart shoppingCart, Product product) {
		Session session = template.getSessionFactory().getCurrentSession();
		Map<String, Integer> productMap = shoppingCart.getProductsInCart();
		
		if(productMap.containsKey(product.getName())) {			/* already have item in the cart*/
			Integer value = productMap.get(product.getName());
			if(value > 1) {
				productMap.put(product.getName(), value-1);
			}
			else {
				productMap.remove(product.getName());
			}
		}
		shoppingCart.setProductsInCart(productMap);
		shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() - product.getPrice());	/* update total price*/
		session.update(shoppingCart);
	}


	@Override
	public void makePayment(ShoppingCart shoppingCart) {
		Session session = template.getSessionFactory().getCurrentSession();
		Map<String, Integer> productMap = shoppingCart.getProductsInCart();
		
		productMap.clear();				/*clear the map and 0 the price*/
		shoppingCart.setProductsInCart(productMap);
		shoppingCart.setTotalPrice(0);
		session.update(shoppingCart);
	}
	
	
	
}
