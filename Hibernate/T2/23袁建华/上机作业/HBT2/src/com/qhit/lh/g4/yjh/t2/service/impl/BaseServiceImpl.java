/**
 * 
 */
package com.qhit.lh.g4.yjh.t2.service.impl;

import java.util.List;

import com.qhit.lh.g4.yjh.t2.bean.Emp;
import com.qhit.lh.g4.yjh.t2.dao.BaseDao;
import com.qhit.lh.g4.yjh.t2.dao.impl.BaseDaoImpl;
import com.qhit.lh.g4.yjh.t2.service.BaseService;

/**
 * @author 袁建华
 *TODO
 *2017年12月12日下午7:48:08
 */
public class BaseServiceImpl implements BaseService{
	private  BaseDao basedao =new BaseDaoImpl();
	private String fromStr;

	private void add(Object obj) {
		// TODO Auto-generated method stub
		basedao.add(obj);
	}

	private void delete(Object obj) {
		// TODO Auto-generated method stub
		basedao.delete(obj);
	}
	private void update(Object obj) {
		// TODO Auto-generated method stub
		basedao.update(obj);
	}
	private List<Object> queryAll(String fString) {
		// TODO Auto-generated method stub
		return basedao.queryAll(fromStr);
	}

	@Override
	public void add(Emp emp) {
		// TODO Auto-generated method stub
		
	}
}
