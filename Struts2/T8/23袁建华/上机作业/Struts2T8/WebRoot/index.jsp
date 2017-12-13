<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>系统登录 - 超市账单管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="jsp/css/style.css" />
</head>
<body class="blue-style">
<c:if test="${param.loginMsg == 'failed'}">
<script type="text/javascript">
alert("账户名或密码不正确");
</script>
</c:if>
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
	<s:fielderror name="loginFail"></s:fielderror>
	<s:form method="post" action="loginUser">
		<s:textfield label="用户名"   name="user.userName" cssClass="input-text"></s:textfield>
		<s:password  label="密码" 	 name="user.userPassword" cssClass="input-text"></s:password>
		<s:div>
			<s:submit value="登陆" cssClass="input-button"></s:submit>
			<s:reset  value="重置" cssClass="input-button"></s:reset>
		</s:div>
	</s:form>
	</div>
</div>
</body>
</html>
