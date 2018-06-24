package com.java;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev"})
public class DevInitializer implements Initializer {

	@Override
	public void initialize() {
		
		System.out.println("this is in dev mode");
	}

}
