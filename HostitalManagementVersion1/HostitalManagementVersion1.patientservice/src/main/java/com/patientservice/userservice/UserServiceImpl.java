package com.patientservice.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientservice.dto.*;
import com.patientservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public User getUser(String userName) {
		return repository.findByname(userName);
	}

	@Override
	public User createUser(User user) {
		repository.save(user);
		return user;
	}

}
