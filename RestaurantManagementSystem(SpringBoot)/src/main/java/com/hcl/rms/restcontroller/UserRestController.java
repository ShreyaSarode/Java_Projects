package com.hcl.rms.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rms.entities.Admin;
import com.hcl.rms.entities.Menu;
import com.hcl.rms.entities.Order;
import com.hcl.rms.entities.User;
import com.hcl.rms.service.IMenuService;
import com.hcl.rms.service.IUserService;

@RestController
@RequestMapping("api/user")
public class UserRestController {
	
	@Autowired
	IUserService service;
	
	@Autowired
	IMenuService service1;
	
	@PostMapping("/register")
	public ResponseEntity<String> Register(@RequestBody User user) {

		return service.registerUser(user);

	}
	
	@GetMapping("/login/{userName}/{password}")
	public ResponseEntity<String> login(@PathVariable String userName, @PathVariable String password, HttpSession session) {

		return service.loginUser(userName, password, session);
	
	}	
	
	
	
	@GetMapping("/getAllMenuList")
	public List<Menu> getAllMenu(HttpSession session) {

		List<Menu> menuList = service1.getAllMenu();

		ResponseEntity<String> response = null;

		if (menuList != null) {

			response = new ResponseEntity<String>("get List", HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Not selected", HttpStatus.BAD_REQUEST);
		}

		return menuList;

	}
	
	@PostMapping("/order")
	public ResponseEntity<String> takeOrder(@RequestBody Order order) {
		return service.addOrder(order);
	}

	
	@GetMapping("/order/{userId}")
	public List<Order> UserOrders(@PathVariable long userId) {
		return service.UserOrders(userId);
	}

	
	

	
	@GetMapping("/finalbill/{userId}")
	public String FinalBill(@PathVariable long userId) { //displaying final bill
		return service.FinalBill(userId);
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		
		session.invalidate();
		return "Logout Sucess";
		
		

	}
	
}
