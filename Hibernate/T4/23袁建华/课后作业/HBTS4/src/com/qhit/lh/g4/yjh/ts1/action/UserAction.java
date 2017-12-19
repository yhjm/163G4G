package com.qhit.lh.g4.yjh.ts1.action;
import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.qhit.lh.g4.yjh.ts1.bean.User;
import com.qhit.lh.g4.yjh.ts1.service.Baseservice;
import com.qhit.lh.g4.yjh.ts1.service.impl.BaseserviceImpl;


public class UserAction implements Action{
private User user;
private Date birthday;

public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

Baseservice baseservice =new BaseserviceImpl();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		user.setBirthday(birthday);
		baseservice.add(user);
	    return "success";
	}

}