package com.qhit.struts2_T04.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.struts2_T04.bean.User;
import com.qhit.struts2_T04.service.Impl.UserServiceImpl;

public class UserAction extends ActionSupport {

	private User user;
	private UserServiceImpl usi = new UserServiceImpl();
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String add() throws Exception{
		int row = usi.addUser(user);
		if(row > 0){
			return "success";
		}else{
			return "error";
		}
	}	
	public String delete() throws Exception{

		return "success";
	}
	public String update() throws Exception{

		return "success";
	}
	public String query() throws Exception{

		return "success";
	}

}
