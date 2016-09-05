package com.test.violationsdrivecarMS.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public interface loginGroup{}
	
	@NotEmpty(groups = {loginGroup.class})
	private String username;
	@NotEmpty(groups = {loginGroup.class})
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
