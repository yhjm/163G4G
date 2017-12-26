package com.qhit.lh.g4.yjh.t7.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.g4.yjh.t7.bean.Dept;
import com.qhit.lh.g4.yjh.t7.bean.Emp;
import com.qhit.lh.g4.yjh.t7.bean.UserInfo;
import com.qhit.lh.g4.yjh.t7.dao.BaseDao;
import com.qhit.lh.g4.yjh.t7.utils.HibernateSessionFactory;

public class BaseDAoImpl implements BaseDao {


	private Session session =HibernateSessionFactory.getSession();
	private Transaction tx=session.beginTransaction();
	private List<Object> list=new ArrayList<Object>();
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		session.save(object);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		session.delete(object);
		tx.commit();
		HibernateSessionFactory.closeSession();

	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		session.update(object);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}

	@Override
	public Object getObjectById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		Object object=session.get(clazz, id);
		return object;
	}

	@Override
	public List<Object> queryAll(String hql) {
		// TODO Auto-generated method stub
		list=session.createQuery(hql).list();
		tx.commit();
		HibernateSessionFactory.closeSession();
		return list;
	}

	@Override
	public List<Emp> getEmpByEname(String name) {
		// TODO Auto-generated method stub
		String hql ="select e from Emp e where ename like :ename";
		Query query =session.createQuery(hql);
		query.setString("ename", name);
		List<Emp> emps=query.list();
		return emps;
	}

	@Override
	public List<Dept> getInnerQuery(String deptname) {
		// TODO Auto-generated method stub
		String hql ="select distinct dept from Dept dept join dept.emps where dept.dname like ? ";
		Query query =session.createQuery(hql);
		query.setString(0, deptname);
		List<Dept> depts=query.list();
		return depts;
	}

	@Override
	public List<Object[]> getCountQuery() {
		// TODO Auto-generated method stub
		String hql="select d.dname ,count(e) from Dept d left join d.emps e group by d.dname";
		Query query =session.createQuery(hql);
		List<Object[]> result =query.list();
		return result;
	}

	@Override
	public List<Object> getObjectQuery() {
		// TODO Auto-generated method stub
		String hql="select  obj from  java.lang.Object  obj";
		Query query =session.createQuery(hql);
		List<Object> result =query.list();
		return result;
	}

	@Override
	public List<UserInfo> doLogin(UserInfo userinfo) {
		// TODO Auto-generated method stub
		String hql="select userinfo from Userinfo userinfo where uname like ? and upwd like?";
		Query query =session.createQuery(hql);
		query.setString(0, userinfo.getUname());
		query.setString(1, userinfo.getUpwd());
		List<UserInfo> userinfos=query.list();
		return userinfos;
	}

}
