package com.cqut.homeInformationSetting.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.homeInformationSetting.entity.HomeProgram;
import com.cqut.homeInformationSetting.impl.HomeProgramImpl;

/**
 * Servlet implementation class HomeProgramUpdate
 */
@WebServlet("/HomeProgramUpdate")
public class HomeProgramUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeProgramUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String homeProgramId = request.getParameter("id");
		HomeProgramImpl homeProgramImpl = new HomeProgramImpl();
		HomeProgram homeProgram = homeProgramImpl.getById(homeProgramId);
		request.setAttribute("homeProgram", homeProgram);
		request.getRequestDispatcher("/homeInformationSetting/jsp/homeInfoManagementUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
