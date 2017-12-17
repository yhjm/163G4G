package com.qhit.lh.g4.yjh.ts1.action;
import com.opensymphony.xwork2.Action;


public class UserAction  implements Action{
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}

}
