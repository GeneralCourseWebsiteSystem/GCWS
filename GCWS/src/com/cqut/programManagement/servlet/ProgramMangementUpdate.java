package com.cqut.programManagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.programManagement.entity.Program;
import com.cqut.programManagement.impl.ProgramImpl;

/**
 * Servlet implementation class ProgramMangementUpdate
 */
@WebServlet("/ProgramMangementUpdate")
public class ProgramMangementUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramMangementUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String programId = request.getParameter("programId");
		ProgramImpl programImpl = new ProgramImpl();
		Program program = programImpl.getById(programId);
		request.setAttribute("program", program);
		request.getRequestDispatcher("/programManagement/jsp/programManagementUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
