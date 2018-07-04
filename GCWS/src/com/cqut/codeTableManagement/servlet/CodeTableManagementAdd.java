package com.cqut.codeTableManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.codeTableManagement.entity.CodeTable;
import com.cqut.codeTableManagement.impl.CodeTableImpl;
import com.cqut.common.util.StringUtil;

/**
 * Servlet implementation class CodeTableManagementAdd
 */
@WebServlet("/CodeTableManagementAdd")
public class CodeTableManagementAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeTableManagementAdd() {
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
		CodeTable codeTable = new CodeTable();
		CodeTableImpl codeTableImpl = new CodeTableImpl();
		String lastCode = "";
		String paramName = request.getParameter("paramName");
		String paramText = request.getParameter("paramText");
		String parentCode = request.getParameter("parentCode");
		if(parentCode.equals("") || parentCode == null) {
			parentCode = null;
			ArrayList<CodeTable> list = codeTableImpl.getNullParentCode();
			if(list.size() == 0) {
				lastCode = "00001";
			} else {
				lastCode = list.get(list.size() - 1).getParamCode();
				lastCode = lastCode.substring(lastCode.length() - 5, lastCode.length());
				lastCode = StringUtil.addANumberByString(lastCode);
			}
		} else {
			ArrayList<CodeTable> parentChilds = codeTableImpl.getByParentCode(parentCode);
			if(parentChilds.size() == 0) {
				lastCode = "00001";
			} else {
				lastCode = parentChilds.get(parentChilds.size() - 1).getParamCode();
				lastCode = lastCode.substring(lastCode.length() - 5, lastCode.length());
				lastCode = StringUtil.addANumberByString(lastCode);
			}
		}
		if(parentCode != null) {
			lastCode = String.valueOf(parentCode) + "" + lastCode;
			codeTable.setParentCode(parentCode);
		}
		Byte hasChild = Byte.valueOf(request.getParameter("hasChild"));
		Integer level = Integer.valueOf(request.getParameter("level"));
		String remark = request.getParameter("remark");
		
		codeTable.setParamCode(lastCode);
		codeTable.setParamName(paramName);
		codeTable.setParamText(paramText);
		codeTable.setLevel(level);
		codeTable.setHasChild(hasChild);
		codeTable.setCreateTime(new Date());
		codeTable.setIsDelete(Byte.valueOf("0"));
		codeTable.setRemark(remark);
		codeTableImpl.addACodeTable(codeTable);
		request.getRequestDispatcher("CodeTableManagementServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
