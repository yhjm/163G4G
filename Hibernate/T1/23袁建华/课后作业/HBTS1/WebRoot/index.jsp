<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    ***************************************************
    <s:form action="user" method="post">
  		<s:textfield name="userName" label="请输入你的大名"></s:textfield>
  		<s:submit value="确认"></s:submit>
  	</s:form>
  	
  ***************************************************
  	<s:form action="login" method="post">
  		<s:textfield name="user.name" label="用户名"></s:textfield>
  		<s:password name="user.password" label="密码"> </s:password>
  		<s:submit value="确认"></s:submit>
  	</s:form>	
  </body>
</html>
