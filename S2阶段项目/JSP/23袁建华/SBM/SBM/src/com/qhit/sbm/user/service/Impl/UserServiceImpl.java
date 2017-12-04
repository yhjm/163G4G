package com.qhit.sbm.user.service.Impl;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.user.Dao.Impl.UserDaoImpl;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User doLogin(String name, String passWord) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().doLogin(name, passWord);
	}

	@Override
	public int updatePassword(String newPwd , int userId) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().updatePassword(newPwd, userId);
	}

	@Override
	public List selectUser(PageBean userPage) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().selectUser(userPage);
	}

	@Override
	public int addUser(User addUser) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(addUser);
	}

}
