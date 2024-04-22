package com.hcl.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hcl.restaurant.pojo.Menu;

public class MenuDaoImp implements IMenuDao {
	
	Connection conn = DBFactory.getDBConnection();
	PreparedStatement pstmt;
	
	

	@Override
	public int addMenu(Menu menu) {
		
		
		String insertQuery = "insert into menu(item_id, item, price) value(?,?,?)";
		int count = 0;

		try {
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setInt(1, menu.getItemId());
			pstmt.setString(2, menu.getItem());
			pstmt.setDouble(3, menu.getPrice());

			
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int updateMenu(Menu menu) {
		String insertQuery = "update menu set item = ?, price = ? where item_id = ?";
		int count = 0;

		try {
			pstmt = conn.prepareStatement(insertQuery);
			
			
			pstmt.setString(1, menu.getItem());
			pstmt.setDouble(2, menu.getPrice());
			pstmt.setInt(3, menu.getItemId());

			
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int deleteMenu(int itemId) {
		String deleteQuery = "delete from menu where item_id = ?";
		int count = 0;

		try {
			pstmt = conn.prepareStatement(deleteQuery);

			pstmt.setInt(1, itemId);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public Menu searchMenuById(int itemId) {
		String searchQuery = "select * from menu where item_id = ?";
		int count = 0;

		Menu menu = new Menu();

		try {

			pstmt = conn.prepareStatement(searchQuery);

			pstmt.setInt(1, itemId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				
				int itemId1 = rs.getInt("item_id");
				String item = rs.getString("item");
				Double price = rs.getDouble("price");
				
				menu.setItemId(itemId);
				menu.setItem(item);
				menu.setPrice(price);


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menu;
	}

	@Override
	public List<Menu> selectAllMenu() {
		List<Menu> menuList = null;

		try {

			String selectAllQuery = "select * from menu";

			pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			menuList = new ArrayList<Menu>();

			while (rs.next()) {

				int itemId = rs.getInt("item_id");
				String item = rs.getString("item");
				Double price = rs.getDouble("price");

				Menu menu = new Menu();
				
				menu.setItemId(itemId);
				menu.setItem(item);
				menu.setPrice(price);

				menuList.add(menu);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menuList;
	}

	@Override
	public Menu searchMenuByItem(String item) {
		
		String searchQuery = "select * from menu where item = ?";
		int count = 0;

		Menu menu = new Menu();

		try {

			pstmt = conn.prepareStatement(searchQuery);

			pstmt.setString(1, item);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				
				int itemId1 = rs.getInt("item_id");
				String item1 = rs.getString("item");
				Double price = rs.getDouble("price");
				
				menu.setItemId(itemId1);
				menu.setItem(item1);
				menu.setPrice(price);


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menu;
		
		
	}

}
