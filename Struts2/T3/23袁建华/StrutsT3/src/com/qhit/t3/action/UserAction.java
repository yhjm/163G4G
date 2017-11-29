package com.qhit.t3.action;

import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.qhit.t3.bean.User;

public class UserAction implements Action {
	private User user;
	private Date date;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		date = new Date();
		return Action.SUCCESS;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
