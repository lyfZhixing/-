package com.zzuli.controler.approveaccount;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzuli.entity.Employee;
import com.zzuli.service.EmployeeService;
import com.zzuli.service.implement.EmployeeServiceImplement;

/**
 * Servlet implementation class QueryEmployeeServlet
 */
public class QueryEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService es = new EmployeeServiceImplement();
		List<Employee> emplist = null;
		
		try {
			emplist = es.queryEmp("0",null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		request.setAttribute("emplist", emplist);
		request.getRequestDispatcher("jsp/approveaccount_imp.jsp").forward(request, response);;
	
	}

}
