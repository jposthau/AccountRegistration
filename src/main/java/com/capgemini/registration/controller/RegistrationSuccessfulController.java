package com.capgemini.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationSuccessfulController {
	
	@GetMapping("/registrationSuccess")
	public String getTerms() {
		return "RegistrationSuccess";
	}
	
}