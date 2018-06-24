package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.java.bean.*;;


public interface OwnerRepository extends JpaRepository<Owner, Integer>{
	
	public List<Owner> getByfirstName(String firstNmae, Sort sort);
	
	public List<Owner> getBylastName(String lastNmae);
	
	public List<Owner> findByfirstNameStartingWith(String firstName);

}
