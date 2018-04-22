package com.rjt;
import java.util.*;

public class Account {
	private long accNum;
	private double balance;
	private Person accHolder;
	
	// default constructor
	Account(){}
	
	//constructor
	Account(Person person, double balance) {
		this.setAccHolder(person);
		this.setBalance(balance);
		Random rand = new Random();
		this.setAccNum(rand.nextInt(10000));
	}
	
	
	 
	// deposit money
	public void deposit(double amount){
		this.setBalance(this.getBalance() + amount);
		if(this.getBalance() < 500) {
			System.out.println("must have min of 500 deposit");
			System.exit(1);
		}
	}
	
	// withdraw money
	public void withdraw(double amount) {
		this.setBalance(this.getBalance() - amount);
		if(this.getBalance() < 500) {
			System.out.println("must have min of 500 deposit");
			System.exit(1);
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "account holder: " + this.getAccHolder().getName() + " account num: " + this.getAccNum() + "balance: " + this.getBalance();
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public Person getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
	

}
