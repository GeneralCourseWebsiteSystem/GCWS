<%@page import="com.cqut.moduleManagement.entity.Module"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	ArrayList<Module> modulesList = (ArrayList<Module>)request.getAttribute("moduleList");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>common/css/treeTable.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>ModuleManagement/css/moduleManagement.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>common/js/script/treeTable/default/jquery.treeTable.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>common/js/script/treeTable/vsStyle/jquery.treeTable.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>common/js/script/jquery.js"></script>
<script src="<%=basePath%>common/js/script/treeTable/jquery.treeTable.js" type="text/javascript"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		var option = {
			theme : 'vsStyle',
			expandLevel : 2,
			beforeExpand : function($treeTable, id) {
				//判断id是否已经有了孩子节点，如果有了就不再加载，这样就可以起到缓存的作用
				if ($('.' + id, $treeTable).length) {
					return;
				}
			},
			onSelect : function($treeTable, id) {
				window.console && console.log('onSelect:' + id);

			}

		};
		$('#treeTable1').treeTable(option);

		option.theme = 'default';
		$('#treeTable2').treeTable(option);
	});
</script>
</head>
<body>
<div class="articleHead">
	<div class="curLocation articleManage">
		<p><a href="ModuleManagementServlet">模块管理</a></p>
		
	</div>
</div>
<div class="addNewModule"><a href="<%=basePath %>/ModuleManagement/jsp/moduleManagementAdd.jsp">新增</a></div>
<div class="tableArea">
	<hr />
	<table id="treeTable1" class="moduleTable" style="width: 100%">
		<tr class="thTr">
			<th style="width: 20%;">模块名</th>
			<th style="width: 20%;">模块路径</th>
			<th style="width: 10%;">父模块编码</th>
			<th style="width: 10%;">是否菜单</th>
			<th style="width: 10%;">等级</th>
			<th style="width: 20%;">操作</th>
		</tr>
		<%
			for(int i = 0; i < modulesList.size(); i++) {
				String pid = modulesList.get(i).getParentCode();
				if(pid == null || pid.equals("/")){
		%>
		<tr id="<%=modulesList.get(i).getModuleCode() %>">
			<td><%=modulesList.get(i).getModuleName() %></td>
			<td><%=modulesList.get(i).getModulePath() %></td>
			<td><%=modulesList.get(i).getParentCode() %></td>
			<td><%=(modulesList.get(i).getIsMenu() == 0 ? "否" : "是") %></td>
			<td><%=modulesList.get(i).getLevel() %></td>
			<td>
				<a class="hrefA" href="ModuleManagementDetail?moduleId=<%=modulesList.get(i).getId()%>">详细</a> | 
				<a class="hrefA" href="ModuleManagementUpdate?moduleId=<%=modulesList.get(i).getId()%>">编辑</a> |
				<a class="hrefA" href="ModuleManagementDelete?moduleId=<%=modulesList.get(i).getId()%>">删除</a>
			</td>
		</tr>
		<%
				} else {
		%>
		<tr id="<%=modulesList.get(i).getModuleCode() %>" pId="<%=modulesList.get(i).getParentCode() %>">
			<td><%=modulesList.get(i).getModuleName() %></td>
			<td><%=modulesList.get(i).getModulePath() %></td>
			<td><%=modulesList.get(i).getParentCode() %></td>
			<td><%=(modulesList.get(i).getIsMenu() == 0 ? "否" : "是") %></td>
			<td><%=modulesList.get(i).getLevel() %></td>
			<td>
				<a class="hrefA" href="ModuleManagementDetail?moduleId=<%=modulesList.get(i).getId()%>">详细</a> | 
				<a class="hrefA" href="ModuleManagementUpdate?moduleId=<%=modulesList.get(i).getId()%>">编辑</a> |
				<a class="hrefA" href="ModuleManagementDelete?moduleId=<%=modulesList.get(i).getId()%>">删除</a>
			</td>
		</tr>
		<%
				}
			} 
		%>
	</table>
	<hr />
</div>
</body>
</html>