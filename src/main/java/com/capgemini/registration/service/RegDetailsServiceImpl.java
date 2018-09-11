package com.capgemini.registration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.registration.model.Login;
import com.capgemini.registration.model.RegistrationDetails;
import com.capgemini.registration.repository.RegDetailsRepository;

@Service("regDetailsService")
public class RegDetailsServiceImpl implements RegDetailsService{

	@Autowired
	RegDetailsRepository regDetailsRepo;
	
    
	
	@Override
	public RegistrationDetails saveRegDetails(RegistrationDetails regDetails) {
		return regDetailsRepo.save(regDetails);
	}

	@Override
	public Optional<RegistrationDetails> findRegDetailsByCustId(Long custId) {
		return regDetailsRepo.findByCustomerId(custId);
	}
	
	@Override
	public RegistrationDetails findRegByUsername(String username) {
		return regDetailsRepo.findByUsername(username);
	}

	@Override
	public RegistrationDetails findByUserNameAndPassword(Login login) {
		// TODO Auto-generated method stub
		return regDetailsRepo.findByUserNameAndPassword(login.getUsername(), login.getPassword());
	}
}