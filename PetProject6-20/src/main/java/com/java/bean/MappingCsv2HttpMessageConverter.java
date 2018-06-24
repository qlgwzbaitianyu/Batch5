package com.java.bean;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MappingCsv2HttpMessageConverter extends OwnerCsv2HttpMessageConverter{

	public MappingCsv2HttpMessageConverter(ObjectMapper objectMapper) {
		super(objectMapper, MediaType.TEXT_PLAIN);
	}

}
