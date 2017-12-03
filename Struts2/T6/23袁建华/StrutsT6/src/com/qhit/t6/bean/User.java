package com.qhit.t6.bean;

public class User {
	private int id;
	private String uname;
	private String upwd;
	private String birthday;
	private String sex;
	
	/**
	 * @param id
	 * @param uname
	 * @param upwd
	 * @param birthday
	 * @param sex
	 */
	public User(int id, String uname, String upwd, String birthday, String sex) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.birthday = birthday;
		this.sex = sex;
	}
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname1() {
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Object getUname() {
		// TODO Auto-generated method stub
		return null;
	}
}
