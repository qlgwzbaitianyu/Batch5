package com.java.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ValidatePhoneNumber.class)
public @interface IsValidPhoneNumber {
	String message() default "Wrong shipping address";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{}; 
}
