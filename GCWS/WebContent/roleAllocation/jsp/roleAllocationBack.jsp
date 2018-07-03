<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"
	import="java.text.SimpleDateFormat" %>
	

 
<%@page import="com.cqut.userManagement.entity.role"%>
<%@page import="com.cqut.userManagement.entity.RoleAll"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<role> list = (List<role>) request.getAttribute("role1");
	List<RoleAll> list1 = (List<RoleAll>) request.getAttribute("roleAlls"); 
	int pageIndex = 1;
	Integer totalPage = Integer.parseInt(request.getAttribute("totalPage") + "");
	Integer pageMegNum = Integer.parseInt(request.getAttribute("pageMegNum") + "");
	if (request.getAttribute("pageIndex") == null) {
		pageIndex = 1;
	} else {
		pageIndex = Integer.parseInt(request.getAttribute("pageIndex") + "");
	}

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/roleAllocationBack" method="post">
	<table align='center' border='1' cellspacing='0' width="1000">
		<tr class="one">

			
			<td>用户名</td>
			<td>账号</td>
			<td>角色名称</td>
			


		</tr>
		<%
			for (int i = (pageIndex - 1) * pageMegNum; i < pageIndex * pageMegNum && i < list.size(); i++) {
		%>
		
		<tr height="50" class="two">

			<td class="exchange"><%=list.get(i).getUserName()%></td>

			<td><%=list.get(i).getAccount()%></td>

			

			<td>
			<select name="all">
			
            <option selected="selected"  value="<%=list.get(i).getId()%>"><%=list.get(i).getRoleName()%></option>   
    
    
			 <%for(int m=0;m<list1.size();m++){ 
			    if(list.get(i).getId()==list1.get(m).getId()){
			    	continue;
			    }
			 
			 %>
			 
			<option value="<%=list1.get(m).getId()%>"><%=list1.get(m).getRoleName()%></option>
			 
			<%}%>
   
			</select>
			</td>

          

			<td>
                 
                  
               
			</td>

		</tr>
		
		<%
		}
		%>

	</table>
	<input type="submit" name="update" value="update"/>
	</form>

	
		
	<div class="page">
		<a class="footpage"
			href="<%=request.getContextPath()%>/messageManagementBack?pageIndex=<%=pageIndex%>&pageTurn=up">&emsp;上一页</a>
		<span>&emsp;第<%=pageIndex%>页&emsp;
		</span> <a
			href="<%=request.getContextPath()%>/messageManagementBack?pageIndex=<%=pageIndex%>&pageTurn=down">下一页</a>
		<span>&emsp;共<%=totalPage%>页
		</span>
	</div>
</body>
</html>