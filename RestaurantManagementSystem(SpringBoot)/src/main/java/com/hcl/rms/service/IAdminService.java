package com.hcl.rms.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.hcl.rms.entities.Admin;
import com.hcl.rms.entities.Order;

public interface IAdminService {

	
	public ResponseEntity<String> registerAdmin(Admin admin);
	
	public ResponseEntity<String> login(String adminName,String password, HttpSession session);
	
	public int ShowAllTodaysBill(LocalDate date);
	
	public String showUserBill(long userId);
	
	public int totalMonthlyBill(LocalDate date);
}
