package com.qhit.struts2_T04.service.Impl;

import com.qhit.struts2_T04.bean.User;
import com.qhit.struts2_T04.dao.Impl.UserDaoImpl;
import com.qhit.struts2_T04.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}

}
