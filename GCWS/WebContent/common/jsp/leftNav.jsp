<%@page import="com.cqut.moduleManagement.impl.ModuleImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cqut.moduleManagement.entity.Module"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String roleId = String.valueOf(request.getSession().getAttribute("roleId"));
	ModuleImpl moduleImpl = new ModuleImpl();
	ArrayList<Module> modules = moduleImpl.getByRoleId(roleId);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="../font-awesome-4.7.0/css/font-awesome.min.css">
<script src="../js/common.js" type="text/javascript"></script>
<title>leftNav</title>
</head>
<body onload="statUp()">
	<%@include file="./bgHeader.jsp" %>
		<div class="leftNav">
			<div class="time" id="time"></div>
			<div class="menuArea">
				<ul id="menu">
				<%
					ArrayList<Module> parentModule = new ArrayList<Module>();
					for(int i = 0; i < modules.size(); i++){
						if(modules.get(i).getModuleCode().length() == 5){
							parentModule.add(modules.get(i));
						}
					}
					
					for(int i = 0; i < parentModule.size(); i++){
					%>
					<li>
						<a href="javascript:void(0);" onclick="doMenu(this)"><%=parentModule.get(i).getModuleName() %></a>
						<ul>
					<%
						for(int j = 0; j < modules.size(); j++){
							if(modules.get(j).getParentCode().equals(parentModule.get(i).getModuleCode())){
						%>
						<li><a href="<%=basePath %><%=modules.get(j).getModulePath() %>" target="innerFrame"><%=modules.get(j).getModuleName() %></a></li>
						<%
							}
						}
					%>
						</ul>
					</li>
					<%
					}
				%>
					<%-- <li>
						<a href="javascript:void(0);" onclick="doMenu(this)">网站内容管理</a>
						<ul>
							<li><a href="<%=basePath %>MessageManagementBack" target="innerFrame">留言管理</a></li>
							<li><a href="<%=basePath %>ArticleCourseServlet" target="innerFrame">文章管理</a></li>
							<li><a href="<%=basePath %>ArticleReviewServlet" target="innerFrame">审核文章</a></li>
							<li><a href="<%=basePath %>ProgramManagementServlet" target="innerFrame">栏目管理</a></li>
						</ul>
					</li>
					<li>
						<a href="javascript:void(0);" onclick="doMenu(this)">系统设置</a>
						<ul>
							<li><a href="<%=basePath %>AuthorityManagement" target="innerFrame">权限管理</a></li>
							<li><a href="<%=basePath %>ModuleManagementServlet" target="innerFrame">模块管理</a></li>
							<li><a href="<%=basePath %>RoleAllocationBack" target="innerFrame">角色分配</a></li>
							<li><a href="<%=basePath %>UserManage" target="innerFrame">人员管理</a></li>
							<li><a href="<%=basePath %>RoleAllocationBackManage" target="innerFrame">角色管理</a></li>
							<li><a href="<%=basePath %>HomeProgramServlet" target="innerFrame">首页信息设置</a></li>
							<li><a href="<%=basePath %>CodeTableManagementServlet" target="innerFrame">码表管理</a></li>
						</ul>
					</li> --%>
				</ul>
			</div>
		</div>
		<div class="right">
			<iframe src="<%=basePath %>common/jsp/welcome.jsp" class="innerFrame" name="innerFrame" frameborder="0" scrolling="auto"></iframe>
		</div>
	<%@include file="./bgFooter.jsp" %>
</body>
</html>