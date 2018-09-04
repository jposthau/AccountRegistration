package com.capgemini.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.registration.model.RegistrationLog;
import com.capgemini.registration.repository.RegLogRepository;

@Service("regLogService")
public class RegLogServiceImpl implements RegLogService{

	@Autowired
	RegLogRepository regLogRepo;
	
	@Override
	public RegistrationLog saveRegLog(RegistrationLog regLog) {
		return regLogRepo.save(regLog);
	}

	@Override
	public RegistrationLog getRegLogByRegId(int regId) {
		return regLogRepo.findByRegistrationId(regId).get();
	}
}