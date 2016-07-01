package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDaoImpl;
import com.model.User;
@Service
public class UserServiceImpl implements UserServiceInterface{

	@Autowired
	private UserDaoImpl dao;
	@Override
	public boolean validUser(User user) {
		
		return  dao.validate(user);
	}
	
}
