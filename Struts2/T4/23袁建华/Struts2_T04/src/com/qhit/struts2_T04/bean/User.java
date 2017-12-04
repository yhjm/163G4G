package com.qhit.struts2_T04.bean;

public class User {

	
	private String uname;
	private String upwd;
	private int  sex;
	private String eduction;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEduction() {
		return eduction;
	}
	public void setEduction(String eduction) {
		this.eduction = eduction;
	}
	public User(String uname, String upwd, int sex, String eduction) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.eduction = eduction;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
