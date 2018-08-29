package com.capgemini.registration.controller;

import java.util.Date;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.registration.model.VerificationDetails;

@Controller
public class VerificationController {
	
	@GetMapping("/verification")
	public String getVerification() {
		return "verification";
	}
	
//	@PostMapping("/verification")
//	public void verify(VerificationDetails verificationDetails) {
//		long accNum = verificationDetails.getAccNum();
//		Date dob = verificationDetails.getDob();
//		String maiden = verificationDetails.getMaiden();
//		String ssn = verificationDetails.getSsn();
//		
//		String url = "http://localhost:8082/verify/account/"+accNum;
//	}
	
}
