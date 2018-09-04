package com.capgemini.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public RegistrationDetails getRegDetailsByCustId(Long custId) {
		return regDetailsRepo.findByCustomerId(custId).get();
	}
}