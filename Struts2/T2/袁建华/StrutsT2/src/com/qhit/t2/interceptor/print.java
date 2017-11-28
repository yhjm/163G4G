package com.qhit.t2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class print implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("自定义销毁");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("自定义初始化");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String result = arg0.invoke();
		System.out.println("返回代码"+result);
		System.out.println("自定义执行");
		return result;
	}

}
