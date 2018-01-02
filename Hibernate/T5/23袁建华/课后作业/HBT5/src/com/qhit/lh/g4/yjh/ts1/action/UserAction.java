package com.qhit.lh.g4.yjh.ts1.action;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.g4.yjh.ts1.bean.User;
import com.qhit.lh.g4.yjh.ts1.service.Baseservice;
import com.qhit.lh.g4.yjh.ts1.service.impl.BaseserviceImpl;


public class UserAction extends ActionSupport{
private User user;
private Date birthday;
private List<User> userlist;



public List<User> getUserlist() {
	return userlist;
}

public void setUserlist(List<User> userlist) {
	this.userlist = userlist;
}

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

	

	public String add() throws Exception {

		// TODO Auto-generated method stub
		if(user.getIsable()==null){
			user.setIsable("false");
		}
		user.setBirthday(birthday);
		baseservice.add(user);

			return "addUser";

	}

	public String queryAll(){

		userlist=baseservice.queryAll("from User");
		userlist=(List<User>)userlist;
			return "queryAllUser";
	}

	public String update(){
		if(user.getIsable()==null){
			user.setIsable("false");
		}
		user.setBirthday(birthday);
		baseservice.update(user);
		return "updateUser";

	}

	public String delete(){
baseservice.delete(user);
			return "deleteUser";
	}

public String querySingle(){
		user=(User) baseservice.getObjectById(User.class,user.getUid());
			return "querySingleUser";

	}
}