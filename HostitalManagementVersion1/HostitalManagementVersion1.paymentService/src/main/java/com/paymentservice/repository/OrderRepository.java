package com.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.paymentservice.dto.Order;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
