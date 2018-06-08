package com.java.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Login {
	@NotBlank
	@Size(min=4, max=6)
	String userName;
	@NotBlank
	String passWord;
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Login(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
