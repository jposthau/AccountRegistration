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
@Table(name = "c_registration_log")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RegistrationLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
	@Size(max = 6)
	private Long customerId;

	@Column(name="registration_id")
	private int registrationId;

	@Column(name="attempt")
	private String attempt;

	@Column(name="status")
	private String status;

	@Column(name="timestamp")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timestamp;

	public String getAttempt() {
		return attempt;
	}

	public Long getCustomerId() {
		return customerId;
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

	public void setAttempt(String attempt) {
		this.attempt = attempt;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	@Override
	public String toString() {
		return "RegistrationLog [customerId=" + customerId + ", registrationId=" + registrationId + ", attempt="
				+ attempt + ", status=" + status + ", timestamp=" + timestamp + "]";
	}
}
