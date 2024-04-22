package com.hcl.restaurant.service;

import java.util.List;

import com.hcl.restaurant.pojo.User;

public interface IServiceUser {
	
	public int addUser(User user);

	public List<User> getAllUser();
	
	public boolean validateUserLogin(String userName, String password);

}
