package com.qhit.lh.g4.yjh.ts1.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckRightInterceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("我开始拦截");
		String result =arg0.invoke();
		System.out.println("返回代码"+result);
		return result;
	}

}