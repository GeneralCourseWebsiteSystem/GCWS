package com.cqut.authorityManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.common.util.StringUtil;
import com.cqut.common.util.SysUtil;
import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.impl.UserDaoImpl;

/**
 * Servlet implementation class AuthorityManagement
 */
@WebServlet("/AuthorityManagement")
public class AuthorityManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorityManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		Integer pageNum = 10;
		Integer curPage = 1;
		String name = request.getParameter("name");
		String scurPage = request.getParameter("curPage");
		Integer totalNum = userDaoImpl.getAllRoleNum(name);
		if(scurPage == null){
            curPage = 1;//从第一页开始访问
        }else{
            curPage = Integer.parseInt(scurPage);
        }
		Integer index = (curPage-1) * pageNum;
		
		ArrayList<RoleAll> roles = new ArrayList<>();
		roles = userDaoImpl.getRoleAllManage(index, pageNum, StringUtil.emptyOrNull(name));
		request.setAttribute("roles", roles);
		String html = SysUtil.createPage(totalNum, curPage, pageNum, request.getContextPath() + "/UserManage");
		request.setAttribute("html", html);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/authorityManagement/jsp/authorityManagement.jsp").forward(request, response);
	}

}
