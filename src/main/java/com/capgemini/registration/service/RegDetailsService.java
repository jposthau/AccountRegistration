package com.capgemini.registration.service;

import java.util.Optional;

import com.capgemini.registration.model.Login;
import com.capgemini.registration.model.RegistrationDetails;

public interface RegDetailsService {
	
	RegistrationDetails saveRegDetails(RegistrationDetails regDetails);
	
	Optional<RegistrationDetails> findRegDetailsByCustId(Long custId);
	
	RegistrationDetails findRegByUsername(String username);
	RegistrationDetails findByUserNameAndPassword(Login login);
	
}