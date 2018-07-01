<%@page import="com.cqut.articleManagement.entity.ArticleCourse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArticleCourse ac = (ArticleCourse)request.getAttribute("articleCourse");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>ArticleManagement/css/articleManagement.css" rel="stylesheet" type="text/css" />
<title>文章详情</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="ArticleCourseServlet">文章管理</a> >> <a>详情</a></p>
		</div>
	</div>
	<form action="">
		<div class="articleTitle"><%=ac.getArticleName() %></div>
		<textarea class="articleContent" rows="" cols=""><%=ac.getArticleContent() %></textarea>	
	</form>
</body>
</html>