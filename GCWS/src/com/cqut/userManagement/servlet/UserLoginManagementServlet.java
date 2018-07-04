package com.cqut.userManagement.servlet;

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

import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.entity.User;
import com.cqut.userManagement.impl.UserLoginManagementDaoImpl;

/**
 * Servlet implementation class UserManagementServlet
 */
@WebServlet("/UserManagementServlet")
public class UserLoginManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginManagementServlet() {
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

		UserLoginManagementDaoImpl userDao = new UserLoginManagementDaoImpl();
		boolean result = true;

		ArrayList<User> userList = userDao.getAll();
		User user = userDao.getId(username);
		
		if(user.getAccount() == null) {
			out.print("<script>alert('账号不存在！');window.location='ReturnLogin';</script>");
			return;
		} else {
			if(user.getIsLock() == 1) {
				out.print("<script>alert('账号被锁，请联系管理员！');window.location='ReturnLogin';</script>");
				return;
			} else {
				if (pwd.equals(user.getPassword())) {
					session.setAttribute("userid", user.getId());
					session.setAttribute("username", user.getUserName());
					response.sendRedirect(request.getContextPath() + "/HomePage");
				} else {
					out.print("<script>alert('密码错误！');window.location='ReturnLogin';</script>");
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
