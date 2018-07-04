package com.cqut.authorityManagement.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.authorityManagement.entity.ModuleRole;
import com.cqut.authorityManagement.impl.PermissionDaoImpl;
import com.cqut.common.util.StringUtil;

/**
 * Servlet implementation class UpdatePermission
 */
@WebServlet("/UpdatePermission")
public class UpdatePermission extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePermission() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int roleId = Integer.parseInt(request.getParameter("roleId"));
		String[] item = request.getParameterValues("ids");

		Date create_time = new Date();
		Byte is_delete = 0;

		PermissionDaoImpl permissionDaoImpl = new PermissionDaoImpl();

		if(permissionDaoImpl.findByRoleId(roleId) != null) {
			permissionDaoImpl.deletePermission(roleId);
			for(int i = 0; i < item.length; i++) {
				int moduleId = Integer.parseInt(item[i]);
				ModuleRole moduleRole = new ModuleRole();
				moduleRole.setRole_id(roleId);
				moduleRole.setModule_id(moduleId);
				moduleRole.setCreate_time(StringUtil.changeToSqlDate(create_time));
				moduleRole.setIs_delete(is_delete);
				permissionDaoImpl.addPermission(moduleRole);
			}
			response.sendRedirect(request.getContextPath()+"/AuthorityManagement");
		}else {
			for(int i = 0; i < item.length; i++) {
				int moduleId = Integer.parseInt(item[i]);
				ModuleRole moduleRole = new ModuleRole();
				moduleRole.setRole_id(roleId);
				moduleRole.setModule_id(moduleId);
				moduleRole.setCreate_time(StringUtil.changeToSqlDate(create_time));
				moduleRole.setIs_delete(is_delete);
				permissionDaoImpl.addPermission(moduleRole);
			}
			response.sendRedirect(request.getContextPath()+"/AuthorityManagement");
		}
	}

}
