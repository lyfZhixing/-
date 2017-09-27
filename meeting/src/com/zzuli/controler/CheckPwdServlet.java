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
 * Servlet implementation class CheckPwdServlet
 */
public class CheckPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String empidstr = request.getParameter("empid").trim();
		int empid = 0;
		if(empidstr != null && !empidstr.equals("")){
			empid = Integer.parseInt(empidstr);
		}
		String opwd = request.getParameter("opwd").trim();
		Employee emp = null;
		
		EmployeeService es = new EmployeeServiceImplement();
		
		try {
			emp = es.queryEmpById(empid);
			PrintWriter out = response.getWriter();
			String pwd = emp.getPassword();
			String json = null;
			if(opwd.equals(pwd)){
				json = JSON.toJSONString("true");
				out.print(json);
				out.flush();
				out.close();
			}else{
				json = JSON.toJSONString("false");
				out.print(json);
				out.flush();
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
