package com.cqut.articleManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.articleManagement.entity.ArticleCourse;
import com.cqut.articleManagement.impl.ArticleCourseImpl;
import com.cqut.common.util.StringUtil;
import com.cqut.common.util.SysUtil;

/**
 * Servlet implementation class ArticleCourseServlet
 */
@WebServlet("/ArticleCourseServlet")
public class ArticleCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleCourseServlet() {
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
		Integer pageNum = 10;
		Integer curPage = 1;
		String name = request.getParameter("name");
		String scurPage = request.getParameter("curPage");
		ArticleCourseImpl articleCourseImpl = new ArticleCourseImpl();
		Integer totalNum = articleCourseImpl.getAllSize(name);
		if(scurPage == null){
            curPage = 1;//从第一页开始访问
        }else{
            curPage = Integer.parseInt(scurPage);
        }
		Integer index = (curPage-1) * pageNum;
		ArrayList<ArticleCourse> acList = articleCourseImpl.getList(index, pageNum, StringUtil.emptyOrNull(name));
		request.setAttribute("acList", acList);
		String html = SysUtil.createPage(totalNum, curPage, pageNum, request.getContextPath() + "/ArticleCouserServlet");
		request.setAttribute("html", html);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/ArticleManagement/jsp/articleManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
