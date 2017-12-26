package com.qhit.lh.g4.yjh.t7;


import java.util.List;

import org.junit.Test;

import com.qhit.lh.g4.yjh.t7.bean.Dept;
import com.qhit.lh.g4.yjh.t7.bean.Emp;
import com.qhit.lh.g4.yjh.t7.bean.UserInfo;
import com.qhit.lh.g4.yjh.t7.dao.BaseDao;
import com.qhit.lh.g4.yjh.t7.dao.impl.BaseDAoImpl;

public class EmpTest {

	private BaseDao basedao =new BaseDAoImpl();
	@Test
	public void add() {
		Emp emp =new Emp();
		emp.setEname("宋刚");
		emp.setEsex("M");
		emp.setEbirthday("2017-12-23");
		Dept dept =new Dept();
		dept=(Dept) basedao.getObjectById(Dept.class, 1);
		dept.getEmps().add(emp);
		emp.setDept(dept);
		UserInfo userinfo =new UserInfo();
		userinfo.setUname("dhl");
		userinfo.setUpwd("123456");
		emp.setUserinfo(userinfo);
		userinfo.setEmp(emp);
		basedao.add(emp);
	}
	@Test
	public void update(){
		Dept dept =(Dept) basedao.getObjectById(Dept.class, 2);
		Emp emp =(Emp) basedao.getObjectById(Emp.class, 1);
		emp.setDept(dept);
		dept.getEmps().add(emp);
		basedao.update(dept);
	}
	@Test
	public void delete(){
		Dept dept =(Dept) basedao.getObjectById(Dept.class, 2);
		basedao.delete(dept);
		
	}
	@Test
	public void queryAll(){
		List<Object> lists  =basedao.queryAll("from Dept");
		for (Object object : lists) {
			Dept dept =(Dept) object;
			System.out.println(dept.getDname()+":");
			for (Object object2 : dept.getEmps()) {
				Emp emp =(Emp) object2;
				System.out.print(emp.getEname());
			}
		}
	}

	@Test
	public void getEmpByEname(){
		List<Emp> emps =basedao.getEmpByEname("马%");
		for (Emp emp : emps) {
			System.out.println(emp.getEid()+emp.getEname());
		}
	}
	@Test
	public void getInnerQuery(){
		List<Dept> depts =basedao.getInnerQuery("办公室");
		for (Dept dept : depts) {
			System.out.println(dept.getDname()+":");
			for (Emp emp : dept.getEmps()) {
				System.out.println(emp.getEid()+emp.getEname());
			}
			
		}
	}

	@Test
	public void getCountQuery(){
		List<Object[]> result =basedao.getCountQuery();
		for (Object[] objects : result) {
			System.out.println(objects[0]+"人数:"+objects[1]);
		}
	}
	@Test
	public void getObjectQuery(){
		List<Object> result=basedao.getObjectQuery();
		for (Object object : result) {
			System.out.println(object);
		}
		
	}
	@Test
	public void doLogin(){
		UserInfo userinfo =(UserInfo) basedao.getObjectById(UserInfo.class, 1);
		List<UserInfo> users=basedao.doLogin(userinfo);
		if(users!=null && users.size()>0){
			System.out.println("success");
		}else{
			System.out.println("failed");
		}
		
	}

}
