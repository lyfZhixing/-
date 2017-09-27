package com.zzuli.controler.approveaccount;

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
 * Servlet implementation class ApproveaccountServlet
 */
public class ApproveaccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveaccountServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String empidstr = request.getParameter("empid");
		int empid = 0;
		if(empidstr != null && !empidstr.equals("")){
			empid = Integer.parseInt(empidstr);
		}
		String status = "1";
		int result = 0;
		EmployeeService es = new EmployeeServiceImplement();
		List<Employee> emplist = null;
		
		try {
			result = es.updateStatus(status, empid);
			PrintWriter out = response.getWriter();
			if(result != 0){
				emplist = es.queryEmp("0",null,null);
				String json = JSON.toJSONString(emplist);
				out.print(json);
				out.flush();
				out.close();
			}else{
				out.print("出现问题啦，审核失败");
				out.flush();
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
