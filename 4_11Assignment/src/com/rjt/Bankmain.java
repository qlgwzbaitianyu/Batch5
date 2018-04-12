package com.rjt;

public class Bankmain {

	public static void main(String[] args) throws AgeNotEngoughException{
		// TODO Auto-generated method stub
		
		
		// create account for smith and kathy
		Person p1 = new Person("smith");
		Person p2 = new Person("kathy");
		
		Account act1 = new Account(p1, 2000);
		Account act2 = new Account(p2, 3000);
		
		
		
		// deposit
		act1.deposit(2000);
		
		//withdraw
		act2.withdraw(2000);
		
		// print out account
		System.out.println("smith's balance is " + act1.getBalance());
		System.out.println("kathy's balance is " + act2.getBalance());
		
		System.out.println(act1.toString());
		System.out.println(act2.toString());
		
		Savingaccount act3 = new Savingaccount(p1, 4000);
		act3.withdraw(3600);
		System.out.println("saving's balance is " + act3.getBalance());
		
		
		// set the age
		p1.setAge(14);
		// check the age
		if(p1.getAge() < 15) {
			throw new AgeNotEngoughException();
		}
		
		
		
	}

}
