package com.java.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.bean.Category;
import com.java.bean.Employee;
import com.java.bean.Product;

@Repository
@Transactional
public class CategoeryRepositoryImpl implements CategoeryRepository {
	@Autowired
	HibernateTemplate template;
	
	
	@Override
	public List<Category> findAllCategory() {
		
		DetachedCriteria cr= DetachedCriteria.forClass(Category.class);
		List<Category> categoryList = (List<Category>) template.findByCriteria(cr);
		System.out.println("*****  the size of categorylist is: " + categoryList.size());
		return categoryList;
	}


	@Override
	public List<Product> findAllProduct(String first, String max) {
		Session session = template.getSessionFactory().getCurrentSession();
		Query<Product> q = session.createQuery("from Product");
		q.setFirstResult(Integer.parseInt(first));
		q.setMaxResults(Integer.parseInt(max));
		List<Product> productList = q.list();
		
		return productList;
	}


	@Override
	public Product findProductById(String productId) {
		Session session = template.getSessionFactory().getCurrentSession();
		String hql = "FROM Product p WHERE p.id = :product_id";
		Query query = session.createQuery(hql);
		query.setParameter("product_id",Long.parseLong(productId));
		
		return (Product)query.getSingleResult();
		
	}


	@Override
	public Category findCategoryById(String categoryId) {
		Session session = template.getSessionFactory().getCurrentSession();
		String hql = "FROM Category c WHERE c.id = :category_id";
		Query query = session.createQuery(hql);
		query.setParameter("category_id",Long.parseLong(categoryId));
		
		Category category = (Category)query.getSingleResult();
		Set<Product> productSet = category.getProducts();
		
		for(Product p : productSet) {
		}
		
		return category;
	}


	@Override
	public Product findProductByName(String productName) {
		System.out.println("in category repository the product name is: " + productName);
		Session session = template.getSessionFactory().getCurrentSession();
		String hql = "FROM Product p WHERE p.name = :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name",productName);
		
		return (Product)query.getSingleResult();
		
	}
	
	

}
