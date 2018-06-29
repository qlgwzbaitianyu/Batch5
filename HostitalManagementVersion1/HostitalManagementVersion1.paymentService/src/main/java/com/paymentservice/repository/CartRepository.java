package com.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paymentservice.dto.Cart;
import com.paymentservice.dto.User;


@RepositoryRestResource
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
