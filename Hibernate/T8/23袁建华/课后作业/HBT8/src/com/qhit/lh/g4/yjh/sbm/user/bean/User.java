package com.qhit.lh.g4.yjh.sbm.user.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;

	private String userName;
	private String userPassword;
	private String userSex;
	private Integer userAge;
	private String telephone;
	private String address;
	private String pic;
	private Integer type;

	// Constructors
	public User(Integer userId, String userName, String userPassword,
			String userSex, Integer userAge, String telephone, String address,
			String pic, Integer type) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userAge = userAge;
		this.telephone = telephone;
		this.address = address;
		this.pic = pic;
		this.type = type;
	}

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String userPassword, String userSex,
			String telephone, String address, String pic, Integer type) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.telephone = telephone;
		this.address = address;
		this.pic = pic;
		this.type = type;
	}

	/** full constructor */
	public User(String userName, String userPassword, String userSex,
			Integer userAge, String telephone, String address, String pic,
			Integer type) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userAge = userAge;
		this.telephone = telephone;
		this.address = address;
		this.pic = pic;
		this.type = type;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}