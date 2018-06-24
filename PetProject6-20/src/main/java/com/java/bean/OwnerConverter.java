package com.java.bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/*
*	Custom converter to convert String to Owner
*
*
*
*
*/

@Component
public class OwnerConverter implements Converter<String, Owner>{

	@Override
	public Owner convert(String source) {
		Owner owner = new Owner();
		//String str ="abc,cde,def,fgh";
		String firstName = source.substring( 0, source.indexOf(","));
		String lastName = source.substring(source.indexOf(",")+1, source.length());         
		try {
			owner.setFirstName(firstName); 
			owner.setLastName(lastName);
			return owner;
		} catch (Exception e) {
			return null;
		}
	}

}
