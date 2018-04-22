package com.cg.eis.pl;
import java.util.*;
import com.cg.eis.bean.*;
import com.cg.eis.service.*;

public class EmployeeSystem {
	
	public static void main(String args[]) throws EmptyNameException {
		
		System.out.println("input employee info: ");
		
		Scanner scanner = new Scanner(System.in);
		/*
		System.out.println("input employee id: ");
		int id = scanner.nextInt();
		System.out.println(id);
		
		System.out.println("input employee last name: ");
		String ln = scanner.next();
		System.out.println(ln);
		
		
		System.out.println("input employee first name: ");
		String fn = scanner.next();
		System.out.println(fn);
		
		System.out.println("input designation: ");
		String design = scanner.next();
		
		
		System.out.println("input employee salary: ");
		double sal = scanner.nextDouble();
		
		
		Employee em = new Employee();
		
		if(fn.equals("") && ln.equals("")) {
			System.out.println("all empty");
			throw new EmptyNameException("empty name");
		}
		
		
		em.setId(id);
		em.setFirst_name(fn);
		em.setLast_name(ln);
		em.setDesignation(design);
		em.setSalary(sal);
		
		EmpService es = new EmpService();
		es.providedService(em);
		
		em.print();
		*/
		
		Employee em1 = new Employee(1, "aa", "AA", 3000, "xx", "PlanA");
		Employee em2 = new Employee(2, "bb", "BB", 4000, "xx", "PlanA");
		Employee em3 = new Employee(3, "cc", "CC", 1000, "xx", "PlanA");
		Employee em4 = new Employee(4, "dd", "DD", 8000, "xx", "PlanB");
		
		// add employee to hashmap
		HashMap<Integer,Employee> hm=new HashMap<Integer,Employee>();  
		  hm.put(em1.getId(), em1);
		  hm.put(em2.getId(), em2);
		  hm.put(em3.getId(), em3);
		  hm.put(em4.getId(), em4);
		  
		// print base on the insurance schema
		  System.out.println("input the insurace schema: ");
		  String ins = scanner.nextLine();
		  
		  System.out.println(ins);
		  
		  if(ins == "PlanA") {
			  System.out.println(true);
		  }
		  else {
			  System.out.println(false);
		  }
		  
		  
		  for(Map.Entry m:hm.entrySet()){
			  int key = (int) m.getKey();
			  Employee e = (Employee) m.getValue();
			  //e.print();
			  
			  if(e.getInsuranceSchema() == ins) {
				  e.print();
			  }
			  else {
				  System.out.println("not match in " + e.getId() + " :: " + e.getInsuranceSchema());
			  }
			  
		  }  
		  
		  // remove
		  
		  System.out.println("****************input the remove id: ");
		  hm.remove(em2.getId());
		  for(Map.Entry m:hm.entrySet()){
			  int key = (int) m.getKey();
			  Employee e = (Employee) m.getValue();
			  e.print();
			  
		  }  
		
		  
		  //sort base on value
		  System.out.println("**************sort base on salary");
		  Collection<Employee> collecEm = hm.values();
		  List<Employee> myLinkList = new ArrayList<Employee>(collecEm);
		  
		  Collections.sort(myLinkList, new Mycomparator());
		  
		  Iterator i = myLinkList.iterator();
		  while(i.hasNext()) {
			  Employee emp = (Employee)i.next();
			  emp.print();
		  }

		
		return;
	}
	
	

}

class Mycomparator implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return (int)(arg0.salary - arg1.salary);
		
	}
	
}

