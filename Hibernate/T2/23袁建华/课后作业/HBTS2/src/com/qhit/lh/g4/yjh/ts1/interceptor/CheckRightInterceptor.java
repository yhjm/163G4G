package com.qhit.lh.g4.yjh.ts1.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckRightInterceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("自定义拦截器初始化");
		return arg0.invoke();
	}

}