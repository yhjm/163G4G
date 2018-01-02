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
    
    <title>My JSP 'userAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 <link type="text/css" rel="stylesheet" href="jsp/css/style.css">
<script type="text/javascript">
	function checkit() {
		//判断是否是数字的正则表达式
		if(
			checkEmpty("userName") &&
			checkEmpty("userPassword") &&
			checkEmpty("userPassword1") &&
			checkEmpty("userSex") &&
			checkEmpty("userAge") &&
			checkEmpty("telephone") &&
			checkEmpty("address") &&
			checkEmpty("pic") &&
			checkEmpty("type")
		){
			//非空验证通过
			if(checkPassword()){
				//密码验证通过
				if(checkAge()){
					//年龄验证通过
					return true;//提交表单数据
				}else{
					alert("年龄只能在0-120之间!");
					return false;
				}
			}else{
				//密码验证不通过
				alert("密码不一致!");
				return false;
			}
			
		}else{
			//非空验证不通过
			alert("请检查用户信息是否完整!");
			return false;
		}
	}
	
	function checkAge() {
		var userAge = document.getElementById("userAge").value;
		if(userAge > 0 && userAge < 120){
			//满足数据要求
			return true;
		}else{
			return false;
		}
	}
	
	function checkEmpty(id) {
		var suiyi = document.getElementById(id).value;
		if(suiyi != null && suiyi != ""){
			return true;
		}else{
			return false;
		}
	}
	
	function checkPassword() {
		var userPassword = document.getElementById("userPassword").value;
		var userPassword1 = document.getElementById("userPassword1").value;
		if(userPassword == userPassword1){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>

		</div>
		<s:form method="post" action="uploadUser" enctype="multipart/form-data" onsubmit="return checkit();">
			<div class="content">
				<table class="box">
					
					<tr>
						<td class="field">
							<s:textfield label="用户名"  name="user.userName"></s:textfield>
						<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">
							<s:password label="密码" name="user.userPassword"></s:password>
						 <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field"> 
							<s:password label="再输入一次" name="user.userPassword"></s:password>
						<font color="red">*</font></td>
					</tr>

					<tr>
						<td class="field">
						<s:radio label="请选择性别" list="#{0:'男',1:'女'}"  name="user.userSex" value="0"></s:radio>
						<font color="red">*</font>
						</td>
					</tr>

					<tr>
						<td class="field">
							<s:textfield label="请输入年龄" name="user.userAge"></s:textfield>
						 <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">
							
							<s:textfield label="用户电话" name="user.telephone"></s:textfield>
						<font color="red">*</font></td>

					</tr>
					<tr>
						<td class="field">
							<s:textarea label="用户地址" name="user.address"  ></s:textarea>
							<font color="red">*</font>		
						</td>
					</tr>
					<tr>
						<td class="field">
							<s:radio list="#{1:'经理',2:'管理员' }" label="用户权限" name="user.type"></s:radio>
						
						</td>
					</tr>
					<tr>
						<td class="field">
						
							<s:file lable="请选择用户头像" name="fileupload" ></s:file>
							<font color="red">*只允许png,jpg,jpeg,gif类型的文件最大文件大小为5M</font>
						</td>
					</tr>
				</table>
			</div>
			<s:submit value="提交"></s:submit>
			<div class="buttons">
				<input type="submit" name="button" id="button" value="数据提交"
					class="input-button" /> <input type="button" name="button"
					id="button" onclick="history.back();" value="返回"
					class="input-button" />
			</div>

		</s:form>
	</div>
</body>
</html>
