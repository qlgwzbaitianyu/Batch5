package com.java.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*public class ValidatePhoneNumber implements ConstraintValidator<isValidPhoneNumber, long>{
	public void initialize 
}
*/


public class ValidatePhoneNumber implements
ConstraintValidator<IsValidPhoneNumber, ShippingAddress> {

  @Override
  public void initialize(IsValidPhoneNumber isValidNumber) {
	  isValidNumber.message();
  }

 /* @Override
  public boolean isValid(String contactField,
    ConstraintValidatorContext cxt) {
      return contactField != null && contactField.matches("[0-9]+")
        && (contactField.length() > 8) && (contactField.length() < 14);
  }*/


@Override
public boolean isValid(ShippingAddress address, ConstraintValidatorContext context) {
	Pattern pattern = Pattern.compile("^[0-9]{5}$");
	//Matcher matcher = pattern.matcher(address.getZipcode().toString());
	
	if(address.getCity().equals("") || address.getZipcode() == 123 || address.getState().length() != 2) {
		return false;
	}
	
	return true;
	
	
	
}

}