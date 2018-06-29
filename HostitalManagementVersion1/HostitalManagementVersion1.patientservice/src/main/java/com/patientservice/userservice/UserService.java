package com.patientservice.userservice;

import org.springframework.stereotype.Service;

import com.patientservice.dto.User;



public interface UserService {
	
	public User getUser(String userName);

	public User createUser(User user);

}
