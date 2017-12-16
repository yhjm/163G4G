package com.qhit.lh.g4.yjh.t3;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.g4.yjh.t3.bean.Dept;
import com.qhit.lh.g4.yjh.t3.bean.Emp;
import com.qhit.lh.g4.yjh.t3.bean.Userinfo;
import com.qhit.lh.g4.yjh.t3.dao.Basedao;
import com.qhit.lh.g4.yjh.t3.dao.impl.BasedaoImpl;

public class EmpTest {
	private Basedao basedao =new BasedaoImpl();
@Test
public void add(){
	Emp  emp =new Emp();
	emp.setEname("小明");
	emp.setEsex("M");
	emp.setEbirthday("1997-09-27");
	emp.setDept(1);
	Userinfo userinfo =new Userinfo();
	userinfo.setUname("xm");
	userinfo.setUpwd("123456");
	Dept dept=(Dept) basedao.getObjectById(Dept.class, 1);
	userinfo.setEmp(emp);
	emp.setUserinfo(userinfo);
	emp.setDept1(dept);
	basedao.add(emp);
}
@Test
public void delete(){
	Emp  emp =new Emp();
	emp=(Emp) basedao.getObjectById(Emp.class, 1);
	basedao.delete(emp);
}
@Test
public void update(){
	Emp emp=(Emp) basedao.getObjectById(Emp.class, 1);
	Dept dept=(Dept) basedao.getObjectById(Dept.class, 2);
	emp.setDept1(dept);
	basedao.update(emp);
}
@Test
public void queryAll(){
List<Object> lists=	basedao.queryAll("from Emp");
	for (Object object : lists) {
		Emp emp=(Emp) object;
		System.out.println(emp.toString());
	}
	
}
}
