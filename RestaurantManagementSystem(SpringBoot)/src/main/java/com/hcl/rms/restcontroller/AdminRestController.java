package com.hcl.rms.restcontroller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rms.entities.Admin;
import com.hcl.rms.entities.Menu;
import com.hcl.rms.entities.Order;
import com.hcl.rms.entities.User;
import com.hcl.rms.service.IAdminService;
import com.hcl.rms.service.IMenuService;
import com.hcl.rms.service.IUserService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

	@Autowired
	IAdminService service;
	
	@Autowired
	IMenuService service1;
	
	@Autowired
	IUserService service2;
	
	
	
	

	// admin registration

	@PostMapping("/AdminRegister")
	public ResponseEntity<String> register(@RequestBody Admin admin) {

		return service.registerAdmin(admin);

	}

	// admin login
	
	@GetMapping("/AdminLogin/{adminName}/{password}")
	public ResponseEntity<String> login(@PathVariable String adminName, @PathVariable String password, HttpSession session) {

		return service.login(adminName, password, session);

	}

	
	/**
	 * 
	 * CRUD Operations on User
	 */
	
	//add user
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user, HttpStatus session){
		
		return service2.registerUser(user);
	}
	
	//update user
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user, HttpStatus session){
		
		return service2.updateUser(user);
	}
	
	
	//get user
	@GetMapping("/getUser/{userId}")
	public User getUserByuserId(@PathVariable long userId) {
		
		User user = service2.getUserById(userId);
		
		return user;
	}
	

	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable long userId) {
		
		return service2.deleteUser(userId);
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUsers(){
		
		return service2.getAllUsers();
	}
	
	
	/**
	 * 
	 * CRUD Operations on menu
	 */
	
	// add menu

	@PostMapping("/addMenu")
	public ResponseEntity<String> addMenu(@RequestBody Menu menu, HttpSession session) {

		return service1.addMenu(menu);



	}

	// update menu

	@PutMapping("/updateMenu")
	public ResponseEntity<String> updateMenu(@RequestBody Menu menu, HttpSession session) {

		return service1.updateMenu(menu);

	}
	
	
	

	// Delete menu

	@DeleteMapping("/deleteMenu/{itemId}")
	public String deleteMenu(@PathVariable long itemId, HttpSession session) {

		service1.deleteMenu(itemId);

		return "Menu deleted successfully";

	}

	// Select menu by id

	@GetMapping("/selectMenu/{itemId}")
	public Menu selectMenu(@PathVariable long itemId, HttpSession session) {

		Menu menu = service1.searchMenuById(itemId);

		ResponseEntity<String> response = null;

		if (menu != null) {
			response = new ResponseEntity<String>("menu selected", HttpStatus.OK);
		} else {

			response = new ResponseEntity<String>("not selected", HttpStatus.BAD_REQUEST);
		}

		return menu;

	}

	// get all menu

	@GetMapping("/getAllMenu")
	public List<Menu> getAllMenu(HttpSession session) {

		return service1.getAllMenu();

	}

	// Get Today's Total Generated Bill

	@GetMapping("/getToday'sSales")
	public int Showallbillstoday() {
		LocalDate date = LocalDate.now();
		return service.ShowAllTodaysBill(date);
	}

	// Get Bill of Particular User
	@GetMapping("/showUserBill/{userId}")
	public String UserBill(@PathVariable long userId) {
		return service.showUserBill(userId);
	}

	// Get Total Monthly sale
	@GetMapping("/getMonthlySale")

	public int totalMonthlySale() {

		LocalDate date = LocalDate.now();
		return service.totalMonthlyBill(date);

	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		
		session.invalidate();
		return "Logout Sucess";
		
		

	}

}
