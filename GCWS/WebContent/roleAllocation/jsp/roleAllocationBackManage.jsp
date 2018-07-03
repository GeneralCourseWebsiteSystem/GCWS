<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>


<%@page import="com.cqut.userManagement.entity.RoleAll"%>
<%
	List<RoleAll> list = (List<RoleAll>) request.getAttribute("roleAlls");
	int pageIndex = 1;
	Integer totalPage = Integer.parseInt(request.getAttribute("totalPage") + "");
	Integer pageMegNum = Integer.parseInt(request.getAttribute("pageMegNum") + "");
	if (request.getAttribute("pageIndex") == null) {
		pageIndex = 1;
	} else {
		pageIndex = Integer.parseInt(request.getAttribute("pageIndex") + "");
	}
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; utf-8">
<link rel="stylesheet" type="text/css" href="./css/show.css" />
<title>角色管理</title>
</head>
<body>
	<div class="Title">
		<h1>角色管理</h1>
	</div>
	<div class="table">
		<table align='center' border='1' cellspacing='0' width="1100">
			<tr class="one">

				<td>角色名称</td>
				<td>修改时间</td>
				<td>备注</td>

			</tr>
			<%
				for (int i = (pageIndex - 1) * pageMegNum; i < pageIndex * pageMegNum && i < list.size(); i++) {
			%>
			<tr height="50" class="two">


				<td><%=list.get(i).getRoleName()%></td>
				<td><%=list.get(i).getCreateTime()%></td>
				<td><%=list.get(i).getRemark()%></td>


				<td><a
					href="<%=request.getContextPath()%>/RoleAllocationUpdate?name=<%=list.get(i).getId()%>">修改</a>
					<a
					href="<%=request.getContextPath()%>/RoleAllocationDelete?name=<%=list.get(i).getId()%>">删除</a>

				</td>

			</tr>
			<%
				}
			%>


		</table>
		<a href="<%=request.getContextPath()%>/roleAllocation/jsp/roleAllocationAdd.jsp">新增角色</a>
	</div>
	<div class="page">
		<a class="footpage"
			href="<%=request.getContextPath()%>/RoleAllocationBackManage?pageIndex=<%=pageIndex%>&pageTurn=up">&emsp;上一页</a>
		<span>&emsp;第<%=pageIndex%>页&emsp;
		</span> <a
			href="<%=request.getContextPath()%>/RoleAllocationBackManage?pageIndex=<%=pageIndex%>&pageTurn=down">下一页</a>
		<span>&emsp;共<%=totalPage%>页
		</span>
	</div>
</body>
</html>