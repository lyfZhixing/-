package com.zzuli.controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzuli.service.EmployeeService;
import com.zzuli.service.implement.EmployeeServiceImplement;

/**
 * Servlet implementation class ChangePwdServlet
 */
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String newpwd = request.getParameter("new");
		int empid = (int)request.getSession().getAttribute("employeeid_session");
		EmployeeService es = new EmployeeServiceImplement();
		int result = 0 ;
		try {
			result = es.changePwd(empid, newpwd);
			if(result != 0){
				response.sendRedirect("LoginOutServlet");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
