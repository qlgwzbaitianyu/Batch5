package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmpService implements Service.EmpService{
	public String providedService(Employee e) {
		
		if(e.getSalary() > 5000) {
			e.setInsuranceSchema("Plan A");
			return "plan A";
		}
		else {
			e.setInsuranceSchema("Plan B");
			return "plan B";
		}
		
	}
}