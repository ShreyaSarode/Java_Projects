package com.hcl.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFactory {
	
	private static Connection conn;
	
	private DBFactory() {
		
	}
	
	public static Connection getDBConnection() {
		
		if(conn == null) {
			
		
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "Yogi@1234");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		}
		
		return conn;
		
	}

}
