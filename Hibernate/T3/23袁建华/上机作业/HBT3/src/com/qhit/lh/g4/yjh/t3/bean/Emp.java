package com.qhit.lh.g4.yjh.t3.bean;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String ename;
	private String esex;
	private String ebirthday;
	private Integer dept;
	private Userinfo userinfo;
	private Dept dept1;
	
	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** full constructor */
	public Emp(String ename, String esex, String ebirthday, Integer dept) {
		this.ename = ename;
		this.esex = esex;
		this.ebirthday = ebirthday;
		this.dept = dept;
	}

	// Property accessors

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Dept getDept1() {
		return dept1;
	}

	public void setDept1(Dept dept1) {
		this.dept1 = dept1;
	}

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

	public Integer getDept() {
		return this.dept;
	}

	public void setDept(Integer dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", esex=" + esex
				+ ", ebirthday=" + ebirthday + ", dept=" + dept + ", uid="
				+ userinfo.getUid() + ", daddress=" + dept1.getDaddress() + "]";
	}

}