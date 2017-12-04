<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_bill_list.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link type="text/css" rel="stylesheet" href="css/style.css" />
	</head>
<body>
<c:if test="${param.select eq 'error' }">
  <script type="text/javascript">
		 alert("页面更改失败");
  </script>
</c:if>
<div class="menu">
	<form method="post" action="commonServlet?cmd=selectPage">
		商品名称：<input type="text" name="goodsName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="isPayed">
			<option value=""  selected="selected">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.jsp'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list" border="2px">
			<tr>
				<td>账单编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>交易金额</td>
				<td>是否付款</td>
				<td>供应商名称</td>
				<td>商品描述</td>
				<td>修改</td>
			
			</tr>
			<c:forEach items="${selectPages.data }"  var = "pagebean">
				<tr>
				<td>${pagebean.accountId }</td>
				<td>${pagebean.goodsName }</td>
				<td>${pagebean.businessNum }</td>
				<td>${pagebean.totalPrice }</td>
				<td>
					<c:if test="${pagebean.isPayed ==0 }">
					未付款
					</c:if>
					<c:if test="${pagebean.isPayed ==1 }">
					已付款
					</c:if>
				</td>
				<td>${pagebean.providerName }</td>
				<td>${pagebean.goodsIntro }</td>
				<td>
					<a>修改</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
	<form id="frm" method="post"  action="commonServlet?cmd=selectChangePage">
	<label class="input-button" >跳转到</label>
		<select name = "pageNum"  id="pageNum" onchange="changeP()">
			<c:forEach begin="1" var = "i"  end="${selectPages.pageTotal }">
					<c:if test="${selectPages.pageNum == i }">
							<option value="${i }"  selected="selected" >第${i }页</option>
					</c:if>
					<c:if test="${selectPages.pageNum != i }">
							<option value="${i }" >第${i }页</option>
					</c:if>
			
			</c:forEach>
		</select>
	<a style="text-decoration: none;" class="input-button"  href = "commonServlet?cmd=selectChangePage&pageNum=${selectPages.pageNum+1}">下一页</a>
	<a style="text-decoration: none;" class="input-button" href = "commonServlet?cmd=cselectChangePage&pageNum=${selectPages.pageNum-1}">上一页</a>
	</form>
</div>

<script type="text/javascript">
	function changeP(){
		var frm = document.getElementById("frm");
		frm.submit();
	}

</script>
</body>
</html>
