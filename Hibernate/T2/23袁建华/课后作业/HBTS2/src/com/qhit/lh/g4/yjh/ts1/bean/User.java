package com.qhit.lh.g4.yjh.ts1.bean;

import java.util.Date;

public class User {
private String name;
private String password;
private String sex;
private Date birthday;
private String address;


public User(String name, String password, String sex, Date birthday,
		String address) {
	super();
	this.name = name;
	this.password = password;
	this.sex = sex;
	this.birthday = birthday;
	this.address = address;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}