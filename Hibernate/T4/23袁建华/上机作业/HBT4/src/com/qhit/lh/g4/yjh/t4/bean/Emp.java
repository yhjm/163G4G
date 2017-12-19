package com.qhit.lh.g4.yjh.t4.bean;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String ename;
	private String esex;
	private String ebirthday;
	private Integer did;
	private Userinfo userinfo;
	private Dept dept;
	// Constructors

	/** default constructor */
	public Emp() {
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	/** minimal constructor */
	public Emp(String ename, String esex, String ebirthday) {
		this.ename = ename;
		this.esex = esex;
		this.ebirthday = ebirthday;
	}

	/** full constructor */
	public Emp(String ename, String esex, String ebirthday, Integer did) {
		this.ename = ename;
		this.esex = esex;
		this.ebirthday = ebirthday;
		this.did = did;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsex() {
		return this.esex;
	}

	public void setEsex(String esex) {
		this.esex = esex;
	}

	public String getEbirthday() {
		return this.ebirthday;
	}

	public void setEbirthday(String ebirthday) {
		this.ebirthday = ebirthday;
	}

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

}