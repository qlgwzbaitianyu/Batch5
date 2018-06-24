package com.java.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import net.minidev.json.parser.ParseException;



public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy/MM/dd");
	
	
	 public Date deserialize(JsonParser paramJsonParser,
	            DeserializationContext paramDeserializationContext)
	            throws IOException, JsonProcessingException {
	        String str = paramJsonParser.getText().trim();
	        try {
	            return dateFormat.parse(str);
	        } catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return paramDeserializationContext.parseDate(str);
	    }
	
	/*@Override
	public Date deserialize(JsonParser paramJsonParser, DeserializationContext arg1) throws IOException, JsonProcessingException {
		 String str = paramJsonParser.getText().trim();
	        try {
	            return dateFormat.parse(str);
	        } catch (ParseException e) {
	            // Handle exception here
	        }
	        return arg1.parseDate(str);
		
	}*/

}
