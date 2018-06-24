package com.java.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternationalController {
	@Autowired
	 private MessageSource messageSource;
	
	 /*@GetMapping("/international")
	 public String getInternationalPage() {
	        return "international";
	  }*/

	 @GetMapping("/international")
	 public String getMessage(@RequestParam String code) {
		    return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
	}
	 
}
