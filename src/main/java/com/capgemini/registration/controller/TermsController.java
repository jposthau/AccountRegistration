package com.capgemini.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.capgemini.registration.model.Credentials;
import com.capgemini.registration.model.RegistrationDetails;
import com.capgemini.registration.service.RegDetailsServiceImpl;

@Controller
public class TermsController implements WebMvcConfigurer {
	
	@Autowired
	private RegDetailsServiceImpl regDetServiceImpl;
	
	@Autowired
	private Credentials credentials;
	
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
		RegistrationDetails regDetails = regDetServiceImpl.findRegDetailsByCustId(credentials.getCustomerId()).get();
		regDetails.setUsername(credentials.getUsername());
		regDetails.setPassword(credentials.getPassword());
		regDetails.setStatus("C");
		regDetServiceImpl.saveRegDetails(regDetails);
		return "redirect:/RegistrationSuccessful";
	}
}
