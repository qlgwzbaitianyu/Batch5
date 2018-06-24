package com.java;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy.RepositoryDetectionStrategies;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.bean.OwnerHttpMessageConverter;

@Configuration
public class CustomConfiguration extends RepositoryRestConfigurerAdapter implements WebMvcConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.setRepositoryDetectionStrategy(RepositoryDetectionStrategies.ANNOTATED);
	}
	
	/*@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		System.out.println("new httpmessage converter is added");
		super.configureHttpMessageConverters(converters);
		converters.add(new OwnerHttpMessageConverter());
	}*/
	
	/*@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	    jsonConverter.setSupportedMediaTypes(Arrays.asList(MediaType.valueOf("text/html")));
	    return jsonConverter;
	}*/
	 
	/*@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	 MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	 ObjectMapper objectMapper = new ObjectMapper();
	 objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	 jsonConverter.setObjectMapper(objectMapper);
	 return jsonConverter;
	}*/
	
	
	

	
}
