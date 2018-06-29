package com.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.orderservice.dto.Cart;

@RepositoryRestResource
public interface CartRepository extends JpaRepository<Cart, Integer>{
}
