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

}
