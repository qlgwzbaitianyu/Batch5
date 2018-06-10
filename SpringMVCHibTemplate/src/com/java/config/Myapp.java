package com.java.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.bean.Category;
import com.java.bean.Customer;
import com.java.bean.Product;
import com.java.bean.ShippingAddress;
import com.java.bean.ShoppingCart;
import com.java.dbutil.HibernateUtil;

public class Myapp {

	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		//category 1 super computer and products
		/*Category category = new Category("SuperComputer");
        
        Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);
         
        Product laptop = new Product("MacBook", "Apple High-end laptop", 2100, category);
         
        Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499, category);
         
        Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);
        
        //Product tablet2 = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);
         
        Set<Product> products = new HashSet<Product>();
        products.add(pc);
        products.add(laptop);
        products.add(phone);
        products.add(tablet);
         
        category.setProducts(products);
        session.save(category);*/
        
        
        Category category = new Category("Food");
        
        Product pc = new Product("Chicken", "Crispy Chicken", 20, category);
         
        Product laptop = new Product("Beef", "taste steak", 80, category);
         
        Product phone = new Product("Beer", "Budlight", 4, category);
         
        Product tablet = new Product("Milk", "Organic Milk", 3, category);
        
        //Product tablet2 = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);
         
        Set<Product> products = new HashSet<Product>();
        products.add(pc);
        products.add(laptop);
        products.add(phone);
        products.add(tablet);
         
        category.setProducts(products);
        session.save(category);
		
		
		
        /**********************************************/
        
        /* save the shopping cart to customer*/
        /*ShoppingCart cart = new ShoppingCart();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("chicken", 2);
		map.put("beef", 3);
		cart.setProductsInCart(map);
		
		ShippingAddress shippingAddress = new ShippingAddress(1, "aa", "aa", "aa", 123);
		Customer customer = new Customer();
		customer.setUserName("annie");
		customer.setPassWord("123");
		customer.setEmail("annie@gmail");
		customer.setPhoneNumber("940-395-1234");
		customer.setShippingAddress(shippingAddress);
		customer.setShoppingCart(cart);
		customer.setCustomerId(1);
        
        session.save(shippingAddress);
        session.save(cart);
        session.save(customer);*/
        
		
		/*search fro shopping cart*/
		/*Customer customer2 = session.find(Customer.class, 1);
		ShoppingCart cart2 =customer2.getShoppingCart();
		Map<String, Integer> map2 = cart2.getProductsInCart();
		
		System.out.println(cart2);
		
		for (Map.Entry<String, Integer> item : map2.entrySet()) {
		    String key = item.getKey();
		    Integer value = item.getValue();
		    System.out.println("key: " + key + "  value: " + value);
		}*/
        
         
        tx.commit();
        System.out.println("done");
        session.close();       
		
		

	}

}
