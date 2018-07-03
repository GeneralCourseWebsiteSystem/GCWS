package com.cqut.courseForStage.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.common.util.StringUtil;
import com.cqut.common.util.SysUtil;
import com.cqut.courseForStage.entity.CourseForStage;
import com.cqut.courseForStage.impl.HomePageDaoImpl;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePage() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HomePageDaoImpl homePageDaoImpl = new HomePageDaoImpl();
		
		Integer pageNum = 6;
		Integer curPage = 1;
		String name = request.getParameter("name");
		String scurPage = request.getParameter("curPage");
		Integer totalNum = homePageDaoImpl.getSize(name);
		if(scurPage == null){
            curPage = 1;//从第一页开始访问
        }else{
            curPage = Integer.parseInt(scurPage);
        }
		Integer index = (curPage-1) * pageNum;
		
		ArrayList<CourseForStage> courses = new ArrayList<>();
		courses = homePageDaoImpl.findByLimit(index, pageNum, StringUtil.emptyOrNull(name));
		request.setAttribute("courses", courses);
		String html = SysUtil.createPage(totalNum, curPage, pageNum, request.getContextPath() + "/HomePage");
		request.setAttribute("html", html);
		request.setAttribute("name", name);
		HttpSession session = request.getSession();
		String userName;
		if(session.getAttribute("username") == null) {
			userName = "登录";
		}
		else {
			userName = (String) session.getAttribute("username");
		}
		request.setAttribute("userName", userName);
		request.getRequestDispatcher("/homePage/jsp/homePage.jsp").forward(request, response);
	}

}
