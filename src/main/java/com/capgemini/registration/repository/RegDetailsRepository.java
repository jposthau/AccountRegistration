package com.capgemini.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.registration.model.RegistrationDetails;

public interface RegDetailsRepository extends JpaRepository<RegistrationDetails, Integer>{
	
	public Optional<RegistrationDetails> findByCustomerId(Long id);
	
	public RegistrationDetails findByUsername(String username);
	
	@Query("select reg from RegistrationDetails reg where reg.username=:username and reg.password=:password")
	RegistrationDetails findByUserNameAndPassword(@Param("username") String username,@Param("password") String password);
	
}
