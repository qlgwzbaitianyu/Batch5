package com.java.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.java.controller.CustomerDateAndTimeDeserialize;

@Entity
@SQLDelete(sql =
"UPDATE pet " +
"SET active = 0 " +
"WHERE id = ?")
@Loader(namedQuery = "findPetById")
@NamedQuery(name = "findPetById", query =
    "SELECT p " +
    "FROM Pet p " +
    "WHERE " +
    "   p.id = ?1 AND " +
    "   p.active = 1")
@Where(clause = "active = 1")
public class Pet {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@NotBlank
	private String name;
	
	//@NotBlank
	@JsonDeserialize(using=CustomerDateAndTimeDeserialize.class)
	private Date birthday;
	
	//@NotBlank
	private String petType;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Owner owner;
	
	@OneToMany(mappedBy = "pet")
	private List<Visit> visit;
	
	
	 @Column
	private int active = 1;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Visit> getVisit() {
		return visit;
	}

	public void setVisit(List<Visit> visit) {
		this.visit = visit;
	}

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(int id, String name, Date birthday, String petType, Owner owner, List<Visit> visit) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.petType = petType;
		this.owner = owner;
		this.visit = visit;
	}
	
	
	

}
