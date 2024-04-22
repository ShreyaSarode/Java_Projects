package com.hcl.restaurant.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hcl.restaurant.exceptions.AdminNotFoundException;
import com.hcl.restaurant.exceptions.UserNotFoundException;
import com.hcl.restaurant.pojo.Menu;
import com.hcl.restaurant.pojo.User;
import com.hcl.restaurant.service.IServiceMenu;
import com.hcl.restaurant.service.IServiceUser;
import com.hcl.restaurant.service.ServiceMenuImp;
import com.hcl.restaurant.service.ServiceUserImp;

public class RestaurantManagement {

	

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		IServiceUser service = new ServiceUserImp();
		IServiceMenu service1 = new ServiceMenuImp();
		
		boolean flags = true;
		while(flags) {
			
			System.out.println("***Welcome to the Restaurant***");
			System.out.println("1 User Login");
			System.out.println("2. User Resistration");
			System.out.println("3. Admin Login");
			System.out.println("0. Exit");
			
			int key = in.nextInt();

			switch (key) {
			case 1:
				
				//User Login
				System.out.println("**Login Yourself**");

				System.out.println("Enter userName :");
				String userName = in.next();
				System.out.println("Enter password :");
				String password = in.next();
				
				//User Validation
				boolean userExist = service.validateUserLogin(userName, password);

				if (userExist) {
					System.out.println("You are successfully Logged in...");

					System.out.println("***Available items are : ***");
					
					// Show item list to the user

					List<Menu> menuList = service1.selectAllMenu();

					for (Menu menu2 : menuList) {

						System.out.println(menu2);
					}
					
					// order the item
					System.out.println("**Select Item which you want to order**");

					String item = in.next();

					Menu searchedMenu = service1.searchMenuByItem(item);

					if (searchedMenu != null) {

						System.out.println(searchedMenu);

						System.out.println("How many Plates You want");
						int countPlates = in.nextInt();
						
						//bill count

						Double Bill = countPlates * searchedMenu.getPrice();

						System.out.println("Your Bill is :" + Bill);


					} else {

						System.err.println("menu Not Found");
					}

				} else {
					
					try {
						throw new UserNotFoundException();
					} catch (UserNotFoundException e) {
						e.printStackTrace();
						System.out.println("Login failed");
					}
					
				}

				break;

			case 2:
				
				// User Registration
				System.out.println("**Register Yourself**");
				System.out.println("Enter UserId: ");
				int userId = in.nextInt();
				System.out.println("Enter User Name: ");
				String userName1 = in.next();
				System.out.println("Enter Contact No. : ");
				Long contactNo = in.nextLong();
				System.out.println("Enter Password: ");
				String password1 = in.next();

				User user = new User();

				user.setUserId(userId);
				user.setUserName(userName1);
				user.setContactNo(contactNo);
				user.setPassword(password1);

				int count = service.addUser(user);

				if (count > 0) {
					System.out.println("you are register successfully ");

				} else {
					System.out.println("Registration Failed");
				}

				break;

			case 3:
				// Admin Login
				System.out.println("**Login as a Admin**");
				System.out.println("Enter Admin Name: ");
				String adminName = in.next();
				System.out.println("Enter your Password: ");
				String adminPassword = in.next();

				if (adminName.equals("Yogeshri") && adminPassword.equals("Yogi@123")) {
					System.out.println("You are successfully logged in...");

					boolean flag = true;

					while (flag) {
						System.out.println("1. Add Menu");
						System.out.println("2. Update Menu");
						System.out.println("3. Delete Menu");
						System.out.println("4. Search Menu");
						System.out.println("5. Select All Menu");
						System.out.println("0. Exit");

						System.out.println("Enter Your Choice...");

						int choice = in.nextInt();

						switch (choice) {
						case 1:
							// add menu
							System.out.println("**Add Menu**");
							System.out.println("Enter item Id: ");
							int item_id = in.nextInt();
							System.out.println("Enter Item Name: ");
							String item = in.next();
							System.out.println("Enter price: ");
							Double price = in.nextDouble();

							Menu menu = new Menu();

							menu.setItemId(item_id);
							menu.setItem(item);
							menu.setPrice(price);

							int count1 = service1.addMenu(menu);

							if (count1 > 0) {
								System.out.println(count1 + " Item Added Successfully ");

							} else {
								System.out.println("Add Failed");
							}

							break;

						case 2:
							
							// update menu

							System.out.println("**Update Menu**");

							System.out.println("Enter item Id: ");
							int item_id1 = in.nextInt();
							System.out.println("Enter Item Name: ");
							String item1 = in.next();
							System.out.println("Enter price: ");
							Double price1 = in.nextDouble();

							Menu menu1 = new Menu();

							menu1.setItemId(item_id1);
							menu1.setItem(item1);
							menu1.setPrice(price1);

							int count2 = service1.updateMenu(menu1);

							if (count2 > 0) {
								System.out.println(count2 + " Item Updated Successfully ");

							} else {
								System.out.println("Update Failed");
							}
							break;

							// delete menu from menu table
						case 3:
							System.out.println("**Delete Menu**");

							System.out.println("Enter Item Id to Delete Menu");

							int itemId = in.nextInt();

							int n1 = service1.deleteMenu(itemId);

							if (n1 > 0) {

								System.out.println(n1 + " Menu Deleted Successfully");

							} else {

								System.err.println("Delete Failed...");
							}
							break;

						case 4:
							
							// search menu
							System.out.println("Enter Id to Search/Select Menu");

							int itemId1 = in.nextInt();

							Menu searchedMenu = service1.searchMenuById(itemId1);

							if (searchedMenu != null) {

								System.out.println(searchedMenu);

							} else {

								System.err.println("Menu Not Found");
							}
							break;

						case 5:
							
							// select all menu
							List<Menu> menuList = service1.selectAllMenu();

							for (Menu menu2 : menuList) {

								System.out.println(menu2);
							}
							break;

						

						case 0:
							// exit
							flag = false;
							System.err.println("You are exit");
							break;

						default: System.out.println("wrong choice...enter again");
							break;
						}

					}

				} 
				else {
					try {
						throw new AdminNotFoundException();
					} catch (AdminNotFoundException e) {
						e.printStackTrace();
						System.out.println("Login failed");
					}
				}
				break;
				
			case 0 : flags = false;
			System.out.println("You are exit");
			break;

			default: System.out.println("Try again");
				break;
			}

			
			
		}
		
	}

}
