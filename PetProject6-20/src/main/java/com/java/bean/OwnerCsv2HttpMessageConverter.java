package com.java.bean;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OwnerCsv2HttpMessageConverter extends AbstractGenericHttpMessageConverter<Owner>{
	
	protected ObjectMapper objectMapper;

	protected OwnerCsv2HttpMessageConverter(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	protected OwnerCsv2HttpMessageConverter(ObjectMapper objectMapper, MediaType supportedMediaType) {
		this(objectMapper);
		setSupportedMediaTypes(Collections.singletonList(supportedMediaType));
	}

	protected OwnerCsv2HttpMessageConverter(ObjectMapper objectMapper, MediaType... supportedMediaTypes) {
		this(objectMapper);
		setSupportedMediaTypes(Arrays.asList(supportedMediaTypes));
	}
	

	@Override
	public Owner read(Type arg0, Class<?> arg1, HttpInputMessage httpInputMessage)
		throws IOException, HttpMessageNotReadableException {
			System.out.println("OwnerCsv2HttpMessageConverter: read");
			Scanner sc = new Scanner(httpInputMessage.getBody()).useDelimiter(",");
			return new Owner(Integer.parseInt(sc.next()), sc.next(), sc.next());
	}

	@Override
	protected void writeInternal(Owner owner, Type arg1, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		outputMessage.getBody().write((owner.getOwnerid() + "," + owner.getFirstName() + "," + owner.getLastName()).getBytes());
		
	}

	@Override
	protected Owner readInternal(Class<? extends Owner> arg0, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		System.out.println("OwnerCsv2HttpMessageConverter: readInternal: inputMessage=" + inputMessage.getBody());
		return new Owner(11, "the firstname", "the lastname");
	}
	

}
