package com.capgemini.registration.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_registration")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RegistrationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Size(max = 6)
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

	@Column(name = "attempts")
	private int attempts = 0;

	@Column(name = "timestamp")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timestamp;

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

	@Override
	public String toString() {
		return "RegistrationDetails [registrationId=" + registrationId + ", customerId=" + customerId + ", username="
				+ username + ", password=" + password + ", status=" + status + ", attempts=" + attempts + ", timestamp="
				+ timestamp + "]";
	}
}
