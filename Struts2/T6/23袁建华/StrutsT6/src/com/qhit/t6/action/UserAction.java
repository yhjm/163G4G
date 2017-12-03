package com.qhit.t6.action;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.t6.bean.User;

public class UserAction extends ActionSupport{

private User user;
	
	
	@Override
	public void validate() {
		if ("".equals(user.getUname())) {
			addFieldError("user.uname", getText("uname.required"));
		}
		if ("".equals(user.getUpwd())) {
			addFieldError("user.upwd", getText("upwd.required"));
		}
	}
	
	public String login() {
		return SUCCESS;
	}
	
	public String execute() {
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
