<%@page import="com.cqut.programManagement.impl.ProgramImpl"%>
<%@page import="com.cqut.programManagement.entity.Program"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cqut.homeInformationSetting.entity.HomeProgram"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	HomeProgram homeProgram = (HomeProgram)request.getAttribute("homeProgram");
	ArrayList<Program> programs = new ProgramImpl().getAllProgramWithNoLimit();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>homeInformationSetting/css/homeInfoManagement.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>homeInformationSetting/js/homeInfoManagement.js"></script>
<title>首页信息设置更新</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="HomeProgramServlet">首页信息设置</a> >> <a>修改</a></p>
		</div>
	</div>
	<form class="programForm" action="HomeProgramUpdateSure" onsubmit="return validate(this);">
		<table class="programTable">
			<tr style="display: none;">
				<td class="leftTd">*id</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="id" value="<%=homeProgram.getId() %>" /> 
				</td>	
			</tr>
			<tr>
				<td class="leftTd">*栏目:</td>
				<td class="rightTd">
					<select class="inputText"  name="programId" >
						<%
						for(int i = 0; i < programs.size(); i++) { 
							if(homeProgram.getProgramId() == programs.get(i).getId()){
						%>
						<option selected="selected" value="<%=programs.get(i).getId() %>"><%=programs.get(i).getProgramName() %></option>
						<%
							} else {
						%>
						<option value="<%=programs.get(i).getId() %>"><%=programs.get(i).getProgramName() %></option>
						<%
							}
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td class="leftTd">*是否展示:</td>
				<td>
					<%
						if(homeProgram.getIsShow() == 0){
					%>
						否<input type="radio" checked="checked" name="isShow" value="0"/>
						是<input type="radio" name="isShow" value="1"/>
					<%	
						} else {
					%>
						否<input type="radio" name="isShow" value="0"/>
						是<input type="radio" checked="checked" name="isShow" value="1"/>
					<%	
						}
					%>
				</td>
			</tr>
			<tr>
				<td class="leftTd">展示顺序:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="showNo" value="<%=homeProgram.getShowNo() %>" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">宽:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="width" value="<%=homeProgram.getWidth() %>" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">高:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="height" value="<%=homeProgram.getHeight() %>" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">css类名:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="cssName" value="<%=homeProgram.getCssName() %>" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">备注:</td>
				<td class="rightTd">
					<textarea name="remark" class="programCode" style="height: 100px;"><%=(homeProgram.getRemark() == null ? "" : homeProgram.getRemark()) %></textarea>
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