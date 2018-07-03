package com.cqut.codeTableManagement.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.codeTableManagement.entity.CodeTable;
import com.cqut.codeTableManagement.impl.CodeTableImpl;

/**
 * Servlet implementation class CodeTableManagementDetail
 */
@WebServlet("/CodeTableManagementDetail")
public class CodeTableManagementDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeTableManagementDetail() {
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
		String codeTableId = request.getParameter("codeTableId");
		CodeTableImpl codeTableImpl = new CodeTableImpl();
		CodeTable codeTable = codeTableImpl.getById(codeTableId);
		CodeTable parentCodeTable = new CodeTable();
		if(codeTable.getParentCode().equals("/") || codeTable.getParentCode() == null) {
			parentCodeTable = null;
		} else {
			parentCodeTable = codeTableImpl.getByPrarmCode(codeTable.getParentCode());
		}
		
		request.setAttribute("codeTable", codeTable);
		request.setAttribute("parentCodeTable", parentCodeTable);
		request.getRequestDispatcher("/codeTableManagement/jsp/codeTableManagementDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
