package com.qhit.lh.g4.yjh.t2.bean;

public class Emp {
	private int eid;
	private String empName;
	private String empSex;
	private String brithday;
	private String 	deptId;
	//一对一关系对应的对象
	private UserInfo userInfo;
	private int birthday;
	public  Emp(int eid, String empName, String empSex, String brithday,
			String deptId, UserInfo userInfo) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.empSex = empSex;
		this.brithday = brithday;
		this.deptId = deptId;
		this.userInfo = userInfo;
	}
	public Emp(int eid, String empName, String empSex, String brithday,
			String deptId) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.empSex = empSex;
		this.brithday = brithday;
		this.deptId = deptId;
	}
	public  Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return  eid+"|"+empName+"|"+empSex+"|"+birthday+"|"+deptId+"|"+userInfo.getUserName()+"|"+userInfo;
	}
	
}
