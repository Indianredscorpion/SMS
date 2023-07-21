package com.sms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.User;
import com.sms.repository.UserRepository;
import com.sms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User login(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}

}
