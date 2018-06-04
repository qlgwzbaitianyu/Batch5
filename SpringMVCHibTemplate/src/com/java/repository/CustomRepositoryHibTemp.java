package com.java.repository;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.java.bean.Customer;
import com.java.bean.ShippingAddress;

@Repository("rep2")
public class CustomRepositoryHibTemp implements CustomerRepository {
	@Autowired
	HibernateTemplate template;
	
	public int save(Customer e) {
		int id=(int) template.save(e);
		return id;
	}

	@Override
	public Customer validation(Customer customer) {
		Customer mycustomer = null;
		List list = template.findByNamedParam("from Customer where userName=:userName", "userName", customer.getUserName()); 
		Iterator it = list.iterator();
		if(it.hasNext()) {
			mycustomer = (Customer) it.next();		/* userName is unique so only one or null result may resturn*/
		}  
		
		if(mycustomer == null) {
			System.out.println("customer is null");
			return null;
		}
		
		if(mycustomer != null && customer.getPassWord().equals(mycustomer.getPassWord())) {
			System.out.println("customer is not !! null");
			return mycustomer;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean register(Customer customer, ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		template.setCheckWriteOperations(false);
		template.save(shippingAddress);
		template.save(customer);
		return true;
	}
	
	
	
	

}



/*package com.java.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.java.dto.Employee;

@Repository("empRep")
public class EmployeeRepository {
	
	@Autowired
	SessionFactory factory;
	@Autowired
	HibernateTemplate template;
	
	

	public int save(Employee e) {
	
		int id=(int) template.save(e);
		return id;
	}

	public Employee findById(int id) {

		Employee e1=(Employee) template.executeWithNativeSession(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Employee e1= 	session.get(Employee.class, id);//persistent
				session.beginTransaction();
				e1.setName("Parul");
				e1.setName("Payal");
				session.getTransaction().commit();
				return e1;
			}
			
		});
		return e1;
	}

	public List<Employee> findAll() {
		DetachedCriteria cr= DetachedCriteria.forClass(Employee.class);
		return (List<Employee>) template.findByCriteria(cr);
	}

	public void deleteById(int id) {
		template.delete(id);
		
	}

}
*/