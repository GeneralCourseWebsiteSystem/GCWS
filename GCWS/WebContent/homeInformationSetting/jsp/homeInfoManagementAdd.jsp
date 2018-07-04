<%@page import="com.cqut.programManagement.impl.ProgramImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cqut.programManagement.entity.Program"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<Program> programs = new ProgramImpl().getAllProgramWithNoLimit();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>homeInformationSetting/css/homeInfoManagement.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>homeInformationSetting/js/homeInfoManagement.js"></script>
<title>首页信息设置新增</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="HomeProgramServlet">首页信息设置</a> >> <a>新增</a></p>
		</div>
	</div>
	<form class="programForm" action="<%=basePath%>HomeProgramAdd" onsubmit="return validate(this);">
		<table class="programTable">
			<tr>
				<td class="leftTd">*栏目:</td>
				<td class="rightTd">
					<select class="inputText"  name="programId" >
						<option value="">==请选择==</option>
						<%
						for(int i = 0; i < programs.size(); i++) { 
						%>
							<option value="<%=programs.get(i).getId() %>"><%=programs.get(i).getProgramName() %></option>
						<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td class="leftTd">*是否展示:</td>
				<td>
					否<input type="radio" name="isShow" value="0"/>
					是<input type="radio" name="isShow" value="1"/>
				</td>
			</tr>
			<tr>
				<td class="leftTd">展示顺序:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="showNo" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">宽:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="width" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">高:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="height" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">css类名:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="cssName" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">备注:</td>
				<td class="rightTd">
					<textarea name="remark" class="programCode" style="height: 100px;"></textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input class="returnBT formBT" type="button" onclick="window.location.href='<%=basePath %>HomeProgramServlet'" value="返回">
					<input class="submitBT formBT" type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>