package com.capgemini.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.capgemini.registration.model.Credentials;
import com.capgemini.registration.model.RegistrationDetails;
import com.capgemini.registration.model.VerificationDetails;
import com.capgemini.registration.service.RegDetailsServiceImpl;

@Controller
public class TermsController implements WebMvcConfigurer {
	
	@Autowired
	private RegDetailsServiceImpl regDetServiceImpl;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
	public String verify(@ModelAttribute("email") String email) {
		Long custId = credentials.getCustomerId();
		RegistrationDetails regDetails = regDetServiceImpl.findRegDetailsByCustId(custId).get();
		regDetails.setUsername(credentials.getUsername());
		regDetails.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));
		//regDetails.setPassword(credentials.getPassword());
		regDetails.setStatus("C");
		regDetails.setEnabled(true);
		regDetServiceImpl.saveRegDetails(regDetails);
		
		String url = "http://localhost:8082/update/email/"+ custId + "/" + email;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, null, VerificationDetails.class);
				
		return "redirect:/RegistrationSuccessful";
	}
}
