<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:set var="name" value="'tom'"></s:set>
	<s:property value="name" />
	<br />
	<br />
	<s:if test="#name == 'tom'">
			您好：<s:property value="name" />
	</s:if>
	<s:elseif test="#name == 'jack'">
			您好<s:property value="#name" />
	</s:elseif>
	<s:else>
 		Who are you ?
	</s:else>
	<s:form action="user/add" method = "post">
		<s:textfield label="用户名"  name="user.uname" required="true"></s:textfield>
		<s:password label="密码"  name = "user.upwd" required="true"></s:password>
		<s:select label="学历"  list="{ '高中','大专','本科','研究生','博士'}"  size = "2" value = "'高中'" name = "user.eduction"></s:select>
		<s:radio list="#{'1':'男','2':'女','3':'保密' }"  value="1"  name = "user.sex"></s:radio>
		<s:submit value="提交"></s:submit>
	</s:form>
	
	
</body>
</html>