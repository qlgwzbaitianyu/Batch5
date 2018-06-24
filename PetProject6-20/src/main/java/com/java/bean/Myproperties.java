package com.java.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix="application")
public class Myproperties {
	public String name;
	public String a;
	public String b;
	public String c;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	
	

}
