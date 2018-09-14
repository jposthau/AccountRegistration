// Register login Controller

package com.capgemini.registration.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.capgemini.accountopening.model.AccountDetails;
import com.capgemini.registration.model.Login;
import com.capgemini.registration.model.RegistrationDetails;
import com.capgemini.registration.service.RegDetailsServiceImpl;


@Controller
public class LoginController {

	@Autowired
	private RegDetailsServiceImpl regDetServiceImpl;

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(@RequestParam(value="error", required=false) boolean error, Model model) {
		model.addAttribute("login", new Login());
		if(error) {
			model.addAttribute("error", "Invalid username or password!");
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void submit(@ModelAttribute("login") Login login) {
		
			login.setPassword(bCryptPasswordEncoder.encode(login.getPassword()));
			
	}

	@RequestMapping(value="/success", method = RequestMethod.GET)
	public String showAccount(Authentication authentication, Model model) {
		
		RegistrationDetails customerId = regDetServiceImpl.findRegByUsername(authentication.getName());
		
		
		String url = "http://localhost:8082/login/accountDetails/"+customerId.getCustomerId()+"";
		RestTemplate restTemplate = new RestTemplate();
		AccountDetails account = restTemplate.getForObject(url, AccountDetails.class);

		
		model.addAttribute("accountDetails", account);
		return "success";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
}
