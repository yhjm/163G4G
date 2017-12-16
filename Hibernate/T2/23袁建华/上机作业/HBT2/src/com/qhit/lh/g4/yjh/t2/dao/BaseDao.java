package com.qhit.lh.g4.yjh.t2.dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
public interface BaseDao {
	public void add(Object obj);

	public void update(Object obj);

	public void delete(Object obj);

	public List<Object> queryAll(String fromStr);
}
