package com.hcl.rms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.rms.entities.Menu;
import com.hcl.rms.entities.Order;
import com.hcl.rms.entities.User;
import com.hcl.rms.exceptions.UserNotFoundException;
import com.hcl.rms.repository.MenuRepository;
import com.hcl.rms.repository.OrderRepository;
import com.hcl.rms.repository.UserRepository;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	UserRepository repo;  		// User Repository


	@Autowired
	OrderRepository repo1;  	// Order Repository

	@Autowired
	MenuRepository repo2;   	// Menu Repository

	// User Registration
	@Override
	public ResponseEntity<String> registerUser(User user) {

		ResponseEntity<String> response = null;

		User user1 = repo.save(user);

		if (user1 != null) {

			response = new ResponseEntity<String>("User Registered Successfully", HttpStatus.ACCEPTED);
		}

		else {
			response = new ResponseEntity<String>("Resistration failed", HttpStatus.EXPECTATION_FAILED);
		}

		return response;

	}

	
	//login user
	
	@Override
	public ResponseEntity<String> loginUser(String userName, String password, HttpSession session) {

		User user = repo.findByUserName(userName);

		ResponseEntity<String> response = null;

		if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {

			session.setAttribute("userName", userName);
			session.setAttribute("password", password);

			response = new ResponseEntity<String>("Login Success", HttpStatus.OK);

		} else {

			response = new ResponseEntity<String>("Login Failed", HttpStatus.BAD_REQUEST);

		}

		return response;

	}
	
	//update user

	@Override
	public ResponseEntity<String> updateUser(User user) {

		ResponseEntity<String> response = null;

		User user1 = repo.save(user);

		if (user1 != null) {

			response = new ResponseEntity<String>("User Updated Successfully", HttpStatus.ACCEPTED);
		}

		else {
			response = new ResponseEntity<String>("Resistration failed", HttpStatus.EXPECTATION_FAILED);
		}

		return response;
	}
	
	// get user

	@Override
	public User getUserById(long userId) {

		return repo.findById(userId).orElseThrow(() -> new UserNotFoundException());

	}

	//delete user
	
	@Override
	public String deleteUser(long userId) {
		try {

			repo.deleteById(userId);

			return "user deleted successfully";

		} catch (Exception e) {

			throw new UserNotFoundException();
		}

	}

	// get userList
	
	@Override
	public List<User> getAllUsers() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw new UserNotFoundException();
		}

	}

	// user should able to take order
	@Override
	public ResponseEntity<String> addOrder(Order order) {

		ResponseEntity<String> response = null;

		if (order.getOrderId() > 0 && order.getQuantity() > 0) {

			int sum = 0;
			LocalDate date = LocalDate.now();
			Menu menu = repo2.findByItemName(order.getItemName());

			Order order1 = new Order();
			int price = menu.getPrice();
			sum = price * order.getQuantity();
			order1.setOrderId(order.getOrderId());
			order1.setItemName(order.getItemName());
			order1.setTotalAmount(sum);
			order1.setUserId(order.getUserId());
			order1.setQuantity(order.getQuantity());
			order1.setDate(date);

			repo1.save(order1);

			response = new ResponseEntity<String>("Order added successfully...", HttpStatus.ACCEPTED);

		}

		else {

			response = new ResponseEntity<String>("Invalid order details...", HttpStatus.NOT_ACCEPTABLE);
		}

		return response;

	}

	// user can see order by entering userId
	@Override
	public List<Order> UserOrders(long userId) {

		return repo1.findByUserId(userId);
	}

	List<Menu> menu = new ArrayList<Menu>();

	// User can see final bill
	@Override
	public String FinalBill(long userId) {

		List<Order> ord = repo1.findByUserId(userId);
		
		int sum = 0;
		for (Order order : ord) {
			
				sum = sum + order.getTotalAmount();
			
		}
		return "final Bill: " + sum;
	}

}
