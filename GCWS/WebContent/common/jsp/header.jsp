<%@page import="com.cqut.courseForStage.entity.CourseForStage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% 
	CourseForStage course = (CourseForStage)request.getAttribute("course");
	Integer userId = (Integer)request.getAttribute("userId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/stageMultiplexing.css">
</head>
<body>
	<%-- 使用公用页面方法：<%@ include file="路径.jsp" %>--%>
	<div class="header">
		<div class="header_top">
			<div class="header_left">
			<div class="header_logo">
				<img alt="." src="<%=request.getContextPath() %>/common/image/logo.png"> <label>重庆理工大学</label>
			</div>
			<%-- 这里写的时候自己改，把下面注释掉 --%>
			<div class="header_title"> <%=course.getCourse_name() %>精品课程</div>
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
				<li><a href="javascript:void(0);">首页</a></li>
				<li><a href="javascript:void(0);">课程介绍</a></li>
				<li><a href="javascript:void(0);">教学团队</a></li>
				<li><a href="javascript:void(0);">课程资源</a></li>
				<li><a href="javascript:void(0);">留言</a></li>
				<li><a href="javascript:void(0);">课程研究</a></li>
			</ul>
		</div>
	</div>
	<div class="frame">
		<iframe src="<%=request.getContextPath() %>/common/jsp/welcome.jsp" class="innerFrame" name="innerFrame" frameborder="0" scrolling="auto"></iframe>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>