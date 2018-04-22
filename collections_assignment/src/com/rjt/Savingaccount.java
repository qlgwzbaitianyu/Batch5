package com.rjt;

import java.util.Random;

public class Savingaccount extends Account {
	final double min_Balance = 500;
	
	public Savingaccount(Person person, double balance) {
		this.setAccHolder(person);
		this.setBalance(balance);
		Random rand = new Random();
		this.setAccNum(rand.nextInt(10000));
	}
	
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if(this.getBalance() - amount > min_Balance) {
			super.withdraw(amount);
		}
		else {
			System.out.println("need to hold 500 in account");
			System.exit(1);
		}
	}
	
	
	

}
