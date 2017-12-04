package com.qhit.sbm.user.bean;

public class User {
	private int  userId;
	private int  userAge;
	private int  type;
	private String userName;
	private String userPassword;
	private String userSex;
	private String  telephone;
	private String  address;
	private String  pic;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, int userAge, int type, String userName,
			String userPassword, String userSex, String telephone,
			String address, String pic) {
		super();
		this.userId = userId;
		this.userAge = userAge;
		this.type = type;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.telephone = telephone;
		this.address = address;
		this.pic = pic;
	}
	public User(int userAge, int type, String userName, String userPassword,
			String userSex, String telephone, String address, String pic) {
		super();
		this.userAge = userAge;
		this.type = type;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.telephone = telephone;
		this.address = address;
		this.pic = pic;
	}
	
	
	
}
