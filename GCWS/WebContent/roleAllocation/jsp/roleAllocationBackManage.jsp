<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>


<%@page import="com.cqut.userManagement.entity.RoleAll"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<RoleAll> list = (List<RoleAll>) request.getAttribute("roleAlls");
	String str = (String) request.getAttribute("str");
	if (str == null) {
		str = "";
	}
	String html = (String) request.getAttribute("html");
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; utf-8">

<link href="<%=basePath%>common/css/page.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>roleAllocation/css/roleAllocation.css"
	rel="stylesheet" type="text/css" />	
<title>角色管理</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleManage">
			<p>
				<a href="RoleAllocationBackManage">角色管理</a>
			</p>
		</div>
	</div>
	<form class="searchForm" action="RoleAllocationBackManage" method="get">
		<p>
			角色搜索:<input class="searchInput" placeholder="请输入角色名" type="text"
				name="str" value="<%=str%>" /> <input class="searchButton"
				type="submit" value="查询" />
		</p>
		<div class="newAdd">
			<a href="<%=request.getContextPath()%>/roleAllocation/jsp/roleAllocationAdd.jsp" >新增</a>
		</div>
	</form>
	<div class="table">
	
		<table class="qaaTable">
			<tr class="thTr">
				<th>角色名称</th>
				<th>修改时间</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr height="50" class="two">


				<td><%=list.get(i).getRoleName()%></td>
				<td><%=list.get(i).getCreateTime()%></td>
				<td><%=list.get(i).getRemark()%></td>


				<td>
				<a class="hrefA" href="<%=request.getContextPath()%>/RoleAllocationUpdate?name=<%=list.get(i).getId()%>">修改</a>
				<a class="hrefA" href="<%=request.getContextPath()%>/RoleAllocationDelete?name=<%=list.get(i).getId()%>">删除</a>
				</td>

			</tr>
			<%
				}
			%>


		</table>
		
	</div>
	<div style="width: 97%; margin-left: 1.5%;">
			<c:if test="${not empty html}">
				<div class="page">${html}</div>
			</c:if>
		</div>
</body>
</html>