package com.capgemini.registration.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.capgemini.registration.model.RegistrationDetails;

@Controller
public class CredentialsController implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/terms").setViewName("terms");
	}
	
	@GetMapping("/credentials")
	public String getCredentials(Model model) {
		model.addAttribute("credentials", new RegistrationDetails());
		return "credentials";
	}
	
	@PostMapping("/credentials")
	public String verify(@Valid @ModelAttribute ("credentials") RegistrationDetails registrationDetails, BindingResult bindingResult, Model model ) {	
		
		if(bindingResult.hasErrors()||!registrationDetails.getPassword().equals(registrationDetails.getConfirmPassword())) {
			if(!registrationDetails.getPassword().equals(registrationDetails.getConfirmPassword())) {
				model.addAttribute("notEqual", "password and confirm password both should be equal");
			}
			return "credentials";
			
		}
		
		return "redirect:/terms";
	}

}
