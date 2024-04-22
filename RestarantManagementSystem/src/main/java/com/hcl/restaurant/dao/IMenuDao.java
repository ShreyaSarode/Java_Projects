package com.hcl.restaurant.dao;

import java.util.List;

import com.hcl.restaurant.pojo.Menu;

public interface IMenuDao {
	
	public int addMenu(Menu menu);
	
	public int updateMenu(Menu menu);
	
	public int deleteMenu(int itemId);
	
	public Menu searchMenuById(int itemId);
	
	public Menu searchMenuByItem(String item);
	
	public List<Menu> selectAllMenu();
	

}
