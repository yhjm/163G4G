package com.qhit.sbm.Listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.qhit.sbm.user.bean.User;

public class HttpSessionListeners implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session监听器创建"+new java.util.Date().toLocaleString());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session监听器销毁"+new java.util.Date().toLocaleString());
	
		HttpSession session =  arg0.getSession();
		User user = (User) session.getAttribute("user");
		ServletContext application = session.getServletContext();
		List<User> online = (List<User>) application.getAttribute("online");
		online.remove(user);
		application.setAttribute("online", online);
	}

}
