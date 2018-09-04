package com.capgemini.registration.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "c_registration_log")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RegistrationLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
	private Long logId;

	@Column(name="registration_id")
	@Size(max = 6)
	private int registrationId;

	@Column(name="attempt")
	private String attempt;

	@Column(name="status")
	private String status;
	
	private Date date = new Date();

	@Column(name="timestamp")
	private Timestamp timestamp = new Timestamp(date.getTime());

	public String getAttempt() {
		return attempt;
	}

	public Long getLogId() {
		return logId;
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

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "RegistrationLog [logId=" + logId + ", registrationId=" + registrationId + ", attempt="
				+ attempt + ", status=" + status + ", timestamp=" + timestamp + "]";
	}
}
