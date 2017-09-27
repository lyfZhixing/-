package com.zzuli.controler.personalcenter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzuli.service.PersonalCenterService;
import com.zzuli.service.implement.PersonalCenterServiceImplement;

/**
 * Servlet implementation class CancleMeetingServlet
 */
public class CancleMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancleMeetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String meetingidstr = request.getParameter("meetingid");
		String canclereason = request.getParameter("description");
		int result = 0;
		int meetingid = 0;
		if(meetingidstr != null && !meetingidstr.equals("")){
			meetingid = Integer.parseInt(meetingidstr);
		}
		PersonalCenterService pcs = new PersonalCenterServiceImplement();
		try {
			result = pcs.cancleMeetings(canclereason,meetingid);
			if(result != 0){
				//response.sendRedirect("jsp/mybookings.jsp");
				request.getRequestDispatcher("jsp/mybookings.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
