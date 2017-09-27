package com.zzuli.controler.personalcenter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzuli.entity.Meeting;
import com.zzuli.service.PersonalCenterService;
import com.zzuli.service.implement.PersonalCenterServiceImplement;

/**
 * Servlet implementation class MymeetingdetailServlet
 */
public class MymeetingdetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MymeetingdetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		PersonalCenterService pcs = new PersonalCenterServiceImplement();
		String meetingidstr = request.getParameter("meetingid");
		int meetingid = 0;
		if(meetingidstr != null && !meetingidstr.equals("")){
			meetingid = Integer.parseInt(meetingidstr);
		}
		try {
			Meeting meeting = pcs.meetingInfo(meetingid);//暂时写死
			meeting.setMeetingid(meetingid);
			request.setAttribute("meeting", meeting);
			request.getRequestDispatcher("jsp/mymeetingdetails.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
