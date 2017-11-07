package com.cg.uas.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


public class LoginBean {

	
	@Column(name="login_id")
	@NotBlank(message="Please enter your username")
	private String loginId;
	@NotBlank(message="Please enter your password")
	private String password;
	@NotBlank(message="Please enter your role")
	private String role;
	
	
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
