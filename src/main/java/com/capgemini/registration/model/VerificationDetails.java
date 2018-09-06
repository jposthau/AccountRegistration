package com.capgemini.registration.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.capgemini.date.CustomDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class VerificationDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message="Please enter Acccount Number.")
	private String accNum;
	
	private Long customerId;
	
	@NotBlank(message="Please enter Maiden Name.")
	private String maiden;
	
	@NotNull(message="Please enter SSN number.")
	@NotBlank(message="Please enter SSN number.")
	private String ssn;
	
	@NotNull(message="Please enter DOB.")
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date dob;

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getMaiden() {
		return maiden;
	}

	public void setMaiden(String maiden) {
		this.maiden = maiden;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "VerificationDetails [accNum=" + accNum + ", maiden=" + maiden + ", ssn=" + ssn + ", dob=" + dob + "]";
	}
	
}
