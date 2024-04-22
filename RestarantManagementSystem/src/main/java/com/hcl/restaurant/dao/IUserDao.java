package com.hcl.restaurant.dao;

import java.util.List;

import com.hcl.restaurant.pojo.User;

public interface IUserDao {
	
	public int addUser(User user); // add user in user table
	
	public List<User> getAllUser(); // get all user if admin want

}
