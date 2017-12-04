package com.qhit.sbm.Listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.qhit.sbm.user.bean.User;

public class ServletContextListeners implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("application监听器销毁"+new java.util.Date().toLocaleString());
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("application监听器创建"+new java.util.Date().toLocaleString());
		List<User> online = new ArrayList<User>();
		ServletContext application = arg0.getServletContext();
		application.setAttribute("online", online);
	}

}
