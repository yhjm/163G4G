package com.qhit.sbm.common.service.Impl;

import com.qhit.sbm.common.Dao.Impl.CommonDaoImpl;
import com.qhit.sbm.common.service.CommonService;

public class CommonServiceImpl implements CommonService {

	@Override
	public int getCount(String table, String[] arg0, String[] arg1) {
		// TODO Auto-generated method stub
		return new CommonDaoImpl().getCount(table, arg0, arg1);
	}

}
