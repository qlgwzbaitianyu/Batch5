package com.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cartservice.dto.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByname(String username);

}
