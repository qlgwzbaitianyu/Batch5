package com.java.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.bean.Customer;
import com.java.bean.ShippingAddress;

@Repository("rep1")
public class CustomerRepositoryImpl implements CustomerRepository {
	
	@Autowired
	private SessionFactory hiberbatesession;

	@Override
	public Customer validation(Customer customer) {
		Customer customerResult = null;
		Customer mycustomer = null;
		
		Session s = hiberbatesession.openSession();
		Transaction tx = s.beginTransaction();			/*get hibernate seesion*/
		String hql = "FROM Customer c WHERE c.userName = :userName ";	/* hibernate native sql */
		Query query = s.createQuery(hql);
		query.setParameter("userName", customer.getUserName());
		List results = query.list();
		Iterator it = results.iterator();
		if(it.hasNext()) {
			mycustomer = (Customer) it.next();		/* userName is unique so only one or null result may resturn*/
		}
		tx.commit();
		
		if(mycustomer == null) {
			System.out.println("customer is null");
			customerResult = null;
		}
		if(mycustomer != null && customer.getPassWord().equals(mycustomer.getPassWord())) {
			System.out.println("customer is not !! null");
			customerResult = mycustomer;
		}
		else {
			customerResult = null;
		}
		s.close();
		return customerResult;
	}

	@Override
	public boolean register(Customer customer,  ShippingAddress shippingAddress) {
		 boolean registerResult = false;
		 Session s = hiberbatesession.openSession();
		    try {
		    	Transaction tx = s.beginTransaction();
		    	s.save(customer.getShippingAddress());		/* save customer and corresponding shipping address*/
				s.save(customer);
				tx.commit();
				s.close();
		        registerResult = true;  		/* use try catch to ensure the hibernate execution status*/
		    } catch (HibernateException r) {
		    	r.printStackTrace();
		    }
		    finally {
		    	s.close();
		    }
		    
		return registerResult;
	}

}
