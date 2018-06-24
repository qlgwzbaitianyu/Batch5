/*package com.java;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.bean.MappingCsv2HttpMessageConverter;

@Configuration
public class CsvHttpMessageConfiguration extends  WebMvcConfigurationSupport{
	
	// customized csv converter
	@Bean
	public MappingCsv2HttpMessageConverter customCsv2HttpMessageConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MappingCsv2HttpMessageConverter csvConverter = new MappingCsv2HttpMessageConverter(objectMapper);
		return csvConverter;
	}

	//register customized converter
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		converters.add(customCsv2HttpMessageConverter());		 //can register any customized converter here
		System.out.println(converters);			
		super.addDefaultHttpMessageConverters(converters);
	}

}
*/