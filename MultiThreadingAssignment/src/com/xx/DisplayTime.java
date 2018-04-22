package com.xx;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class DisplayTime {
	
	
	public static void main(String args[]) {
		
		
		
		ShowTime th1 = new ShowTime();
		th1.start();
		
		return;
	}
	

}


class ShowTime extends Thread {

	@Override
	public void run() {
		
		while(true) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
}





