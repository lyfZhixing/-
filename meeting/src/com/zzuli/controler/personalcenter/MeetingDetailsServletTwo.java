package com.zzuli.controler.personalcenter;

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
import com.zzuli.service.PersonalCenterService;
import com.zzuli.service.implement.PersonalCenterServiceImplement;

/**
 * Servlet implementation class MeetingDetailsServletTwo
 */
public class MeetingDetailsServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingDetailsServletTwo() {
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
		PersonalCenterService pcs = new PersonalCenterServiceImplement();
		String meetingidstr = request.getParameter("meetingid");
		int meetingid = 0;
		if(meetingidstr != null && !meetingidstr.equals("")){
			meetingid = Integer.parseInt(meetingidstr);
		}
		String json = null;
		try {
			List<Employee> employeelist = pcs.participantInfo(meetingid);//暂时写死
			json = JSON.toJSONString(employeelist);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
