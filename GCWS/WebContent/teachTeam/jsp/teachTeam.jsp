<%@page import="java.util.ArrayList"%>
<%@page import="com.cqut.teachTeamManagement.entity.TeacherInfor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<TeacherInfor> teacherInfors = (ArrayList<TeacherInfor>)request.getAttribute("teacherInfors");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/teachTeam/css/teachTeam.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/stageMultiplexing.css">
</head>
<body>
	<div class="teacher_list">
		<% for(TeacherInfor teacherInfor: teacherInfors){ %>
			<div class="teacher_infor">
				<table class="teacherTable">
					<tr>
						<td class="leftTd">
							<div class="teacher_photo">
								<img class="img" alt="暂无照片" src="<%=request.getContextPath() %>/common/image/5.jpg">
							</div>
						</td>
						<td class="rightTd">
							<div class="teacher_introduce">简介:<%=teacherInfor.getTeacherIntroduce() %></div>
							<div class="teacher_achievement">成就:<%=teacherInfor.getTeacherAchievement() %></div>
						</td>
					</tr>
					<tr>
						<td class="leftTd"><span><%=teacherInfor.getTeacherName() %></span></td>
						<td class="rightTd"></td>
					</tr>
				</table>
				
				<div class="information">
					<div class="teacher_base">
						
						
					</div>
					
				</div>
			</div>
		<% } %>
	</div>

</body>
</html>