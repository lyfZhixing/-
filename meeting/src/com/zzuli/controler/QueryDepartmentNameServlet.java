package com.zzuli.controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzuli.entity.Department;
import com.zzuli.service.DepartmentService;
import com.zzuli.service.implement.DepartmentServiceImplement;

/**
 * Servlet implementation class QueryDepartmentNameServlet
 */
public class QueryDepartmentNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryDepartmentNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentService ds = new DepartmentServiceImplement();
		List<Department> dlist = null;
		
		try {
			dlist = ds.queryall();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		request.setAttribute("dlist", dlist);
		request.getRequestDispatcher("jsp/register_imp.jsp").forward(request, response);;
	}

}
