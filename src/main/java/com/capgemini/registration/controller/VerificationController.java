package com.capgemini.registration.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.capgemini.registration.model.Credentials;
import com.capgemini.registration.model.RegistrationDetails;
import com.capgemini.registration.model.RegistrationLog;
import com.capgemini.registration.model.VerificationDetails;
import com.capgemini.registration.service.RegDetailsServiceImpl;
import com.capgemini.registration.service.RegLogServiceImpl;

@Controller
public class VerificationController implements WebMvcConfigurer {

	
	@Autowired
	private RegLogServiceImpl regLogServiceImpl;
	
	@Autowired
	private RegDetailsServiceImpl regDetServiceImpl;
	
	@Autowired
	private Credentials credentials;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/credentials").setViewName("credentials");
	}
	
	@GetMapping("/verification")
	public String getVerification(Model model) {
		model.addAttribute("client", new VerificationDetails());
		return "verification";
	}
	
	@PostMapping("/verification")
	public String verify(@Valid @ModelAttribute("client") VerificationDetails client, BindingResult bindingResult, Model model ) {	
		model.addAttribute("client", client);
		
		if(bindingResult.hasErrors()) {
			return "verification";
		}
		String accNum = client.getAccNum();
		
		String url = "http://localhost:8082/verify/account/"+accNum;
		RestTemplate restTemplate = new RestTemplate();
		VerificationDetails server = restTemplate.getForObject(url, VerificationDetails.class);
		Optional<RegistrationDetails> optional=regDetServiceImpl.findRegDetailsByCustId(server.getCustomerId());
		if(optional.isPresent() && optional.get().getUsername() != null) {
			model.addAttribute("accNumError", "Account Number already registered to a user");
			return "/verification";
		}
	     
	    System.out.println("Server: "+server.toString());
	    System.out.println("Client: "+client.toString());
	    
	    boolean invalid = false;
	    String incorrect = "";
	    RegistrationDetails registration;
	    credentials.setCustomerId(server.getCustomerId());
	    
	    try {
	    	registration = regDetServiceImpl.findRegDetailsByCustId(server.getCustomerId()).get();
	    } catch(Exception e) {
	    	registration = new RegistrationDetails();
	    	registration.setCustomerId(server.getCustomerId());
	    }
	    
	    RegistrationLog log = new RegistrationLog();
	    log.setRegistrationId(registration.getRegistrationId());
	 
	    if(server.getSsn() == null ) {
	    	System.out.println("Invalid Account Number");
	    	model.addAttribute("accNumError", "Invalid Account Number");
	    	invalid = true;
	    	incorrect = "ACCNUM";
	    }
	    else {
		    if(!client.getSsn().equals(server.getSsn())) {
		    	System.out.println("Invalid SSN");
		    	model.addAttribute("ssnError", "Invalid SSN");
		    	invalid = true;
		    	incorrect += "SSN ";
		    }
		    if(!client.getDob().equals(server.getDob())) {
		       	System.out.println("Invalid DOB");
		       	model.addAttribute("dobError", "Invalid DOB");
		       	invalid = true;
		       	incorrect += "DOB ";
			}
		    if(!client.getMaiden().equals(server.getMaiden())){
				System.out.println("Invalid Maiden Name");
				model.addAttribute("maidenError", "Invalid Maiden Name");
				invalid = true;
				incorrect += "MAIDEN ";
			}
	    }
	    
	    if(registration.getStatus() != null) {
			if(registration.getStatus().equals("L"))
	    		return "locked";
	    }
			
		if(invalid == true) {
	    	log.setAttempt(incorrect);
	    	log.setStatus("fail");
	    	registration.setAttempts(registration.getAttempts() + 1);
	    	
	    	if(registration.getAttempts() >= 6) {
	    		registration.setStatus("L");
		    	regDetServiceImpl.saveRegDetails(registration);
		    	regLogServiceImpl.saveRegLog(log);
	    		return "locked";
	    		
	    	} else {
	    		registration.setStatus("UR");
		    	regDetServiceImpl.saveRegDetails(registration);
		    	regLogServiceImpl.saveRegLog(log);
		    	return "verification";
	    	}
	    	
	    }
	    
	    log.setStatus("pass");
	    registration.setStatus("UR");
	    regDetServiceImpl.saveRegDetails(registration);
	    regLogServiceImpl.saveRegLog(log);
	    return "redirect:/credentials";
	}
}