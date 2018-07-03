<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	<form action="<%=request.getContextPath()%>/RoleAllocationAdd" method="post">
	    <div class="struct">
	                       <p>新增角色</p>
		<div class="content">新角色：<input type="text" placeholder="新增角色" name="newRole"></div>
		<div class="note">新备注：<input type="text" placeholder="备注" name="newRemark"></div>
		<div class="btn"><input type="submit" name="submit"  value="增加"class="newAdd"></div>
		<div class="btn"><a href ="<%=request.getContextPath()%>/RoleAllocationBackManage" class="newAdd">取__消</a></div>
		</div>
	</form>
</body>
</html>