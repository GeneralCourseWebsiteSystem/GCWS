package com.cqut.roleAllocation.serlvet;

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
 * Servlet implementation class RoleAllocationBackManage
 */
@WebServlet("/RoleAllocationBackManage")
public class RoleAllocationBackManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleAllocationBackManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取角色表中的所有角色
		//List<RoleAll> roleAlls = new UserDaoImpl().getRoleAllManage();
		
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
		ArrayList<RoleAll> roleAlls = userDaoImpl.getRoleAllManage(index, pageNum, StringUtil.emptyOrNull(str));
		String html = SysUtil.createPage(totalNum, curPage, pageNum, request.getContextPath() + "/RoleAllocationBackManage");
		request.setAttribute("html", html);
		request.setAttribute("str", str);
		request.setAttribute("roleAlls",roleAlls);
		
		
		request.getRequestDispatcher("roleAllocation/jsp/roleAllocationBackManage.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
