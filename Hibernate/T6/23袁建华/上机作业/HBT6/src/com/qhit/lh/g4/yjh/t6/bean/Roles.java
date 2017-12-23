package com.qhit.lh.g4.yjh.t6.bean;

import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	// Fields

	private Integer rid;
	private String rname;
	private String rmemo;
	private Set<Userinfo> userinfos =new HashSet<Userinfo>();
	// Constructors

	/** default constructor */
	public Roles() {
	}

	

	public Set<Userinfo> getUserinfos() {
		return userinfos;
	}



	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}



	/** full constructor */
	public Roles(String rname, String rmemo) {
		this.rname = rname;
		this.rmemo = rmemo;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRmemo() {
		return this.rmemo;
	}

	public void setRmemo(String rmemo) {
		this.rmemo = rmemo;
	}

}