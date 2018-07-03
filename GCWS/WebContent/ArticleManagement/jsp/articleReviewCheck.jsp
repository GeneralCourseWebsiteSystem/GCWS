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
<title>文章审核</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="ArticleReviewServlet">文章审核</a> >> <a>详情</a></p>
		</div>
	</div>
	<form class="articleForm" action="">
		<div class="articleTitle"><%=ac.getArticleName() %></div>
		<div class="articleInfo"><p>作者:<%=ac.getAuthorName() %> 所属课程:<%=ac.getCourseName() %> 发表时间:<%=ac.getCreateTime() %></p></div>
		<textarea class="articleContent" rows="" cols=""><%=ac.getArticleContent() %></textarea>
		<div class="opDiv">
			<div class="BT returnBT"><p><a href="ArticleReviewServlet">返回</a></p></div>
			<div class="BT passBT"><p><a href="ArticleReviewChange?articleId=<%=ac.getId() %>&checkState=0">通过</a></p></div>
			<div class="BT rejectBT"><p><a href="ArticleReviewChange?articleId=<%=ac.getId() %>&checkState=2">拒绝</a></p></div>
		</div>
	</form>
</body>
</html>