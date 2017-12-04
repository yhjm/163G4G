<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="core" %>
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
	window.location = "provider.do?id="+id+"&flag="+flag;
}
</script>
</head>
<body>
<c:if test="${param.select eq 'error' }">
  <script type="text/javascript">
		 alert("供应商查找失败");
  </script>
</c:if>


<div class="menu">

<table>
<tbody><tr><td><form method="post" action="provider.do">
<input name="flag" value="search" type="hidden">
供应商名称：<input name="providerName" class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input value="组 合 查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='providerAdd.jsp'" type="button"></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>

	<div class="content">
<table class="list">
  <tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
    <td width="80"><div class="STYLE1" align="center">供应商描述</div></td>
    <td width="80"><div class="STYLE1" align="center">联系人</div></td>
    <td width="80"><div class="STYLE1" align="center">电话</div></td>
    <td width="80"><div class="STYLE1" align="center">传真</div></td>
    <td width="80"><div class="STYLE1" align="center">地址</div></td>
    <td width="80"><div class="STYLE1" align="center">管理</div></td>
  </tr>
  <c:forEach items="${sessionScope.providerPage.data }" var ="provider">
  			<c:set var = "pro"  value = "provider" ></c:set>
   	<tr>
  		<td>${provider.providerId }</td>
  		<td><a  >${provider.providerName }</a></td>
  		<td>${provider.providerDetail }</td>
  		<td>${provider.contact }</td>
  		<td>${provider.telephone }</td>
  		<td>${provider.facsimile }</td>
  		<td>${provider.address }</td>
  		<td><a >修改</a></td>
  	</tr>
  
  </c:forEach>
 
</table>

	</div>
</div>
	<form id="frm" method="post"  action="commonServlet?cmd=changeProviderPage">
	<label class="input-button" >跳转到</label>
		<select name = "pageNum"  id="pageNum" onchange="changeP()">
			<c:forEach begin="1" var = "i"  end="${providerPage.pageTotal }">
					<c:if test="${providerPage.pageNum == i }">
							<option value="${i }"  selected="selected" >第${i }页</option>
					</c:if>
					<c:if test="${providerPage.pageNum != i }">
							<option value="${i }" >第${i }页</option>
					</c:if>
			
			</c:forEach>
		</select>
	<a style="text-decoration: none;" class="input-button"  href = "commonServlet?cmd=changeProviderPage&pageNum=${providerPage.pageNum+1}">下一页</a>
	<a style="text-decoration: none;" class="input-button" href = "commonServlet?cmd=changeProviderPage&pageNum=${providerPage.pageNum-1}">上一页</a>
	</form>

<script type="text/javascript">
	function changeP(){
		var frm = document.getElementById("frm");
		frm.submit();
	}

</script>


</body>
</html>
