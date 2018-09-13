package com.capgemini.registration.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.capgemini.registration.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_registration")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RegistrationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "registration_id")
	private int registrationId;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private String status;
	
	@Column(name = "enabled")
	private int enabled = 1;

	@Column(name = "attempts")
	private int attempts = 0;

	@Column(name = "timestamp")
	private Date timestamp = new Date();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "registration_role", joinColumns = @JoinColumn(name = "registration_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public int getAttempts() {
		return attempts;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getPassword() {
		return password;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public String getStatus() {
		return status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getUsername() {
		return username;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int isEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "RegistrationDetails [registrationId=" + registrationId + ", customerId=" + customerId + "status=" + status + "enabled=" + enabled + ", attempts=" + attempts + ", timestamp="
				+ timestamp + "]";
	}
}
