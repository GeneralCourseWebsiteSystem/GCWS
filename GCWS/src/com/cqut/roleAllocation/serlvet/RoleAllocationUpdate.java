package com.cqut.roleAllocation.serlvet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.roleAllocation.impl.RoleAllcocationDaoImpl;
import com.cqut.userManagement.entity.RoleAll;

/**
 * Servlet implementation class RoleAllocationUpdate
 */
@WebServlet("/RoleAllocationUpdate")
public class RoleAllocationUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleAllocationUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//创建一个RoleAll角色传过去
		int roleId =Integer.parseInt(request.getParameter("name"));
		List<RoleAll> newRole = new RoleAllcocationDaoImpl().findRoleNameById(roleId);
		
		
		
		request.setAttribute("newRole", newRole);
		request.getRequestDispatcher("roleAllocation/jsp/roleAllocationUpdate.jsp").forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int roleId = Integer.parseInt(request.getParameter("roleId"));
			String newRoleName = request.getParameter("newRoleName");
			String newRemark = request.getParameter("newRemark");
			
			@SuppressWarnings("unused")
			Boolean IF = new RoleAllcocationDaoImpl().role_update(roleId,newRoleName,newRemark);
			
			//修改后查询所有的角色
			response.sendRedirect("RoleAllocationBackManage");
				
			
	}

}
