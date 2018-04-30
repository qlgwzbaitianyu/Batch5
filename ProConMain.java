package com.morning;

import java.util.*;

public class ProConMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shareobj obj = new Shareobj();
		
		Producer p = new Producer(obj);
		Consumer c = new Consumer(obj);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		System.out.println("now the size of array is " + obj.list.size());
		
		t1.start();
		t2.start();
		
		
	}

}

class Producer implements Runnable{
	
	public Shareobj obj;
	Producer(Shareobj obj){
		this.obj = obj;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int  n = rand.nextInt(50) + 1;
		
		obj.list.add(n);
		
		while(true) {
			
			synchronized (obj) {
				if(obj.list.size() > 4) {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					int x = rand.nextInt(50);
					obj.list.add(x);
					System.out.println("now add: " + x + "now size is: " + obj.list.size());
					obj.notify();
				}
				
			}
			
			
		}
		
	}
	
	
}

class Consumer implements Runnable{
	public Shareobj obj;
	
	Consumer(Shareobj obj){
		this.obj = obj;
	}

	@Override
	public void run() {
		
		synchronized(obj){
			
			while(true) {
				
				if(obj.list.size() > 0) {
					System.out.println("now consume " + obj.list.get(0) + "now size is: " + obj.list.size());
					obj.list.remove(0);
					obj.notify();
					
				}
				
				else { 
					
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
			
		}
		
		
	}
	
	
	
	
}



class Shareobj{
	Object lock = new Object();
	public List list = new LinkedList();
}


