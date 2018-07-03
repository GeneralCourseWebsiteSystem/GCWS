<%@page import="com.cqut.articleManagement.entity.ArticleCourse"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<ArticleCourse> acList = (ArrayList<ArticleCourse>)request.getAttribute("acList");
	String name = (String)request.getAttribute("name");
	if(name==null){
		name = "";
	}
	String html = (String)request.getAttribute("html");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>ArticleManagement/css/articleManagement.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>common/css/page.css" rel="stylesheet" type="text/css" />
<title>文章审核</title>
</head>
<body>
<div class="articleHead">
		<div class="curLocation articleManage">
			<p><a href="ArticleCourseServlet">文章审核</a></p>
		</div>
	</div>
	<form class="searchForm" action="" method="get">
		<p>
			文章标题:<input class="searchInput" placeholder="请输入文章标题" type="text" name="name" value="<%=name%>"/> 
			<input class="searchButton" type="submit" value="查询"/>
		</p>
	</form>
	<table class="articleTable">
		<tr class="thTr">
			<th style="width:30%;">文章标题</th>
			<th style="width:8%;">文章类型</th>
			<th style="width:8%;">作者</th>
			<th style="width:15%;">所属课程</th>
			<th style="width:15%;">发表时间</th>
			<th style="width:8%;">操作</th>
		</tr>
		<%
			for(int i = 0; i < acList.size(); i++){ 
				String articleType = "";
				String checkState = "";
				if(acList.get(i).getArticleType() == 0){
					articleType = "研究类";
				} else if(acList.get(i).getArticleType() == 1){
					articleType = "动态类";
				} else {
					articleType = "未分类";
				}
		%>
		<tr>
			<td><%=acList.get(i).getArticleName() %></td>
			<td><%=articleType %></td>
			<td><%=acList.get(i).getAuthorName() %></td>
			<td><%=acList.get(i).getCourseName() %></td>
			<td><%=acList.get(i).getCreateTime() %></td>
			<td>
				<a class="hrefA" href="ArticleReviewCheck?articleId=<%=acList.get(i).getId()%>">审核</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<div style="width: 97%; margin-left: 1.5%;">
		<c:if test="${not empty html}">
			<div class="page">${html}</div>
		</c:if>
	</div>
</body>
</html>