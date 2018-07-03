package com.cqut.roleAllocation.serlvet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		List<RoleAll> roleAlls = new UserDaoImpl().getRoleAll();
		
		
		//实现分页
		int pageMegNum = 1;		
		if(request.getParameter("pageMegNum")!=null) {
			pageMegNum = Integer.parseInt(request.getParameter("pageMegNum"));
		}else {
			pageMegNum = 8;//设置每页的显示条数
		}
		
		
		int pageIndex = 1;
		int totalPage = 1;
		if(roleAlls.size()%pageMegNum==0) {
			totalPage = roleAlls.size()/pageMegNum;
		}else {
			totalPage = roleAlls.size()/pageMegNum+1;
		}				
		if(request.getParameter("pageIndex") == null){
			request.setAttribute("pageIndex", 1);
		}else{
			if(request.getParameter("pageTurn")!=null) {
				if(request.getParameter("pageTurn").equals("up")) {
					 pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
					if(Integer.parseInt(request.getParameter("pageIndex"))!=1) {
						pageIndex = pageIndex-1;
						request.setAttribute("pageIndex", pageIndex);
					}else {
						request.setAttribute("pageIndex", pageIndex);
					}
				}else {
					pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
					if(Integer.parseInt(request.getParameter("pageIndex"))!=totalPage) {
						pageIndex = pageIndex+1;				
						request.setAttribute("pageIndex", pageIndex);
					}else {
						request.setAttribute("pageIndex", pageIndex);
					}
				}				
			}else {
				request.setAttribute("pageIndex",1);
			}
		}	
		request.setAttribute("pageMegNum", pageMegNum);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("roleAlls",roleAlls);
		
		
		request.getRequestDispatcher("roleAllocation/jsp/roleAllocationBackManage.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
