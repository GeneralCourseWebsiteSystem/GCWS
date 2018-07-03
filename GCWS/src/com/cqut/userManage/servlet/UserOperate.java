package com.cqut.userManage.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.naming.java.javaURLContextFactory;

import com.cqut.userManage.impl.UserManageDaoImpl;
import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.entity.User;
import com.cqut.userManagement.impl.UserDaoImpl;

/**
 * Servlet implementation class UserOperate
 */
@WebServlet("/UserOperate")
public class UserOperate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOperate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String operate = request.getParameter("operate");
		UserManageDaoImpl userManageDaoImpl =new UserManageDaoImpl();
		if(operate.equals("show")) {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userManageDaoImpl.findById(id);
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("userManage/jsp/userDetail.jsp").forward(request, response);
		}
		if(operate.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userManageDaoImpl.findById(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("userManage/jsp/userEdit.jsp").forward(request, response);
		}
		if(operate.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			userManageDaoImpl.deleteUser(id);
			response.sendRedirect("UserManage");
		}
		if(operate.equals("lock")) {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userManageDaoImpl.findById(id);
			user.setIsLock((byte) 1);
			userManageDaoImpl.updateUser(user);
			response.sendRedirect("UserManage");
		}
		if(operate.equals("unlock")) {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userManageDaoImpl.findById(id);
			user.setIsLock((byte) 0);
			userManageDaoImpl.updateUser(user);
			response.sendRedirect("UserManage");
		}
		if(operate.equals("update")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			User newUser = userManageDaoImpl.findById(userId);
			String userName = request.getParameter("userName");
			String userPhone = request.getParameter("userPhone");
			newUser.setUserName(userName);
			newUser.setPhoneNumber(userPhone);
			userManageDaoImpl.updateUser(newUser);
			response.sendRedirect("UserManage");
		}
		if(operate.equals("add")) {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			ArrayList<RoleAll> roleList = userDaoImpl.getRoleAll();
			request.setAttribute("roleList", roleList);
			request.getRequestDispatcher("userManage/jsp/userAdd.jsp").forward(request, response);
		}
		if(operate.equals("addUser")) {
			User user = new User();
			int roleId = Integer.parseInt(request.getParameter("role"));
			String userAccount = request.getParameter("userAccount");
			String userPassword = request.getParameter("userPassword");
			String userName = request.getParameter("userName");
			String userPhone = request.getParameter("userPhone");
			Byte is_delete = 0;
			Byte is_lock = 0;
			Byte is_associates = 0;
			user.setRoleId(roleId);
			user.setAccount(userAccount);
			user.setUserName(userName);
			user.setPassword(userPassword);
			user.setPhoneNumber(userPhone);
			user.setIsLock(is_lock);
			user.setIsAssociates(is_associates);
			user.setIsDelete(is_delete);
			user.setCreateTime(new Date());
			userManageDaoImpl.addUser(user);
			response.sendRedirect("UserManage");
		}
	}

}
