package com.cqut.roleAllocation.serlvet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.roleAllocation.impl.RoleAllcocationDaoImpl;
import com.cqut.userManagement.entity.RoleAll;

/**
 * Servlet implementation class RoleAllocationAdd
 */
@WebServlet("/RoleAllocationAdd")
public class RoleAllocationAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleAllocationAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//创建一个角色
		String roleName = request.getParameter("newRole");
		Date createTime = new java.sql.Date(new Date().getTime()); 
		Byte isDelete = 0;
		String remark = request.getParameter("newRemark");
		
		RoleAll roleAll = new RoleAll(null, roleName, createTime, isDelete, remark);
		
		@SuppressWarnings("unused")
		Boolean  IF = new RoleAllcocationDaoImpl().role_add(roleAll);
		
		response.sendRedirect("RoleAllocationBackManage");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
