package com.qhit.lh.g4.yjh.t6;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.g4.yjh.t6.bean.Roles;
import com.qhit.lh.g4.yjh.t6.bean.Userinfo;
import com.qhit.lh.g4.yjh.t6.dao.Basedao;
import com.qhit.lh.g4.yjh.t6.dao.impl.BasedaoImpl;

public class RolesTest {
	private Basedao basedao =new BasedaoImpl();
	@Test
	public void add(){
	Roles roles =new Roles();
	roles.setRname("纪律委员");
	roles.setRmemo("管理班级纪律");
	Userinfo userinfo =(Userinfo) basedao.getObjectById(Userinfo.class, 1);
	roles.getUserinfos().add(userinfo);
	basedao.add(roles);
	}
	@Test
	public void update(){
		Roles roles=(Roles) basedao.getObjectById(Roles.class, 4);
		Userinfo userinfo =(Userinfo) basedao.getObjectById(Userinfo.class, 2);
		roles.getUserinfos().add(userinfo);
		basedao.update(roles);
	}
	@Test
	public void delete(){
		Roles roles=(Roles) basedao.getObjectById(Roles.class, 3);
		basedao.delete(roles);
	}
	@Test
	public void queryAll(){
		List<Object> lists  =basedao.queryAll("from Roles");
		for (Object object : lists) {
			Roles roles =(Roles) object;
			System.out.println(roles.getRname()+":");
			for (Object object2 : roles.getUserinfos()) {
				Userinfo userinfo =(Userinfo) object2;
				System.out.print(userinfo.getUname()+userinfo.getUpwd());
			}
		}
	}
}
