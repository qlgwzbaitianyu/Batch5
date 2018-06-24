package com.java.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class OwnerHttpMessageConverter  extends AbstractHttpMessageConverter<Owner>{

	@Override
	protected boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Owner readInternal(Class<? extends Owner> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		
		 String requestBody = toString(inputMessage.getBody());
		 int i = requestBody.indexOf("\n");
		 String ownerName = requestBody.substring(0, i).trim();
	    
		 Owner o = new Owner();
		 o.setFirstName(ownerName);
		return o;
	}

	@Override
	protected void writeInternal(Owner o, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		OutputStream outputStream = outputMessage.getBody();
        String body = o.getFirstName() + "\n" +
               o.getId();
        outputStream.write(body.getBytes());
        outputStream.close();
		
	}
	
	private static String toString(InputStream inputStream) {
	      Scanner scanner = new Scanner(inputStream, "UTF-8");
	      return scanner.useDelimiter("\\A").next();
	  }
	

}
