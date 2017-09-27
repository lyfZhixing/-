package com.zzuli.controler.searchemployees;

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
import com.zzuli.util.Paging;

/**
 * Servlet implementation class SearchemployeesServlet
 */
public class SearchemployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchemployeesServlet() {
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
		String empname = request.getParameter("empname").trim();
		
		String username = request.getParameter("username").trim();
		String status = request.getParameter("status");
		
		//总页码
		String pagemaxstr = request.getParameter("pagemax");//null
		int pagemax = 1;
		if(pagemaxstr != null && !pagemaxstr.equals("")){
			pagemax = Integer.parseInt(pagemaxstr);
		}
		//当前页码
		String pageindexstr = request.getParameter("pageindex");
		int pageindex = 1;
		if(pageindexstr != null && !pageindexstr.equals("")){
			if(Integer.parseInt(pageindexstr) > 0 && Integer.parseInt(pageindexstr) <= pagemax){
				pageindex = Integer.parseInt(pageindexstr);
			}else if(Integer.parseInt(pageindexstr) <= 0 ){
				pageindex = pagemax;
			}
		}
		//每页记录数
		int pagesize = 3;
		
		EmployeeService es = new EmployeeServiceImplement();
		List<Employee> emplist = null;
		
		
		try {
			emplist = es.searchEmp(empname,username,status,(pageindex-1)*pagesize,pagesize);
			int recordmax = 0;
			if(emplist.size()>0){
				recordmax = emplist.get(0).getCount();
			}
			
			Paging page = new Paging(pageindex,pagesize);
			page.setRecordmax(recordmax);
			page.setPagemax(pagesize, recordmax);
			page.setList(emplist);
			PrintWriter out = response.getWriter();
			String json = JSON.toJSONString(page);
			out.print(json);
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
