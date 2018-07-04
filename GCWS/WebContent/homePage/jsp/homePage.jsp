<%@page import="com.cqut.courseForStage.entity.CourseForStage"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<CourseForStage> courses = (ArrayList<CourseForStage>) request.getAttribute("courses");
	String userName = (String)request.getAttribute("userName");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通用课程</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/homePage/css/homePage.css">
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/common/css/page.css">
</head>
<body>
	<div class="homePageHeader">
		<div class="header_box">
		<div class="login">
			<div class="login_btn">
				<a href="<%=request.getContextPath()%>/login/jsp/stageLogin.jsp"><%= userName %></a>
			</div>
		</div>
		<div class="home_logo">
			<img alt="."
				src="<%=request.getContextPath()%>/common/image/logo.png"> <label>重庆理工大学</label>
		</div>
		<div class="home_img">
			<img alt="."
				src="<%=request.getContextPath()%>/common/image/show_img.jpg">
		</div>
		</div>
	</div>
	<div class="course_list">
		<%
			for(int i = 0; i<courses.size(); i++) {
		%>
		<div class="course_box">
			<img alt="."
				src="<%=request.getContextPath()%>/common/image/logo.png"> <a
				href="ChooseCourse?id=<%= courses.get(i).getId() %>"><%=courses.get(i).getCourse_name()%></a>
		</div>
		<%
			}
		%>
	</div>
	<div class="paging">
		<c:if test="${not empty html}">
			<div class="page">${html}</div>
		</c:if>
	</div>
	<%@ include file="../../common/jsp/footer.jsp"%>
</body>
</html>