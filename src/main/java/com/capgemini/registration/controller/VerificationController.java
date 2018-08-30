package com.capgemini.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.capgemini.registration.model.VerificationDetails;

@Controller
public class VerificationController {
	
	@GetMapping("/verification")
	public String getVerification(Model model) {
		model.addAttribute("client", new VerificationDetails());
		return "verification";
	}
	
	@PostMapping("/verification")
	public String verify(VerificationDetails client) {
		String accNum = client.getAccNum();
		
		String url = "http://localhost:8082/verify/account/"+accNum;
		RestTemplate restTemplate = new RestTemplate();
		VerificationDetails server = restTemplate.getForObject(url, VerificationDetails.class);
	     
	    System.out.println("Server: "+server.toString());
	    System.out.println("Client: "+client.toString());
	    if(server.getSsn() == null) {
	    	System.out.println("Invalid Acc Num!");
	    }
	    
	    return "index";
	}
	
}
