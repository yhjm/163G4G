package com.qhit.lh.g4.yjh.ts1.dao;

import java.io.Serializable;
import java.util.List;

import com.qhit.lh.g4.yjh.ts1.bean.User;

public interface Basedao {
	public void add(Object object);
	public void delete(Object object);
	public void update(Object object);
	public Object getObjectById(Class clazz,Serializable id);
	public List<User> queryAll(String sql);
}
