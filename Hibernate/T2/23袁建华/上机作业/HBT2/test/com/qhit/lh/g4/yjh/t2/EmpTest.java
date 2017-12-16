/**
 * 
 */
package com.qhit.lh.g4.yjh.t2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.g4.yjh.t2.bean.Emp;
import com.qhit.lh.g4.yjh.t2.bean.UserInfo;
import com.qhit.lh.g4.yjh.t2.dao.BaseDao;
import com.qhit.lh.g4.yjh.t2.dao.impl.BaseDaoImpl;

/**
 * @author 袁建华
 *TODO
 *2017年12月12日下午8:17:52
 */
public class EmpTest {
	private BaseDao baseDao=new BaseDaoImpl();
	private BaseDao baseService;
	private UserInfo userInfo;
	@Test
	public void add() {
		//录入基本信息
		Emp emp = new Emp();
		emp.setEmpName("小明");
		emp.setEmpSex("M");
		emp.setBrithday("2017-12-12");
		emp.setDeptId("1");
		//分配账户信息
		UserInfo userInfo = new UserInfo ();
		userInfo.setUserName("xm");
		userInfo.setPassword("123456");
		//员工表和账户是一对一的关系
		emp.setUserInfo(userInfo);
		userInfo.setEmp(emp);
		baseService.add(emp);
	}

	@Test
	public void delete() {
		Emp emp = new Emp();
		emp.setEid(2);
		//员工表一对一的关系
		emp.setUserInfo(userInfo);
		userInfo.setEmp(emp);
		baseService.delete(emp);
	}

	@Test
	public void update() {
		Emp emp = new Emp();
		emp.setEmpName("小华");
		emp.setEmpSex("M");
		emp.setBrithday("2017-12-12");
		emp.setDeptId("4");
		//分配账户信息
		UserInfo userInfo = new UserInfo ();
		userInfo.setUserName("xh");
		userInfo.setPassword("123456");
		//员工表和账户是一对一的关系
		emp.setUserInfo(userInfo);
		userInfo.setEmp(emp);
		baseService.update(emp);
	}

	@Test
	public void query() {
		List<Object>list= baseService.queryAll("from Emp");
		for ( Object object :list) {
			Emp emp =(Emp)object;
			System.out.println(emp.toString());
		}
	}

}
