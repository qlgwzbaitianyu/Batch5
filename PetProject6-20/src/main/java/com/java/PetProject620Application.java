package com.java;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy.RepositoryDetectionStrategies;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@EntityScan(basePackages="com.java.bean")
@EnableJpaRepositories(basePackages="com.java.repository")
public class PetProject620Application extends /*RepositoryRestConfigurerAdapter*/ WebMvcConfigurerAdapter  implements CommandLineRunner{

	@Autowired
	Initializer myinitializer;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PetProject620Application.class, args);
	}
	
	
	
	/*@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.setRepositoryDetectionStrategy(RepositoryDetectionStrategies.ANNOTATED);
	}*/
	
	
	
	/* mvc internationalization */
	/*@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource msg = new ResourceBundleMessageSource();
		msg.addBasenames("messages");
		return msg;
	}*/
	
	
	/* rest internationalization */
	@Bean
	public AcceptHeaderLocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver slr = new AcceptHeaderLocaleResolver();
	    slr.setDefaultLocale(new Locale("en"));
	    return slr;
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		 myinitializer.initialize();
	}
	
}

