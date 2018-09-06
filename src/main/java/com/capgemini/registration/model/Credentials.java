package com.capgemini.registration.model;

import javax.annotation.ManagedBean;
import javax.validation.constraints.Size;

@ManagedBean
public class Credentials {
	
	private Long customerId;
	
	private String username;

	@Size(min=8, max=20, message="Must be between 8-20 characters")
	private String password;
	
	private String confirm;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

}
