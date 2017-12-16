package com.qhit.lh.g4.yjh.t3.bean;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Integer did;
	private String dname;
	private String daddress;

	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** full constructor */
	public Dept(String dname, String daddress) {
		this.dname = dname;
		this.daddress = daddress;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDaddress() {
		return this.daddress;
	}

	public void setDaddress(String daddress) {
		this.daddress = daddress;
	}

}