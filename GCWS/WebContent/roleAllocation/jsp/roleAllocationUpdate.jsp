<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
    <%@page import="com.cqut.userManagement.entity.RoleAll"%>
    <%
    String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
   List<RoleAll> list1 =(List<RoleAll>)request.getAttribute("newRole"); 
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>roleAllocation/css/roleAllocationAdd.css"
	rel="stylesheet" type="text/css" />	
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/RoleAllocationUpdate" method="post">
		
		<div class="struct">
		 <p>修改角色</p>
		<div class="content">新角色：<input type="text" placeholder="<%=list1.get(0).getRoleName() %>" name="newRoleName" /></div>
		<div class="note">新备注：<input type="text" placeholder="<%=list1.get(0).getRemark() %>" name="newRemark" /></div>
		<input type= "hidden" name="roleId" value="<%=list1.get(0).getId() %>" />
		<div class="btn"><input type="submit" name="update" value="修改" class="newAdd"></div>
		<div class="btn"><a href ="<%=request.getContextPath()%>/RoleAllocationBackManage" class="newAdd">取__消</a></div>
		</div>
	</form>
</body>
</html>