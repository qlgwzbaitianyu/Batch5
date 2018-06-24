package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.java.bean.Owner;
import com.java.bean.Pet;

@RepositoryRestResource
public interface PetRepository extends JpaRepository<Pet, Integer>{
	
	public List<Pet> getByname(String name);

}
