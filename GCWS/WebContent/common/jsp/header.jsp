<%@page import="com.cqut.courseForStage.entity.CourseForStage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% 
	CourseForStage courseForStage = (CourseForStage)request.getAttribute("course");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/stageMultiplexing.css">
</head>
<body>
	<div class="header">
		<div class="header_top">
			<div class="header_left">
			<div class="header_logo">
				<img alt="." src="../image/logo.png"> <label>重庆理工大学</label>
			</div>
			<div class="header_title">数据结构精品课程</div>
		</div>
		<div class="header_right">
			<div class="header_img">
				<img alt="." src="../image/show_img.jpg">
			</div>
		</div>
		</div>
		
		<div class="course_search">
			<span>全站搜索</span> <input class="search_text" type="text"
				name="search_content" placeholder="请输入搜索内容"> <input
				class="search_btn" type="button" value="搜索"
				onclick="searchFromAll()">
		</div>
		<div class="course_nav">
			<ul>
				<li>首页</li>
				<li>课程介绍</li>
				<li>教学团队</li>
				<li>课程建设</li>
				<li>课程资源</li>
				<li>留言</li>
				<li>课程研究</li>
			</ul>
		</div>
	</div>
</body>
</html>