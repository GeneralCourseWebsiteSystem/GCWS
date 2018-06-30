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
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/stageMultiplexing.css">
</head>
<body>
	<%-- 使用公用页面方法：<%@ include file="路径.jsp" %> 
	css在自己写的页面导入--%>
	<div class="header">
		<div class="header_top">
			<div class="header_left">
			<div class="header_logo">
				<img alt="." src="<%=request.getContextPath() %>/common/image/logo.png"> <label>重庆理工大学</label>
			</div>
			<%-- 这里写的时候自己改，把下面注释掉 --%>
			<div class="header_title"><%-- <%=courseForStage.getCourse_name() %> --%>精品课程</div>
		</div>
		<div class="header_right">
			<div class="header_img">
				<img alt="." src="<%=request.getContextPath() %>/common/image/show_img.jpg">
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
				<!-- 跳转页面的传的参数自己加 -->
				<li onclick="to_courseHomepage()">首页</li>
				<li onclick="to_courseIntroduce()">课程介绍</li>
				<li onclick="to_teacherTeam()">教学团队</li>
				<li onclick="to_courseConstruction()">课程建设</li>
				<li onclick="to_courseResource()">课程资源</li>
				<li onclick="to_courseMessage()">留言</li>
				<li onclick="to_courseResearch()">课程研究</li>
			</ul>
		</div>
	</div>
</body>
</html>