package com.cqut.homeInformationSetting.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.common.util.StringUtil;
import com.cqut.common.util.SysUtil;
import com.cqut.homeInformationSetting.entity.HomeProgram;
import com.cqut.homeInformationSetting.impl.HomeProgramImpl;

/**
 * Servlet implementation class HomeProgramServlet
 */
@WebServlet("/HomeProgramServlet")
public class HomeProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeProgramServlet() {
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
		HomeProgramImpl homeProgramImpl = new HomeProgramImpl();
		Integer totalNum = homeProgramImpl.getAllHomeProgramSize(name);
		if(scurPage == null){
            curPage = 1;//从第一页开始访问
        }else{
            curPage = Integer.parseInt(scurPage);
        }
		Integer index = (curPage-1) * pageNum;
		ArrayList<HomeProgram> homePrograms = homeProgramImpl.getAllHomeProgram(index, pageNum, StringUtil.emptyOrNull(name));
		request.setAttribute("homeProgramList", homePrograms);
		String html = SysUtil.createPage(totalNum, curPage, pageNum, request.getContextPath() + "/HomeProgramServlet");
		request.setAttribute("html", html);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/homeInformationSetting/jsp/homeInfoManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
