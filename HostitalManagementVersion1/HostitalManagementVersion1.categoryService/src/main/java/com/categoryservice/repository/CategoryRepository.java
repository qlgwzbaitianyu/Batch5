package com.categoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.categoryservice.dto.Category;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Integer>{
}
