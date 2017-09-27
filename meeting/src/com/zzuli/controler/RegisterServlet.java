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
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String status = "0";
		String role = "2";
		String employeename = request.getParameter("employeename");
		String accountname = request.getParameter("accountname");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String deptidstr = request.getParameter("deptid");
		int deptid = 0;
		if(deptidstr != null && !deptidstr.equals("")){
			deptid = Integer.parseInt(deptidstr);
		}
		Employee emp = new Employee(employeename, accountname, phone, email, status, deptid, password, role);
		EmployeeService es = new EmployeeServiceImplement();
		int result = 0;
		try {
			result = es.register(emp);
			PrintWriter out = response.getWriter();
			String json = null;
			if(result != 0){
				json = JSON.toJSONString("注册成功！");
			}else{
				json = JSON.toJSONString("注册失败！");
			}
			out.print(json);
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
