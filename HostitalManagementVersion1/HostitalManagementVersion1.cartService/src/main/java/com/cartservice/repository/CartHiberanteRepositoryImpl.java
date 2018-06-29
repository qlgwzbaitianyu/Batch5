//package com.cartservice.repository;
//
//import java.util.Map;
//
//import org.hibernate.Session;
//import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.cartservice.dto.Cart;
//import com.cartservice.dto.Product;
//
//@Transactional
//@Repository
//public class CartHiberanteRepositoryImpl  extends HibernateDaoSupport implements CartHibernateRepository {
//
//	@Override
//	public void addProductToCart(Cart shoppingCart, Product product) {
//		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
//		Map<String, Integer> productMap = shoppingCart.getProductsInCart();
//
//		if(productMap.containsKey(product.getProductName())) {			/* already have item in the cart*/
//			Integer value = productMap.get(product.getProductName());
//			productMap.put(product.getProductName(), value+1);
//		}
//		else {	/* first time put this product in cart*/
//			productMap.put(product.getProductName(), 1);
//		}
//		shoppingCart.setProductsInCart(productMap);
//		//shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + product.getPrice());	/* update total price*/
//		session.update(shoppingCart);
//
//	}
//
//	@Override
//	public void delete(Cart shoppingCart, Product product) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//
//}
