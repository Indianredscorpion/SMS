package com.sms.service;

import com.sms.entity.User;

public interface UserService {

	//method to login into the system using userName and password
	User login(String userName, String password);
}
