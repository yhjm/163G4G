package com.qhit.t3.bean;

public class User {
	private String uname;
	private String upwd;
	private String age;
	private String address;
	private String sex;
	
	public User(String uname, String upwd, String age, String address, String sex) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.address = address;
		this.sex = sex;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
