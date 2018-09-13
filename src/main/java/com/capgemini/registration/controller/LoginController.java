// Register login Controller

package com.capgemini.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String init(Model model) {
		model.addAttribute("login", new Login());
		model.addAttribute("message", "Please Enter your login details");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(@ModelAttribute("login") Login login, BindingResult bindingResult, Model model) {
		if (login != null && login.getUsername() != null && login.getPassword() != null) {

			login.setPassword(bCryptPasswordEncoder.encode(login.getPassword()));
			RegistrationDetails registrationDetails = regDetServiceImpl.findByUserNameAndPassword(login);
			if (!StringUtils.isEmpty(registrationDetails)) {
				
				return "success";

			} else {
				model.addAttribute("error", "Username or Password is wrong. Please enter again.");
				return "login";
			}

		} else {
			model.addAttribute("error", "Enter Username and password");
			return "login";
		}
	}

	@RequestMapping(value="/success", method = RequestMethod.GET)
	public String showAccount(Authentication authentication, Model model) {
		
		RegistrationDetails customerId = regDetServiceImpl.findCustIdByUsername(authentication.getName());
		System.out.println(customerId);
		
		String url = "http://localhost:8082/login/accountDetails/"+customerId.getCustomerId()+"";
		RestTemplate restTemplate = new RestTemplate();
		AccountDetails account = restTemplate.getForObject(url, AccountDetails.class);

		
		model.addAttribute("accountDetails", account);
		return "success";
	}
}
