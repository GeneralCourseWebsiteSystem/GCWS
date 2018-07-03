<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
    <%@page import="com.cqut.userManagement.entity.RoleAll"%>
    <%
   List<RoleAll> list1 =(List<RoleAll>)request.getAttribute("newRole"); 
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/RoleAllocationUpdate" method="post">
		
		<div>角色名：<input type="text" placeholder="<%=list1.get(0).getRoleName() %>" name="newRoleName" /></div>
		<div>备   注：<input type="text" placeholder="<%=list1.get(0).getRemark() %>" name="newRemark" /></div>
		<input type= "hidden" name="roleId" value="<%=list1.get(0).getId() %>" />
		
		<div><input type="submit" name="update" value="修改"></div>
		<div><a href ="<%=request.getContextPath()%>/RoleAllocationBackManage">取消</a></div>
	</form>
</body>
</html>