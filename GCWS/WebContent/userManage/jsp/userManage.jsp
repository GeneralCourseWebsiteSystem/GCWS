<%@page import="com.cqut.userManagement.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    	ArrayList<User> users = (ArrayList<User>)request.getAttribute("users"); 
    	String name = (String)request.getAttribute("name");
		if(name==null){
			name = "";
		}
		String html = (String)request.getAttribute("html");
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员管理</title>
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() %>/userManage/css/userManage.css">
<link href="<%=request.getContextPath() %>/common/css/page.css"
	rel="stylesheet" type="text/css" />
<script>
	function delet(id){
		var operate = "delete";
		if(confirm("确定删除？")){
			window.location.href="UserOperate?operate="+operate+"&id="+id;
		}		
	}
</script>
</head>
<body>
	<div class="userHeader">
		<div class="curLocation userManage">
			<p>
				<a href="UserManage">人员管理</a>
			</p>
		</div>
	</div>
	<form class="searchForm" action="" method="post">
		<p>
			用户条件:<input class="searchInput" placeholder="请输入查找条件" type="text"
				name="name" value="<%= name %>"/> <input class="searchButton" type="submit" value="查询" />
		</p>
	</form>
	<div class="addbtn">
		<p><a href="UserOperate?operate=add">新增</a></p>
	</div>
	<table class="userTable">
		<tr class="thTr">
			<th>ID</th>
			<th>帐号</th>
			<th>电话</th>
			<th>创建时间</th>
			<th>是否锁定</th>
			<th>操作</th>
		</tr>
		<% for(int i = 0; i<users.size(); i++){ %>
		<tr>
			<td><%=users.get(i).getId() %></td>
			<td><%=users.get(i).getAccount() %></td>
			<td><%=users.get(i).getPhoneNumber() %></td>
			<td><%=users.get(i).getCreateTime() %></td>
			<td><%=users.get(i).getIsLock() %></td>
			<td>
			<a class="hrefA" href="UserOperate?id=<%= users.get(i).getId() %>&operate=show">查看</a>
			<a class="hrefA" href="UserOperate?id=<%= users.get(i).getId() %>&operate=edit">编辑</a>
			<% if(users.get(i).getIsLock() == 0){ %> 
			<a class="hrefA" href="UserOperate?id=<%= users.get(i).getId() %>&operate=lock">锁定</a>
			<% } %> <% if(users.get(i).getIsLock() == 1){ %> 
			<a class="hrefA" href="UserOperate?id=<%= users.get(i).getId() %>&operate=unlock">解锁</a>
			<% } %> 
			<a class="hrefA" href="javascript:void(0)" onclick="delet(<%= users.get(i).getId() %>)">删除</a></td>
		</tr>
		<%} %>
	</table>
	<div style="width: 97%; margin-left: 1.5%;">
		<c:if test="${not empty html}">
			<div class="page">${html}</div>
		</c:if>
	</div>
</body>
</html>