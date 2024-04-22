package com.hcl.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.rms.entities.Menu;
import com.hcl.rms.exceptions.ItemNotFoundException;
import com.hcl.rms.repository.MenuRepository;

@Service
public class MenuServiceImp implements IMenuService {

	@Autowired
	MenuRepository repo;

	@Override
	public ResponseEntity<String> addMenu(Menu menu) {

		ResponseEntity<String> response = null;

		if (menu.getItemId() > 0 && menu.getPrice() > 0) {
			repo.save(menu);

			response = new ResponseEntity<String>("Item added successfully...", HttpStatus.ACCEPTED);

		}

		else {

			response = new ResponseEntity<String>("Invalid item details...", HttpStatus.NOT_ACCEPTABLE);
		}

		return response;
	}

	@Override
	public ResponseEntity<String> updateMenu(Menu menu) {

		ResponseEntity<String> response = null;

		if (menu.getItemId() > 0 && menu.getPrice() > 0) {
			repo.save(menu);

			response = new ResponseEntity<String>("Item updated successfully...", HttpStatus.ACCEPTED);

		}

		else {

			response = new ResponseEntity<String>("Invalid item details...", HttpStatus.NOT_ACCEPTABLE);
		}

		return response;
	}

	@Override
	public Menu searchMenuById(long itemId) {

		
		Menu menu = repo.findById(itemId).orElseThrow(() -> new ItemNotFoundException());


		return menu;
	}

	@Override
	public Menu searchMenuByName(String itemName) {
		
		try {
			return repo.findByItemName(itemName);
		}
		catch(Exception e) {
			throw new ItemNotFoundException();
		}
		
	}

	@Override
	public String deleteMenu(long itemId) {

		try {
			repo.deleteMenuById(itemId);

			return "Menu Deleted Successfully";
		}
		catch(Exception e) {
			
			throw new ItemNotFoundException();
		}
		
	}

	@Override
	public List<Menu> getAllMenu() {
		
		List<Menu> menuList = repo.findAll();

		return menuList;
		
	}

}
