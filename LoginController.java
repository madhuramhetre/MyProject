package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Status;
import com.model.User;
import com.service.UserServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	private UserServiceImpl userservice;
	@RequestMapping(value="/user", headers="Accept=application/json",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Status validate(@RequestBody User user)
	{
		Status status=new Status();
		userservice.validUser(user);
		status.setCode(200);
		status.setMessage("User available");
		return status;
	}
}
