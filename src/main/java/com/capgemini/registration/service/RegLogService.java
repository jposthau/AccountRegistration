package com.capgemini.registration.service;

import com.capgemini.registration.model.RegistrationLog;

public interface RegLogService {
	
	RegistrationLog saveRegLog(RegistrationLog regLog);
	
	RegistrationLog getRegLogByRegId(int regId);
}