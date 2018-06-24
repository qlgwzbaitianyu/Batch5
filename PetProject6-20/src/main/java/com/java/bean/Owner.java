package com.java.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

@Entity
@XmlRootElement
public class Owner extends ResourceSupport {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerid;
	
	/*@NotBlank
	@Size(min=4, max=6)*/
	private String firstName;
	
	/*@NotBlank
	@Size(min=4, max=6)*/
	private String lastName;
	
	//@NotBlank
	private String street;
	
	//@NotBlank
	private String city;
	
	//@NotBlank
	private int phonenumber;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
	private List<Pet> pets;
	
	

	public Owner(int id, String firstName, String lastName, String street, String city, int phonenumber,
			List<Pet> pets) {
		super();
		this.ownerid = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.phonenumber = phonenumber;
		this.pets = pets;
	}
	
	
	public Owner(int id, String firstName, String lastName) {
		this.ownerid = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	
	
}
