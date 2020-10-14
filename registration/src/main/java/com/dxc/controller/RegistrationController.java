package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.User;
import com.dxc.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	 RegistrationService service;
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("registeruser")
	
	
	public User registerUser(@RequestBody User user) throws Exception {
		String tempUserName = user.getUserName();
		if (tempUserName != null && !"".equals(tempUserName)) {
			User userobj = service.fetchUserByUserName(tempUserName);
			if (userobj != null) {
				throw new Exception("user with " + tempUserName + " is already exist");
			}

		}

		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;

	}
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("login")
	
	public User loginUser(@RequestBody User user) throws Exception {
		String tempUserName = user.getUserName();
		String tempPass= user.getPassword();
		User userObj = null;
		if(tempUserName != null && tempPass != null) {
			userObj =service.fetchUserByUserNameAndPassword(tempUserName, tempPass);
		}
		if(userObj==null) {
			throw new Exception("bad credentials");
		}
		return userObj;
	}
}