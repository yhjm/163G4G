package com.qhit.lh.g4.yjh.t6.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String upwd;
	private Set<Roles> roless=new HashSet<Roles>();
	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	public Set<Roles> getRoless() {
		return roless;
	}

	public void setRoless(Set<Roles> roless) {
		this.roless = roless;
	}

	/** full constructor */
	public Userinfo(String uname, String upwd) {
		this.uname = uname;
		this.upwd = upwd;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}