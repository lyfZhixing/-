package com.zzuli.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zzuli.entity.Employee;
import com.zzuli.service.EmployeeService;
import com.zzuli.service.implement.EmployeeServiceImplement;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		int employeeid = -1;
		Employee emp = null;
		EmployeeService es = new EmployeeServiceImplement();
		try {
			emp = es.login(uname, upwd);
			
			PrintWriter out = response.getWriter();
			String json = null;
			if(emp != null){
				employeeid = emp.getEmployeeid();
				request.getSession().setMaxInactiveInterval(200);
				request.getSession().setAttribute("uname", uname);
				request.getSession().setAttribute("session_status",emp.getStatus() );
				request.getSession().setAttribute("session_role",emp.getRole() );
				request.getSession().setAttribute("employeeid_session", employeeid);
				json = JSON.toJSONString(true);
				out.print(json);
				out.flush();
				out.close();
			}else{
				json = JSON.toJSONString(false);
				out.print(json);
				out.flush();
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
