package com.capgemini.registration.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class VerificationDetails {
	
	private String accNum;
	
	private String maiden;
	
	private String ssn;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
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

	@Override
	public String toString() {
		return "VerificationDetails [accNum=" + accNum + ", maiden=" + maiden + ", ssn=" + ssn + ", dob=" + dob + "]";
	}
	
}
