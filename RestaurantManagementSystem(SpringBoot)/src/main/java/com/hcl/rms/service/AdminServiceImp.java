package com.hcl.rms.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.rms.entities.Admin;
import com.hcl.rms.entities.Order;
import com.hcl.rms.entities.User;
import com.hcl.rms.repository.AdminRepository;
import com.hcl.rms.repository.OrderRepository;

@Service
public class AdminServiceImp implements IAdminService {

	
	@Autowired
	AdminRepository repo; //admin repository

	
	@Autowired
	OrderRepository repo1; // Order Repository

	
	//Admin Registration
	
	@Override
	public ResponseEntity<String> registerAdmin(Admin admin) {
		ResponseEntity<String> response = null;

		Admin admin1 = repo.save(admin);

		if (admin1 != null) {

			response = new ResponseEntity<String>("Admin Registered Successfully", HttpStatus.ACCEPTED);
		}

		else {
			response = new ResponseEntity<String>("Resistration failed", HttpStatus.EXPECTATION_FAILED);
		}

		return response;
	}
	
	// admin login

	@Override
	public ResponseEntity<String> login(String adminName,String password, HttpSession session) {

		Admin admin = repo.findByAdminName(adminName);

		ResponseEntity<String> response = null;

		if (admin.getAdminName().equals(adminName) && admin.getPassword().equals(password)) {

			session.setAttribute("adminName", adminName);
			session.setAttribute("password", password);

			response = new ResponseEntity<String>("Login Success", HttpStatus.OK);

		} else {
			response = new ResponseEntity<String>("Login Failed", HttpStatus.BAD_REQUEST);
		}

		return response;

	}
	
	

	
	//display today's generated bill
	@Override
	public int ShowAllTodaysBill(LocalDate date) {
			

		return repo1.calculateBillByDate(date); 
	}

	// display the bill of particular user
	@Override
	public String showUserBill(long userId) {

		List<Order> ord = repo1.findByUserId(userId);
		
		int sum = 0;
		for (Order order : ord) {
			
				sum = sum + order.getTotalAmount();         
			
		}
		return "final user Bill: " + sum;
	}

	// display total monthly Bill 
	@Override
	public int totalMonthlyBill(LocalDate date) {
		
		return repo1.totalMonthlyBill(date);
	}

}
