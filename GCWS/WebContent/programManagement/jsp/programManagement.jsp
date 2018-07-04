<%@page import="com.cqut.programManagement.entity.Program"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<Program> programList = (ArrayList<Program>)request.getAttribute("programList");
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
<link href="<%=basePath %>programManagement/css/programManagement.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>common/css/page.css" rel="stylesheet" type="text/css" />
<title>栏目管理</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleManage">
			<p><a href="ProgramManagementServlet">栏目管理</a></p>
		</div>
	</div>
	<form class="searchForm" action="" method="get">
		<p>
			栏目名:<input class="searchInput" placeholder="请输入栏目名" type="text" name="name" value="<%=name%>"/> 
			<input class="searchButton" type="submit" value="查询"/>
		</p>
	</form>
	<div class="addAProgram">
		<a href="<%=basePath %>/programManagement/jsp/programManagementAdd.jsp">新增</a>
	</div>
	<table class="articleTable">
		<tr class="thTr">
			<th style="width:20%;">栏目名</th>
			<th style="width:20%;">栏目路径</th>
			<th style="width:15%;">发表时间</th>
			<th style="width:20%;">操作</th>
		</tr>
		<%
			for(int i = 0; i < programList.size(); i++){ 
		%>
		<tr>
			<td><%=programList.get(i).getProgramName() %></td>
			<td><%=programList.get(i).getProgramPath() %></td>
			<td><%=programList.get(i).getCreateTime() %></td>
			<td>
				<a class="hrefA" href="ProgramMangementUpdate?programId=<%=programList.get(i).getId()%>">编辑</a> |
				<a class="hrefA" href="ProgramManagementDelete?programId=<%=programList.get(i).getId()%>">删除</a>
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