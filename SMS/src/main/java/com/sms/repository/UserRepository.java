package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.User;

//we are inheriting the CRUD operations

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserNameAndPassword(String userName, String password);
}
