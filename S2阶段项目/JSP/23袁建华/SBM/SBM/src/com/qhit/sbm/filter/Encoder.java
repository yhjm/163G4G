package com.qhit.sbm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encoder implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
			System.out.println("过滤器销毁"+ new java.util.Date().toLocaleString());
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		arg2.doFilter(request, response);
		System.out.println("过滤过滤"+ new java.util.Date().toLocaleString());
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤创建"+ new java.util.Date().toLocaleString());
	}

}
