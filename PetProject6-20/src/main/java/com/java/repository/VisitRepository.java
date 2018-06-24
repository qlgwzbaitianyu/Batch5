package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.java.bean.Visit;

@RepositoryRestResource
public interface VisitRepository extends JpaRepository<Visit, Integer>{

}
