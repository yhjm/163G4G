package com.qhit.lh.g4.yjh.t5;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.g4.yjh.t5.bean.Dept;
import com.qhit.lh.g4.yjh.t5.bean.Emp;
import com.qhit.lh.g4.yjh.t5.bean.Userinfo;
import com.qhit.lh.g4.yjh.t5.dao.Basedao;
import com.qhit.lh.g4.yjh.t5.dao.impl.BasedaoImpl;

public class DeptTest {
	private Basedao basedao =new BasedaoImpl();
@Test
public void add(){
Emp emp =new Emp();
emp.setEname("李明");
emp.setEsex("M");
emp.setEbirthday("1997-10-27");
Dept dept =new Dept();
dept=(Dept) basedao.getObjectById(Dept.class, 1);
dept.getEmps().add(emp);
emp.setDept(dept);
Userinfo userinfo =new Userinfo();
userinfo.setUname("lm");
userinfo.setUpwd("123456");
emp.setUserinfo(userinfo);
userinfo.setEmp(emp);
basedao.add(emp);

}
@Test
public void update(){
	Dept dept =(Dept) basedao.getObjectById(Dept.class, 1);
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
}
