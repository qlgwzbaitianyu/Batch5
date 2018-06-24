package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import  static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.java.bean.Myproperties;
import com.java.bean.Owner;
import com.java.bean.Pet;
import com.java.repository.*;

@RestController
@RequestMapping(path="/owners")
public class OwnerController{
	@Autowired
	OwnerRepository repository;
	
	@Autowired
	Myproperties properties;
	
	private final Logger logger = LoggerFactory.getLogger(OwnerController.class);
	
	String name;
	
	/* search all */
	@RequestMapping(produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Collection<Owner>> getOwners(@Nullable @RequestParam("firstName") String firstName, @Nullable @RequestParam("nameLike") String firstChar){
		Link selfLink = linkTo(methodOn(OwnerController.class).getOwners(null, null)).withSelfRel();
		List<Owner> owners;
		if(firstName != null && !firstName.isEmpty()) {
			owners = repository.getByfirstName(firstName, new Sort(Direction.DESC, "id"));
			owners.stream().forEach(a -> a.add(selfLink));
			return  ResponseEntity.ok(owners);
		}
		else if((firstChar != null && !firstChar.isEmpty())) {
			owners = repository.findByfirstNameStartingWith(firstChar);
			owners.stream().forEach(a -> a.add(selfLink));
			return ResponseEntity.ok(owners);
		}
		else {
			owners = repository.findAll();
			owners.stream().forEach(a -> a.add(linkTo(OwnerController.class).slash(a.getOwnerid()).withSelfRel()));
			
			System.out.println(properties.getC());
			return ResponseEntity.ok(owners);
		}
	}
	
	
	/* conveter test from string to owner*/
	/* the request param get the string from httprequest header or uir(not body), use the custom converter to convert str -> owner*/
	@RequestMapping(value="/ownerconverter", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Owner getConverterTest(@RequestParam("source") Owner owner) {
		return owner;
	}
	
/*	 custom media type
	@RequestMapping(value="/xxx")
	public Owner  getOwnersCustomCSV(@PathVariable("id") int id){
		Owner owner = new Owner(1, "a", "b");
		return owner;
	} */
	
	/* search by Id */
	@RequestMapping(path="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Owner getOwnerById(@PathVariable("id") int id) {
		Owner owner = repository.findById(id).get();
		owner.add(linkTo(OwnerController.class).slash(id).withSelfRel());
		for(Pet p : owner.getPets()) {
			owner.add(linkTo(methodOn(PetController.class).getPetById(p.getId())).withRel("pets"));
		}
		return  owner;
	}
	
	
	/* insert */
	@PostMapping
	@ResponseStatus(code=HttpStatus.ACCEPTED, reason="Inserted Record successfully")
	public ResponseEntity<Owner> insertEmployee(@Valid @RequestBody Owner owner) {
		//greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
		repository.save(owner);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(owner);
	}
	
	/* update */
	@RequestMapping(method= RequestMethod.PUT)
	public ResponseEntity<Owner> updateEmployee(@RequestBody Owner owner) {
		 repository.save(owner);
		 return	 ResponseEntity.status(HttpStatus.ACCEPTED).body(owner);
	}
	
	/* delete */
	@RequestMapping(method=RequestMethod.DELETE,path="/{id}")
	@ResponseStatus(code=HttpStatus.OK, reason="Deleted Owner successfully")
	public void deleteEmployee(@PathVariable("id") int id) {
		 repository.deleteById(id);
	}
	
	
	@InitBinder
	public void binder(WebDataBinder binder) {
		//binder.setDisallowedFields("age");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		binder.registerCustomEditor(Date.class, "doj", new CustomDateEditor(format, true));
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//binder.registerCustomEditor(LocalDate.class, "dob", new CustomLocalDateEditor(formatter));
		// customlocatdateEditor, extends propertyEditorsuPOORTB
	}
	
	
	
	
	
}
