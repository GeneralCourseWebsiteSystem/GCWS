<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cqut.courseResearchManagement.entity.CourseResearch"
         import="java.util.ArrayList"
 %>
<%
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
                     + request.getServerName() + ":" + request.getServerPort()  
                     + path + "/";  
  
    ArrayList<CourseResearch> clist=(ArrayList<CourseResearch>)session.getAttribute("clist");
    String courseid=(String)session.getAttribute("courseid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CourseResearch/css/courseResearch.css">
</head>
<body>

<div class="main">
   <div class="mainTop">
	<%  for(int i=0;i<clist.size();i++) {%>
	   <div class="content">
	   		<table class="articleTable">
	   			<tr>
	   				<td class="leftTd"> <a href="<%=request.getContextPath() %>/ArticleShow?show=<%=clist.get(i).getId() %>&title=<%=clist.get(i).getArticlename() %>&courseid=<%=courseid %>">
	      				<%=clist.get(i).getArticlename() %>\<%=clist.get(i).getName() %></a></td>
	   				<td class="rightTd">  <%=clist.get(i).getFinishtime() %></td>
	   			</tr>
	   		</table>
	   </div>
	<%} %>
	</div>
</div>
</body>
</html>