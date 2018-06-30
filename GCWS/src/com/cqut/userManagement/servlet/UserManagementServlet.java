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

import com.cqut.userManagement.entity.User;
import com.cqut.userManagement.impl.UserDaoImpl;

/**
 * Servlet implementation class UserManagementServlet
 */
@WebServlet("/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagementServlet() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.print("sss");
		  HttpSession session = request.getSession();
		  PrintWriter out = response.getWriter();  
		  String username = request.getParameter("user");
		  String pwd = request.getParameter("password");
		  UserDaoImpl userDao=new UserDaoImpl();
		  boolean result=true;
		  System.out.print(username);
		  ArrayList<User> userList =userDao.getAll();
		  User user=userDao.getId(username);
		  System.out.print(user.getPassword());
		  
		  for(int i=0;i<userList.size();i++){
			  if(userList.get(i).getAccount().equals(username)){
				  if(pwd.equals(user.getPassword())){
					  
					  response.sendRedirect("BackStageLogin.jsp");
				  }
				  else{
					  out.print("<script>alert('密码错误');window.location='ReturnLogin?do=login';</script>");  
					  return;
				  }
			  }else{
				  result=false;
			  }
		  }
		  if(result==false){
				  out.print("<script>alert('没有此账号');window.location='ReturnLogin?do=login';</script>"); 
				  return;
		  }
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
