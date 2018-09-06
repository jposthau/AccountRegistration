package com.capgemini.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.registration.model.RegistrationDetails;

public interface RegDetailsRepository extends JpaRepository<RegistrationDetails, Integer>{
	
	public Optional<RegistrationDetails> findByCustomerId(Long id);
	
	public RegistrationDetails findByUsername(String username);
	
}
