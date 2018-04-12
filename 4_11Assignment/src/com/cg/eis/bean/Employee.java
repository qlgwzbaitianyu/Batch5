package com.cg.eis.bean;

public class Employee {
	public int id;
	public String first_name;
	public String last_name;
	public double salary;
	public String designation;
	public String insuranceSchema;
	
	
	public int getId() {
		return id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getInsuranceSchema() {
		return insuranceSchema;
	}
	public void setInsuranceSchema(String insuranceSchema) {
		this.insuranceSchema = insuranceSchema;
	}
	
	
	
	
	


}
