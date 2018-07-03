package com.cqut.roleAllocation.serlvet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.common.util.StringUtil;
import com.cqut.common.util.SysUtil;
import com.cqut.messageManagement.entity.MessageUser;
import com.cqut.messageManagement.impl.MessageDaoImpl;
import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.entity.RoleUserLink;
import com.cqut.userManagement.impl.UserDaoImpl;

/**
 * Servlet implementation class RoleAllocationBack
 */
@WebServlet("/RoleAllocationBack")
public class RoleAllocationBack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleAllocationBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		if (request.getParameter("update") != null) {
			List<RoleUserLink> role1 = new UserDaoImpl().getAllRoleA();
			String[] arr = request.getParameterValues("all");

			request.setCharacterEncoding("utf-8");
			for (int i = 0; i < role1.size(); i++) {

				int roleX = Integer.parseInt(arr[i]);
                int userId = role1.get(i).getuId();
				// 改变用户的角色
				@SuppressWarnings("unused")
				Boolean tt = new UserDaoImpl().role_allocaion(roleX, userId);
			}

		}

		// //首先获取所有的角色
		// List<RoleUserLink> role1 = new UserDaoImpl().getAllRole();

		// 获取角色表
		List<RoleAll> roleAlls = new UserDaoImpl().getRoleAll();

		Integer pageNum = 10;
		Integer curPage = 1;
		String str = request.getParameter("str");
		String scurPage = request.getParameter("curPage");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		Integer totalNum = userDaoImpl.getAllRoleNum(str);
		if (scurPage == null) {
			curPage = 1;// 从第一页开始访问
		} else {
			curPage = Integer.parseInt(scurPage);
		}
		Integer index = (curPage - 1) * pageNum;
		ArrayList<RoleUserLink> role1 = userDaoImpl.getAllRole(index, pageNum, StringUtil.emptyOrNull(str));
		String html = SysUtil.createPage(totalNum, curPage, pageNum, request.getContextPath() + "/RoleAllocationBack");
		request.setAttribute("html", html);
		request.setAttribute("str", str);
		request.setAttribute("role1", role1);

		// 将角色传入到前台
		request.setAttribute("roleAlls", roleAlls);

		request.getRequestDispatcher("roleAllocation/jsp/roleAllocationBack.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
