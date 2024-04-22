package com.hcl.restaurant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.hcl.restaurant.dao.DBFactory;
import com.hcl.restaurant.dao.IUserDao;
import com.hcl.restaurant.dao.UserDaoImp;
import com.hcl.restaurant.pojo.User;

public class ServiceUserImp implements IServiceUser{
	
	
	IUserDao dao;
	
	public ServiceUserImp() {
			
			dao = new UserDaoImp();
			
			
			
		}
	
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}

	public boolean validateUserLogin(String userName, String password) {
		
		boolean userFound = false;
		List<User> userList = dao.getAllUser();
		
		for (User user : userList) {
			
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				userFound = true;
				break;		
				
			}
			
		}
		return userFound;
	}
	
	

}
