<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Insert title here</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
}
</script>
</head>
<body>
<c:if test="${select == 'error' }">
<script type="text/javascript">
window.alert("查找失败");
</script>

</c:if>

<div class="menu">

<table>
<tbody><tr><td><form method="post" action="user.do">
<input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='userAdd.jsp'" type="button"></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>
    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
    <td width="150"><div class="STYLE1" align="center">管理 </div></td>
  </tr>
    <c:forEach items="${sessionScope.userPage.data }" var ="user">
  			<c:set var = "u"  value = "user" ></c:set>
   	<tr>
  		<td width="70" height="29"><div class="STYLE1" align="center">${user.userId }</div></td>
  		<td width="80"><div class="STYLE1" align="center">${user.userName}</div></td>
  		<td width="100"><div class="STYLE1" align="center">${user.userSex }</div></td>
  		<td width="100"><div class="STYLE1" align="center">${user.userAge  }</div></td>
  		<td  width="150"><div class="STYLE1" align="center">${user.telephone }</div></td>
  		<td width="150"><div class="STYLE1" align="center">${user.address }</div></td>
  		<td  width="150"><div class="STYLE1" align="center">${user.type }</div></td>
 
  		<td><a >修改</a></td>
  	</tr>
  
  </c:forEach>
  <!-- <tr>
    <td height="23"><span class="STYLE1">1</span></td>
    <td><span class="STYLE1"><a href="#" onclick="doit('mod',1)">admin</a></span></td>

    <td><span class="STYLE1">
    	女
    </span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1">0</span></td>
    <td><span class="STYLE1"></span></td>
    <td><span class="STYLE1">&nbsp;
    </span></td> 
  </tr>-->
  
  
</table>
</div>
</div>
	<form id="frm" method="post"  action="commonServlet?cmd=changeUserPage">
	<label class="input-button" >跳转到</label>
		<select name = "pageNum"  id="pageNum" onchange="changeP()">
			<c:forEach begin="1" var = "i"  end="${userPage.pageTotal }">
					<c:if test="${userPage.pageNum == i }">
							<option value="${i }"  selected="selected" >第${i }页</option>
					</c:if>
					<c:if test="${userPage.pageNum != i }">
							<option value="${i }" >第${i }页</option>
					</c:if>
			
			</c:forEach>
		</select>
	<a style="text-decoration: none;" class="input-button"  href = "commonServlet?cmd=changeUserPage&pageNum=${userPage.pageNum+1}">下一页</a>
	<a style="text-decoration: none;" class="input-button" href = "commonServlet?cmd=changeUserPage&pageNum=${userPage.pageNum-1}">上一页</a>
	</form>

<script type="text/javascript">
	function changeP(){
		var frm = document.getElementById("frm");
		frm.submit();
	}

</script>

</body>
</html>
