package com.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cartservice.dto.Cart;
import com.cartservice.dto.Product;


@RepositoryRestResource
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
