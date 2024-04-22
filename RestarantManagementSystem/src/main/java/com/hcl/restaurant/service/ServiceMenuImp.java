package com.hcl.restaurant.service;

import java.util.List;

import com.hcl.restaurant.dao.IMenuDao;
import com.hcl.restaurant.dao.MenuDaoImp;
import com.hcl.restaurant.pojo.Menu;

public class ServiceMenuImp implements IServiceMenu {

	IMenuDao dao = null;

	public ServiceMenuImp() {

		dao = new MenuDaoImp();

	}

	@Override
	public int addMenu(Menu menu) {

		return dao.addMenu(menu);
	}

	@Override
	public int updateMenu(Menu menu) {

		return dao.updateMenu(menu);
	}

	@Override
	public int deleteMenu(int itemId) {
		// TODO Auto-generated method stub
		return dao.deleteMenu(itemId);
	}

	@Override
	public Menu searchMenuById(int itemId) {
		// TODO Auto-generated method stub
		return dao.searchMenuById(itemId);
	}

	@Override
	public List<Menu> selectAllMenu() {
		// TODO Auto-generated method stub
		return dao.selectAllMenu();
	}

	@Override
	public Menu searchMenuByItem(String item) {
		// TODO Auto-generated method stub
		return dao.searchMenuByItem(item);
	}

}
