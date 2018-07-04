<%@page import="java.util.ArrayList"%>
<%@page import="com.cqut.homeInformationSetting.entity.HomeProgram"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<HomeProgram> homePrograms = (ArrayList<HomeProgram>)request.getAttribute("homeProgramList");
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
<link href="<%=basePath %>homeInformationSetting/css/homeInfoManagement.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>common/css/page.css" rel="stylesheet" type="text/css" />
<title>首页信息设置</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleManage">
			<p><a href="HomeProgramServlet">首页信息设置</a></p>
		</div>
	</div>
	<form class="searchForm" action="" method="get">
		<p>
			栏目名:<input class="searchInput" placeholder="请输入栏目名称" type="text" name="name" value="<%=name%>"/> 
			<input class="searchButton" type="submit" value="查询"/>
		</p>
	</form>
	<div class="addNewModule"><a href="<%=basePath %>/homeInformationSetting/jsp/homeInfoManagementAdd.jsp">新增</a></div>
	<table class="articleTable">
		<tr class="thTr">
			<th style="width:20%;">栏目名称</th>
			<th style="width:10%;">栏目路径</th>
			<th style="width:8%;">首页展示</th>
			<th style="width:8%;">展示顺序</th>
			<th style="width:8%;">宽</th>
			<th style="width:8%;">高</th>
			<th style="width:10%;">css类名</th>
			<th style="width:20%;">操作</th>
		</tr>
		<%
			for(int i = 0; i < homePrograms.size(); i++){ 
		%>
		<tr>
			<td><%=homePrograms.get(i).getProgramName() %></td>
			<td><%=homePrograms.get(i).getProgramPath() %></td>
			<td><%=(homePrograms.get(i).getIsShow() == 0 ? "否" : "是") %></td>
			<td><%=homePrograms.get(i).getShowNo() %></td>
			<td><%=homePrograms.get(i).getWidth() %></td>
			<td><%=homePrograms.get(i).getHeight() %></td>
			<td><%=homePrograms.get(i).getCssName() %></td>
			<td>
				<a class="hrefA" href="HomeProgramUpdate?id=<%=homePrograms.get(i).getId()%>">编辑</a> |
				<a class="hrefA" href="HomeProgramDelete?id=<%=homePrograms.get(i).getId()%>">删除</a>
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