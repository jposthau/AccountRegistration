package com.capgemini.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VerificationController {
	
	@GetMapping("/verification")
	public String getVerification() {
		return "verification";
	}
	
	@PostMapping("/verification")
	public void verify() {
		
	}
	
}
