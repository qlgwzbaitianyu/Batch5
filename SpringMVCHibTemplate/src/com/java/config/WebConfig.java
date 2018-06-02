package com.java.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer{

	private String TMP_FOLDER = "/tmp"; 
	private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024; 
	
	@Override
	public void onStartup(ServletContext servletcontext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(SpringConfig.class);
		ctx.setServletContext(servletcontext);
		Dynamic servlet = servletcontext.addServlet("myservlet", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		/*upload file configuration*/
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, 
				MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);    
		servlet.setMultipartConfig(multipartConfigElement);
	}

}
