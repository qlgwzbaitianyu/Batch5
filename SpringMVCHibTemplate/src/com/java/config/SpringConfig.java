package com.java.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.java.bean.Customer;
import com.java.bean.Employee;
import com.java.bean.ShippingAddress;

@Configuration
@ComponentScan(basePackages="com.java")
@PropertySource({"classpath:database.properties"})
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer{
	
	@Autowired
	Environment ev;
	

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver obj = new InternalResourceViewResolver();
		obj.setPrefix("/WEB-INF/view/");
		obj.setSuffix(".jsp");
		return obj;
	}
	
	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(ev.getProperty("driver"));
        dataSource.setUrl(ev.getProperty("url"));
        dataSource.setUsername(ev.getProperty("username1"));
        dataSource.setPassword(ev.getProperty("password"));
        return dataSource;
    }
	
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory() {
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource());
	    sessionBuilder.addAnnotatedClasses(Customer.class);
	    sessionBuilder.addAnnotatedClasses(ShippingAddress.class);
	    sessionBuilder.addProperties(hibernateProperties());
	    return sessionBuilder.buildSessionFactory();
	}
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;        
    }
	
	
	/*@Bean("transactionManager")
	public JpaTransactionManager myTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				getSessionFactory());
		return transactionManager;
		
	}*/
	
	@Bean
	public HibernateTemplate template() {
		HibernateTemplate template= new HibernateTemplate(getSessionFactory());
	
		return template;
	}
	
	@Bean("transactionManager")
	public HibernateTransactionManager transactionManager(){
	     return new HibernateTransactionManager(getSessionFactory());
	}
	
	@Bean("Customer")
	public Customer getCustomer() {
		return new Customer();
	}
	
}