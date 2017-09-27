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
import com.zzuli.entity.Employee;
import com.zzuli.service.EmployeeService;
import com.zzuli.service.implement.EmployeeServiceImplement;

/**
 * Servlet implementation class CheckUserNameServlet
 */
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserNameServlet() {
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
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		EmployeeService es = new EmployeeServiceImplement();
		try {
			List<Employee> emplist = es.queryEmp();
			boolean flag = false;
			for(Employee emp : emplist){
				if(username.equals(emp.getUsername())){
					flag = true;
				}
			}
			
			PrintWriter out = response.getWriter();
			String json = JSON.toJSONString(flag);
			out.print(json);
			out.flush();
			out.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
