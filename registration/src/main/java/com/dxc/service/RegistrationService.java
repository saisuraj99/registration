package com.dxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.User;
import com.dxc.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user) {
		
		return repo.save(user);
		
	}
	public User fetchUserByUserName(String userName) {
		return repo.findByUserName(userName);
	}
	
	public User fetchUserByUserNameAndPassword(String username, String password) {
		return repo.findByUserNameAndPassword(username, password);
	}

}
