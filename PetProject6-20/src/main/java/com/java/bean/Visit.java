package com.java.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Visit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@NotBlank
	private Date dateOfVisit;
	
	//@NotBlank
	private String description;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Pet pet;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Visit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visit(int id, Date dateOfVisit, String description, Pet pet) {
		super();
		this.id = id;
		this.dateOfVisit = dateOfVisit;
		this.description = description;
		this.pet = pet;
	}
	
	

}
