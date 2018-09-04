package com.capgemini.registration.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.capgemini.registration.model.VerificationDetails;

@Controller
//@SessionAttributes("client")
public class VerificationController {
	
	@GetMapping("/verification")
	public String getVerification(Model model) {
		model.addAttribute("client", new VerificationDetails());
		return "verification";
	}
	
	@PostMapping("/verification")
	//public String verify(VerificationDetails client) {	
	public String verify(@Valid @ModelAttribute("client") VerificationDetails client, BindingResult bindingResult, Model model ) {	
		model.addAttribute("client", client);
		
		if(bindingResult.hasErrors()) {
			return "verification";
		}
		String accNum = client.getAccNum();
		
		String url = "http://localhost:8082/verify/account/"+accNum;
		RestTemplate restTemplate = new RestTemplate();
		VerificationDetails server = restTemplate.getForObject(url, VerificationDetails.class);
	     
	    System.out.println("Server: "+server.toString());
	    System.out.println("Client: "+client.toString());
	    
	 
	    if(server.getAccNum() == null ) {
	    	System.out.println("Invalid Account Number!");
	    	return "verification";
	    	
	    }else if(!client.getSsn().equals(server.getSsn())) {
	    	System.out.println("Invalid SSN!");
	    	return "verification";
	    
	    }else if(!client.getDob().equals(server.getDob())) {
	       	System.out.println("Invalid DOB");
	    	return "verification";
	    	
		}else if(!client.getMaiden().equals(server.getMaiden())){
			System.out.println("Invalid Maiden Name");
			return "verification";
		}
	    
	    model.addAttribute("message", "All details are correct. Please proceed to next page.");
	    
	    return "verification";
	}
}