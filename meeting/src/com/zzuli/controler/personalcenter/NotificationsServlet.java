package com.zzuli.controler.personalcenter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzuli.entity.Meeting;
import com.zzuli.service.PersonalCenterService;
import com.zzuli.service.implement.PersonalCenterServiceImplement;

/**
 * Servlet implementation class NotificationsServlet
 */
public class NotificationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		int empid = (int)request.getSession().getAttribute("employeeid_session");
		PersonalCenterService pcs = new PersonalCenterServiceImplement();
		try {
			List<Meeting> meetinglist = pcs.needAttendMeeting(empid, 7);//暂时写死
			request.setAttribute("meetinglist", meetinglist);
			request.getRequestDispatcher("jsp/notifications_imp.jsp").forward(request, response);;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
