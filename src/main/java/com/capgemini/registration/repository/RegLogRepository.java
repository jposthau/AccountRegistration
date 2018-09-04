package com.capgemini.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.registration.model.RegistrationLog;

public interface RegLogRepository extends JpaRepository<RegistrationLog, Long>{
	
	public Optional<RegistrationLog> findByRegistrationId(int id);
	
}
