package com.hcl.restaurant.service;

import java.util.List;

import com.hcl.restaurant.pojo.Menu;

public interface IServiceMenu {

	public int addMenu(Menu menu); // add Menu by admin

	public int updateMenu(Menu menu); // update menu admin

	public int deleteMenu(int itemId); // delete menu by admin

	public Menu searchMenuById(int itemId); // search menu

	public List<Menu> selectAllMenu();	// select menu

	public Menu searchMenuByItem(String item); // search menu by item

}
