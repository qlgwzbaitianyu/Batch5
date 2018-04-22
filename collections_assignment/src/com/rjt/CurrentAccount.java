package com.rjt;

public class CurrentAccount extends Account {
	double overdraftLimit = 5000;
	
	/*
	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		if(this.getBalance() > overdraftLimit) {
			return true;
		}
		else {
			return false;
		}
	}*/
	
	public boolean withdrawCheck(double amount) {
		if(this.getBalance() > overdraftLimit) {
			return true;
		}
		else {
			return false;
		}
	}

}
