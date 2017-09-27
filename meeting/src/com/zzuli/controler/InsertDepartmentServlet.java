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
 * Servlet implementation class InsertDepartmentServlet
 */
public class InsertDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDepartmentServlet() {
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
		String departmentname = request.getParameter("departmentname");
		DepartmentService ds = new DepartmentServiceImplement();
		int result = 0;
		List<Department> dlist = null;
		
		try {
			result = ds.insertDepartment(departmentname);
			PrintWriter out = response.getWriter();
			String json = null;
			if(result != 0){
				dlist = ds.queryall();
				json = JSON.toJSONString(dlist);
				out.print(json);
				out.flush();
				out.close();
			}else{
				json = "this is not a json object";
				out.print(json);
				out.flush();
				out.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
