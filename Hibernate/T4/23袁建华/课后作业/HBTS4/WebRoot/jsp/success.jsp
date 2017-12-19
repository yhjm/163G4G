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
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
	<h2>用户信息表</h2>
  	姓名：<s:property value="user.name"/><br>
  	密码：<s:property value="user.password"/><br>
  	生日：<s:property value="user.birthday"/><br>
  	性别：<s:if test="user.sex==1">男</s:if><s:elseif test="user.sex==2">女</s:elseif><s:else>保密</s:else><br>
  	是否启用：<s:property value="user.isable"/><br>
  </body>
</html>
