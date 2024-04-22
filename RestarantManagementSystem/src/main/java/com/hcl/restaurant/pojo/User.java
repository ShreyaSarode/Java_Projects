package com.hcl.restaurant.pojo;

public class User {
	
	private int userId;
	private String userName;
	private long contactNo;
	private String password;
	
	
	public User(int userId, String userName, int contactNo, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.contactNo = contactNo;
		this.password = password;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public long getContactNo() {
		return contactNo;
	}


	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", contactNo=" + contactNo + ", password="
				+ password + "]";
	}


	
	
	
	
	

}
