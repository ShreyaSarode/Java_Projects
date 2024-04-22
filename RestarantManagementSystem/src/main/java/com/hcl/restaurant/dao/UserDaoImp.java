package com.hcl.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hcl.restaurant.pojo.User;

public class UserDaoImp implements IUserDao {
	
	Connection conn = DBFactory.getDBConnection();
	PreparedStatement pstmt;

	public int addUser(User user) {
		String insertQuery = "insert into users(user_id, user_name, contact_no, password) value(?,?,?,?)";
		int count = 0;

		try {
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setLong(3, user.getContactNo());
			pstmt.setString(4, user.getPassword());

			
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public List<User> getAllUser() {
		List<User> userList = null;

		try {

			String selectAllQuery = "select * from users";

			pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			userList = new ArrayList<User>();

			while (rs.next()) {
				
				
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				Long contactNo = rs.getLong("contact_no");
				String password = rs.getString("password");


				User user = new User();
				
				user.setUserId(userId);
				user.setUserName(userName);
				user.setContactNo(contactNo);
				user.setPassword(password);


				userList.add(user);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

}
