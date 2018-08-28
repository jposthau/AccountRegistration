package com.capgemini.registration.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.accountopening.service.AccountDetailsService;
import com.capgemini.accountopening.service.PersonalDetailsService;
import com.capgemini.registration.model.VerificationDetails;

@Controller
public class VerificationController {
	
	@Autowired
	private AccountDetailsService accDetailsService;
	
	@Autowired 
	private PersonalDetailsService perDetailsService;
	
	@GetMapping("/verification")
	public String getVerification() {
		return "verification";
	}
	
	@PostMapping("/verification")
	public void verify(VerificationDetails verificationDetails) {
		long accNum = verificationDetails.getAccNum();
		long custId = accDetailsService.getAccountDetailsById(accNum).getCustomerId();
		String maiden = perDetailsService.getPersonalDetailsById(custId).getMotherMName();
		String ssn = perDetailsService.getPersonalDetailsById(custId).getSsn();
		Date dob = perDetailsService.getPersonalDetailsById(custId).getDob();
	}
	
}
