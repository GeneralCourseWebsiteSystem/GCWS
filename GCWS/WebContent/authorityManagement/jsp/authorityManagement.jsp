<%@page import="com.cqut.userManagement.entity.RoleAll"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    ArrayList<RoleAll> roles = (ArrayList<RoleAll>)request.getAttribute("roles");
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
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/authorityManagement/css/authorityManagement.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/common/css/page.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="authority">
		<div class="curLocation authorityManage">
			<p>
				<a href="AuthorityManagement">权限管理</a>
			</p>
		</div>
	</div>
	<form class="searchForm" action="" method="post">
		<p>
			用户条件:<input class="searchInput" placeholder="请输入查找条件" type="text"
				name="name" value="<%= name %>"/> <input class="searchButton" type="submit" value="查询" />
		</p>
	</form>
	<table class="authorityTable">
		<tr class="thTr">
			<th>ID</th>
			<th>角色名</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
		<% for(int i = 0; i < roles.size(); i++){ %>
		<tr>
			<td><%=roles.get(i).getId() %></td>
			<td><%=roles.get(i).getRoleName() %></td>
			<td><%=roles.get(i).getCreateTime() %></td>
			<td><a href="AllocationPermissions?roleId=<%= roles.get(i).getId() %>">分配权限</a></td>
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