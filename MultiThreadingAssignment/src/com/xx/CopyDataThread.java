package com.xx;
import java.io.*;


public class CopyDataThread extends Thread{

	public BufferedReader br;
	public FileReader fr;
	
	CopyDataThread(BufferedReader br, FileReader fr){
		this.br = br;
		this.fr = fr;
	}
	
	
	@Override
	public void run() {
		
		int c = 0;
		int counter = 0;
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			//String content = "This is the content to write into file\n";
			fw = new FileWriter("F:\\Target.txt");
			bw = new BufferedWriter(fw);
			//fw.write(content);
			
			
			System.out.println("Done");

		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
		
        try {
			while((c = br.read()) != -1) {
			    char character = (char) c;          
			    System.out.println(character);
			    
			    fw.write(c);
			    fw.flush();
			    
			    counter++;
			    if(counter == 10) {
			    	counter = 0;
			    	System.out.println("have read 10 Charactors");
			    	sleep(5000);
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
