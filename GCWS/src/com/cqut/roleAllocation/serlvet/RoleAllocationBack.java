package com.cqut.roleAllocation.serlvet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		//获取参数
		if(request.getParameter("update")!=null) {
			List<RoleUserLink> role1 = new UserDaoImpl().getAllRole();
			String[] arr = request.getParameterValues("all");
			
			request.setCharacterEncoding("utf-8");
			for(int i=0;i<role1.size();i++) {
			
			int roleX= Integer.parseInt(arr[i]);
			
			
			
			
			
			
			//改变用户的角色
			@SuppressWarnings("unused")
			Boolean tt = new UserDaoImpl().role_allocaion(roleX,i+1);
			}
			
		}
		
		       //首先获取所有的角色
				List<RoleUserLink> role1 = new UserDaoImpl().getAllRole();
				
				//获取角色表
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
				if(role1.size()%pageMegNum==0) {
					totalPage = role1.size()/pageMegNum;
				}else {
					totalPage = role1.size()/pageMegNum+1;
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
				
				//将角色传入到前台
				request.setAttribute("role1", role1);
				request.setAttribute("roleAlls", roleAlls);
				
	
		request.getRequestDispatcher("roleAllocation/jsp/roleAllocationBack.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}