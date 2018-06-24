package com.java.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.bean.Owner;
import com.java.bean.Pet;
import com.java.repository.OwnerRepository;
import com.java.repository.PetRepository;

@RestController
@RequestMapping(path="/petss")
public class PetController {
	@Autowired
	PetRepository repository;
	
	@RequestMapping(path="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Pet getPetById(@PathVariable("id") int id) {
		Pet pet = repository.findById(id).get();
		return  pet;
	}
	

}
