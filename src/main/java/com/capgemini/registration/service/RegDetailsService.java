package com.capgemini.registration.service;

import com.capgemini.registration.model.RegistrationDetails;

public interface RegDetailsService {
	
	RegistrationDetails saveRegDetails(RegistrationDetails regDetails);
	
	RegistrationDetails getRegDetailsByCustId(Long custId);
}