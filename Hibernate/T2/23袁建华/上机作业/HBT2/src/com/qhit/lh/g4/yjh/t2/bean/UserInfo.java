package com.qhit.lh.g4.yjh.t2.bean;

public class UserInfo {
	private int userId;
	private String userName;
	private String password;
	private Emp emp;
	private UserInfo(int userId, String userName, String password, Emp emp) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emp = emp;
	}
	private UserInfo(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public UserInfo() {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}
