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
			request.setAttribute("warning", 0);
			request.getRequestDispatcher("ReturnLogin").forward(request, response);
			return;
		} else {
			if(user.getIsLock() == 1) {
				request.setAttribute("warning", 1);
				request.getRequestDispatcher("ReturnLogin").forward(request, response);
				return;
			} else {
				if (pwd.equals(user.getPassword())) {
					session.setAttribute("userid", user.getId());
					session.setAttribute("username", user.getUserName());
					response.sendRedirect(request.getContextPath() + "/HomePage");
				} else {
					request.setAttribute("warning", 2);
					request.getRequestDispatcher("ReturnLogin").forward(request, response);
					return;
				}
			}
		}
		

		/*
		 * if(user.getAccount()=="" || user.getAccount() == null) {
		 * out.print("<script>alert('账号！');</script>");
		 * request.getRequestDispatcher("ReturnLogin").forward(request, response);
		 * return;
		 * 
		 * }else { RoleAll role=userDao.getRoleId(user.getId());
		 * 
		 * if(role.getRoleName().equals("用户")) { for(int i=0;i<userList.size();i++){
		 * if(userList.get(i).getAccount().equals(username)){
		 * if(pwd.equals(user.getPassword())){ session.setAttribute("userid",
		 * user.getId()); session.setAttribute("username",user.getUserName());
		 * response.sendRedirect(request.getContextPath()+"/HomePage"); } else{
		 * out.print(
		 * "<script>alert('密码错误');window.location='ReturnLogin?do=login';</script>");
		 * return; } }else{ result=false; } } if(result==false){ out.print(
		 * "<script>alert('没有此账号');window.location='ReturnLogin?do=login';</script>");
		 * return; } }else { out.print(
		 * "<script>alert('账号身份不对');window.location='ReturnLogin?do=login';</script>");
		 * return; } }
		 */
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
