package com.java;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"test"})
public class TestInitializer implements Initializer {

	@Override
	public void initialize() {
		System.out.println("this is in test");
	}

}
