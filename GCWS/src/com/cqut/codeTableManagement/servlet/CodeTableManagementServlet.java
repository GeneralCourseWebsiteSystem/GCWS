package com.cqut.codeTableManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.codeTableManagement.entity.CodeTable;
import com.cqut.codeTableManagement.impl.CodeTableImpl;

/**
 * Servlet implementation class CodeTableManagementServlet
 */
@WebServlet("/CodeTableManagementServlet")
public class CodeTableManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeTableManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CodeTableImpl codeTableImpl = new CodeTableImpl();
		ArrayList<CodeTable> codeTables = codeTableImpl.getAllCodeTable();
		request.setAttribute("codeTableList", codeTables);
		request.getRequestDispatcher("/codeTableManagement/jsp/codeTableManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
