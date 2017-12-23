package com.qhit.lh.g4.yjh.t8.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Integer did;
	private String dname;
	private String daddress;
	private Set<Emp> emps =new HashSet<Emp>();
	// Constructors

	/** default constructor */
	public Dept() {
	}



	public Set<Emp> getEmps() {
		return emps;
	}



	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
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