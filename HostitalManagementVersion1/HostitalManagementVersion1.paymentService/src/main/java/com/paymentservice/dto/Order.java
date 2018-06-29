package com.paymentservice.dto;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity()
@Table(name="myorder")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderid;
	double price;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	User user;
	@Column
	private int status;
	@Column
	private Date date;
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(int id, double price, User user, int status, Date date) {
		super();
		this.orderid = id;
		this.price = price;
		this.user = user;
		this.status = status;
		//this.date = date;
	}

	public int getId() {
		return orderid;
	}

	public void setId(int id) {
		this.orderid = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/*public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}*/
}
