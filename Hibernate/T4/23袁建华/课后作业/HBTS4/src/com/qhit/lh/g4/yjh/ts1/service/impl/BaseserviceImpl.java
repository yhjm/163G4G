package com.qhit.lh.g4.yjh.ts1.service.impl;

import java.io.Serializable;
import java.util.List;

import com.qhit.lh.g4.yjh.ts1.dao.Basedao;
import com.qhit.lh.g4.yjh.ts1.dao.impl.BasedaoImpl;
import com.qhit.lh.g4.yjh.ts1.service.Baseservice;

public class BaseserviceImpl  implements Baseservice{
	private Basedao basedao =new BasedaoImpl();
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		basedao.add(object);
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		basedao.delete(object);
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		basedao.update(object);
	}

	@Override
	public Object getObjectById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return basedao.getObjectById(clazz, id);
	}

	@Override
	public List<Object> queryAll(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
