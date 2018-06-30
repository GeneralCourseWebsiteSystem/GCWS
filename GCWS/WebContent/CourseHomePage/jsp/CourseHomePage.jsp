<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/CourseHomePage/css/courseHomePage.css" />
<title>通用课程网站系统</title>
</head>
<body>
	<div class="style1"><h5>课程简介</h5></div>
	<div class="style2"><h5>课程负责人</h5></div>
	<div class="style3"><h5>课程动态</h5></div>
	<div class="style4"><h5>教学资源</h5></div>
	<div class="style4"><h5>课程组成员</h5></div>
	
</body>
</html>