<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"
	import="java.text.SimpleDateFormat"%>



<%@page import="com.cqut.userManagement.entity.RoleUserLink"%>
<%@page import="com.cqut.userManagement.entity.RoleAll"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<RoleUserLink> roleUserList = (List<RoleUserLink>) request.getAttribute("role1");
	List<RoleAll> roleList = (List<RoleAll>) request.getAttribute("roleAlls");
	String str = (String) request.getAttribute("str");
	if (str == null) {
		str = "";
	}
	String html = (String) request.getAttribute("html");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>common/css/page.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>roleAllocation/css/roleAllocationBack.css"
	rel="stylesheet" type="text/css" />
<title>角色管理</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleManage">
			<p>
				<a href="RoleAllocationBack">角色管理</a>
			</p>
		</div>
	</div>
	<form class="searchForm" action="RoleAllocationBack" method="get">
		<p>
			角色搜索:<input class="searchInput" placeholder="请输入角色名" type="text"
				name="str" value="<%=str%>" /> <input class="searchButton"
				type="submit" value="查询" />
		</p>
	</form>
	<form action="<%=request.getContextPath()%>/RoleAllocationBack"
		method="post">
		<table class="qaaTable">
			<tr class="thTr">
				<th>用户名</th>
				<th>账号</th>
				<th>角色名称</th>
			</tr>
			<%
				for (int i = 0; i < roleUserList.size(); i++) {
			%>
			<tr height="50" class="two">
				<td class="exchange">
					<%=roleUserList.get(i).getUserName()%>
				</td>
				<td>
					<%=roleUserList.get(i).getAccount()%>
				</td>
				<td>
					<select name="all">
						<option selected="selected" value="<%=roleUserList.get(i).getId()%>">
							<%=roleUserList.get(i).getRoleName()%>
						</option>
						<%
							for (int m = 0; m < roleList.size(); m++) {
								if (roleUserList.get(i).getId() == roleList.get(m).getId()) {
									continue;
								}
						%>

						<option value="<%=roleList.get(m).getId()%>"><%=roleList.get(m).getRoleName()%></option>

						<%
							}
						%>

				</select></td>



				<td></td>

			</tr>

			<%
				}
			%>

		</table>
		<div style="width: 97%; margin-left: 1.5%;">
			<c:if test="${not empty html}">
				<div class="page">${html}</div>
			</c:if>
		</div>
		
		<input class="update"  type="submit" name="update" value="修 改" />
		
	</form>




</body>
</html>