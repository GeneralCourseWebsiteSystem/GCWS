<%@page import="com.cqut.moduleManagement.entity.Module"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    ArrayList<Module> modules = (ArrayList<Module>)request.getAttribute("modules");
    String roleId = (String)request.getAttribute("roleId");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/authorityManagement/css/authorityManagement.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/common/js/script/jquery.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/authorityManagement/css/jquery.treeview.css" />	
<script src="<%=request.getContextPath() %>/authorityManagement/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/authorityManagement/js/jquery.treeview.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#browser").treeview({});

		$("#btn1").click(function(){
			var c = $("input[name='ids']:checked");
			
			alert(c.length);
		})

		$("#btn2").click(function(){
			var h = $("input[name='ids']:indeterminate");
			alert(h.length);
		})
		
	});
	
	function findParent(p,checked) {
		 $("input[id='"+p+"']").attr("indeterminate",checked);
	}
	function child(e) {
		var pId = e.id;
		var checked = e.checked;
		var p = $("#"+pId+"").attr("pId");
		
		if(checked) {
			findParent(p,checked);
			var children = $("input[pId='"+pId+"']");
			for(var i = 0; i < children.length; i++){
				$(children[i]).attr("checked", checked);
			}

			var checkLevelLengh = $("input[pId='"+p+"']:checked").length;
			var levelLengh = $("input[pId='"+p+"']").length;
			if(checkLevelLengh == levelLengh) {
				$("#"+p+"").removeAttr("indeterminate");
				$("#"+p+"").attr("checked",checked);
			}
		}else {
			var children = $("input[pId='"+pId+"']");
			for(var i = 0; i < children.length; i++){
				$(children[i]).attr("checked", checked);
			}

			var checkLevelLengh = $("input[pId='"+p+"']:checked").length;
			if(checkLevelLengh == 0) {
				$("#"+p+"").removeAttr("indeterminate");
				$("#"+p+"").attr("checked",checked);
			}else {
				$("#"+p+"").attr("indeterminate",true);
			}
		}
	}

	</script>
</head>
<body>
	<div class="authority">
		<div class="curLocation authorityManage">
			<p>
				<a href="AuthorityManagement">权限管理</a>>><a href="#">分配权限</a>
			</p>
		</div>
	</div>
	<form id="main" action="<%=request.getContextPath() %>/UpdatePermission" method="post">
	<ul id='browser' class='filetree treeview'>
		<%for(Module module: modules){ %>
			<% if(module.getParentCode().equals("/")){ %>
			<li class="collapsable" style="display: block;">
				<div class="hitarea collapsable-hitarea"></div>
				<span class='folder'><input type="checkbox" name="ids" id="<%=module.getLevel() %>" pId="0" value="<%=module.getId() %>" onchange="child(this)"/><%=module.getModuleName() %></span>
		
				<ul>
				<% for(Module c_module: modules){ %>
					<% if(c_module.getParentCode().equals(module.getModuleCode())){ %>
					<li><span class='file'><input type="checkbox" name="ids" id='<%=c_module.getLevel() %>' pId="<%=module.getLevel() %>" value="<%=c_module.getId() %>" onchange="child(this)"/><%=c_module.getModuleName() %></span></li>
					<% } %>
				<% } %>
				</ul>
			</li>
			<% } %>
		<% } %>					
	</ul>
	<div class="updatePermission">
		<input type="hidden" name="roleId" value="<%=roleId %>">
		<input type="submit" value="分配">
	</div>
</form>
	
</body>
</html>