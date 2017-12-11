package com.qhit.lh.g4.yjh.t1.basedao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.g4.yjh.t1.basedao.BaseDao;
import com.qhit.lh.g4.yjh.t1.bean.User;
import com.qhit.lh.g4.yjh.t1.utils.HibernateSessionFactory;

public class BaseDaoImpl implements BaseDao {
private  Session session =HibernateSessionFactory.getSession();
private  Transaction ts=session.beginTransaction();
	//添加user
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		session.save(user);
		ts.commit();
		HibernateSessionFactory.closeSession();
	}
	//删除user
	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		session.delete(user);
		ts.commit();
		HibernateSessionFactory.closeSession();
	}
	//更新user
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		session.update(user);
		ts.commit();
		HibernateSessionFactory.closeSession();
	}
	//查询
	@Override
	public List<Object> queryAll(String  tableName) {
		// TODO Auto-generated method stub
		List<Object> list =new ArrayList<Object>();
		list=session.createQuery(tableName).list();
		ts.commit();
		HibernateSessionFactory.closeSession();
		return list;
	}



}
