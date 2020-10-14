package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
	public User findByUserName(String userName);
	public User findByUserNameAndPassword(String username, String password);

}
