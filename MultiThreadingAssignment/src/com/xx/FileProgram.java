package com.xx;

import java.io.*;

public class FileProgram {
	
	private final static String FILE = "F:\\Source.txt";
	
	public static void main(String args[]) {
		
		BufferedReader br = null;
		FileReader fr = null;
			
		try {
			fr = new FileReader(FILE);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
			
		CopyDataThread cdh = new CopyDataThread(br, fr);
		Thread myth = new Thread(cdh);
		
		myth.start();
		
		
		
		
	}

}
