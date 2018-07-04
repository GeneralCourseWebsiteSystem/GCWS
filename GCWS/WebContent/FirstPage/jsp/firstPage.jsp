<%@page import="com.cqut.teachTeamManagement.entity.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cqut.courseIntroduce.entity.CourseActive"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*课程简介*/
	String courseInfo  = (String)request.getAttribute("courseIntroduce");
	List<CourseActive> courseActives = (List<CourseActive>)request.getAttribute("courseActives");
	ArrayList<Teacher> teachers = (ArrayList<Teacher>)request.getAttribute("teachers");
	String charge = (String) request.getAttribute("charge");
	String teachWay = (String) request.getAttribute("teachWay");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/FirstPage/css/firstPage.css">
</head>
<body>
	<div class="main">
		<div class="courseInfo">
			<div class="title">
				<div class="line"></div>
				<p class="tw">课程简介 <span> Introduce</span></p>
			</div>
			<hr/>
			<div class="text">
				<p><%=courseInfo %></p>
			</div>
		</div>
		<div class="courseCharge">
			<div class="title">
				<div class="line"></div>
				<p class="tw">课程负责人 <span> Principal</span></p>
			</div>
			<hr/>
			<div class="text">
				<p><%=charge %></p>
			</div>
		</div>
		<div class="misStatement">
			<div class="title">
				<div class="line"></div>
				<p class="tw">课程动态 <span> Dynamic State</span></p>
			</div>
			<hr/>
			<div>
				<ul>
					<%for(int i = 0; i < courseActives.size(); i++){ %>
						<li>
							<span class="leftSpan"><%=courseActives.get(i).getArticleName() %></span>
							<span class="rightSpan"><%=courseActives.get(i).getUserName() %></span>
						</li>
					<%} %>
				</ul>
			</div>
		</div>
		<div class="teachWay">
			<div class="title">
				<div class="line"></div>
				<p class="tw">教学方法 <span> Teach Way</span></p>
			</div>
			<hr/>
			<div class="tw">
				<p><%=teachWay %></p>
			</div>
		</div>
		<div class="teachers">
			<div class="title">
				<div class="line"></div>
				<p class="tw">课程组成员 <span> Members</span></p>
			</div>
			<hr/>
			<div class="member">
				<%for(int i = 0; i < teachers.size(); i++) { %>
					<img class="img" alt="暂无照片" src="<%=request.getContextPath() %>/common/image/5.jpg">
				<%} %>
			</div>
		</div>
	</div>
</body>
</html>