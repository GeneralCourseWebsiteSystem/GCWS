package com.cqut.roleAllocation.serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.roleAllocation.impl.RoleAllcocationDaoImpl;

/**
 * Servlet implementation class RoleAllocationDelete
 */
@WebServlet("/RoleAllocationDelete")
public class RoleAllocationDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleAllocationDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //获取删除的id
		int  role_id= Integer.parseInt(request.getParameter("name"));
		
		@SuppressWarnings("unused")
		Boolean IF = new RoleAllcocationDaoImpl().role_delete(role_id);
		
		response.sendRedirect("RoleAllocationBackManage");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
