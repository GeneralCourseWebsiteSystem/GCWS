package com.cqut.backStageManagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.backStageManagement.entity.BackRole;
import com.cqut.backStageManagement.entity.BackUser;
import com.cqut.backStageManagement.impl.BackStageManagementDaoImpl;
import com.cqut.userManagement.entity.RoleUserLink;

/**
 * Servlet implementation class BackStageManagementServlet
 */
@WebServlet("/BackStageManagementServlet")
public class BackStageManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackStageManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("user");
		String pwd = request.getParameter("password");

		BackStageManagementDaoImpl userDao = new BackStageManagementDaoImpl();
		boolean result = true;

		ArrayList<BackUser> userList = userDao.getAll();
		BackUser user = userDao.getId(username);
		

		if(user.getAccount() == null) {
			out.print("<script>alert('账号不存在！');window.location='ReturnBackStageLogin';</script>");
			return;
		} else {
			RoleUserLink role = userDao.getUserRole(user.getId());
			if(user.getIsLock() == 1) {
				out.print("<script>alert('账号被锁，请联系管理员！');window.location='ReturnBackStageLogin';</script>");
				return;
			} else {
				if (pwd.equals(user.getPassword())) {
					session.setAttribute("userid", user.getId()); 
					session.setAttribute("username",user.getUserName());
					session.setAttribute("roleId",role.getId());
					response.sendRedirect("common/jsp/leftNav.jsp");
				} else {
					out.print("<script>alert('密码错误！');window.location='ReturnBackStageLogin';</script>");
					return;
				}
			}
		

		}

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
