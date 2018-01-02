package com.qhit.lh.g4.yjh.ts1.bean;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String name;
	private String password;
	private Date birthday;
	private String sex;
	private String isable;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, String password, Date birthday, String sex,
			String isable) {
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.isable = isable;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIsable() {
		return this.isable;
	}

	public void setIsable(String isable) {
		this.isable = isable;
	}

}