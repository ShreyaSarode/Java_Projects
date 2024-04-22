package com.hcl.rms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hcl.rms.entities.Menu;



public interface IMenuService {

	public ResponseEntity<String> addMenu(Menu menu);

	public ResponseEntity<String> updateMenu(Menu menu);
	
	public Menu searchMenuById(long itemId);
	
	public Menu searchMenuByName(String itemName);
	
	public String deleteMenu(long itemId);
	
	public   List<Menu>  getAllMenu();
}
