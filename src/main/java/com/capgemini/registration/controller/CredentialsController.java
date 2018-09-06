package com.capgemini.registration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.capgemini.registration.model.Credentials;

@Controller
public class CredentialsController implements WebMvcConfigurer {
	
	@Autowired
	private Credentials credentials;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/terms").setViewName("terms");
	}
	
	@GetMapping("/credentials")
	public String getCredentials(Model model) {
		model.addAttribute("credentials", new Credentials());
		return "credentials";
	}
	
	@PostMapping("/credentials")
	public String verify(@Valid @ModelAttribute ("credentials") Credentials credentials1, BindingResult bindingResult, Model model ) {	
		
		if(bindingResult.hasErrors()||!credentials1.getPassword().equals(credentials1.getConfirm())) {
			if(!credentials1.getPassword().equals(credentials1.getConfirm())) {
				model.addAttribute("notEqual", "Passwords do not match!");
			}
			return "credentials";
			
		}
		credentials.setUsername(credentials1.getUsername());
		credentials.setPassword(credentials1.getPassword());
		return "redirect:/terms";
	}

}
