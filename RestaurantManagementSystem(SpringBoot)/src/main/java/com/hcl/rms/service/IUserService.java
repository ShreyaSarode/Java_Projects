package com.hcl.rms.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.hcl.rms.entities.Menu;
import com.hcl.rms.entities.Order;
import com.hcl.rms.entities.User;


public interface IUserService {
	
	public ResponseEntity<String> registerUser(User user); // user registration
	
	public ResponseEntity<String> loginUser(String userName, String password, HttpSession session); //login
	
	/*
	 * some crud operations on user handle by admin
	 */
	public ResponseEntity<String> updateUser(User user);
	
	public User getUserById(long userId);
	
	public String deleteUser(long userId);
	
	public List<User> getAllUsers();
	
	
	
	
	public ResponseEntity<String> addOrder(Order order); // user can add order
	
	public List<Order> UserOrders(long userId);  // user can see the order by entering userId
	
	public String FinalBill(long userId);     // user's final bill
	
	

}
