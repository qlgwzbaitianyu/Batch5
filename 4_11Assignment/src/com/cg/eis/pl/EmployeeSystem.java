package com.cg.eis.pl;
import java.util.*;
import com.cg.eis.bean.*;

public class EmployeeSystem {
	
	public static void main(String args[]) throws EmptyNameException {
		
		System.out.println("input employee info: ");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("input employee id: ");
		int id = scanner.nextInt();
		System.out.println(id);
		
		System.out.println("input employee last name: ");
		String ln = scanner.nextLine();
		System.out.println(ln);
		
		System.out.println("input employee first name: ");
		String fn = scanner.nextLine();
		
		Employee em = new Employee();
		
		if(fn.equals("") && ln.equals("")) {
			System.out.println("all empty");
			throw new EmptyNameException("empty name");
		}
		
		
		//em.setId(id);
		//em.setFirst_name(fn);
		//em.setLast_name(ln);
		
		
		return;
	}
	

}
