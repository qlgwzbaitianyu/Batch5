package com.paymentservice.repository;

import java.util.List;

import org.hibernate.annotations.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paymentservice.dto.User;



@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByname(String username);
	
	public List<User> getByname(String name, Sort sort);

}
