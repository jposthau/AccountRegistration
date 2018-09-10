
package com.capgemini.registration.model;

public class Login {
	
	private String username;
	private String password;
	
	public void customer_id() {
	}
	
	public void customer_id(String username, String password) {
		
		this.username = username;
		this.password = password;
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

}

