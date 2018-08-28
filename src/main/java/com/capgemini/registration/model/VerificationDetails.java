package com.capgemini.registration.model;

import java.util.Date;

public class VerificationDetails {
	
	private long accNum;
	
	private String maiden;
	
	private String ssn;
	
	private Date dob;

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
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
	
	
	
}
