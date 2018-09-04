package com.capgemini.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class TermsController implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/RegistrationSuccessful").setViewName("RegistrationSuccessful");
	}
	
	@GetMapping("/terms")
	public String getTerms() {
		return "terms";
	}
	
	@PostMapping("/terms")
	public String verify() {	
		return "redirect:/RegistrationSuccessful";
	}
}
