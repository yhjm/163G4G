package com.qhit.lh.g4.yjh.ts1.action;

import com.opensymphony.xwork2.Action;
import com.qhit.lh.g4.yjh.ts1.bean.User;

public class LoginAction implements Action {
private User user;

	public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(user.getName().equals("jack")&&user.getPassword().equals("123456")){
			//登陆成功
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}

}
