package com.capgemini.registration.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.registration.model.CredentialsDetails;

public class CredentialsController {
	
	@Controller
	//@SessionAttributes("client")
	public class VerificationController {
		
		@GetMapping("credentials")
		public String getCredentials(Model model) {
			model.addAttribute("client", new CredentialsDetails());
			return "verification";
		}
		
		@PostMapping("credentials")
		public String verify(@Valid @ModelAttribute("client") CredentialsDetails client, BindingResult bindingResult, Model model ) {	
	
			
			
			
			return "credentials";
		}
	}

}
