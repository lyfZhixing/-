package com.zzuli.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zzuli.entity.Department;
import com.zzuli.service.DepartmentService;
import com.zzuli.service.implement.DepartmentServiceImplement;

/**
 * Servlet implementation class QueryDepartmentServlet
 */
public class QueryDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryDepartmentServlet() {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		DepartmentService ds = new DepartmentServiceImplement();
		List<Department> dlist = null;
		
		try {
			PrintWriter out = response.getWriter();
			String json = null;
			dlist = ds.queryall();
			json = JSON.toJSONString(dlist);
			out.print(json);
			out.flush();
			out.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
