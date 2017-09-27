package com.zzuli.controler.meetingbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzuli.entity.Meetingroom;
import com.zzuli.service.MeetingRoomService;
import com.zzuli.service.implement.MeetingRoomServiceImplements;

/**
 * Servlet implementation class QuerrySingleServlet
 */
public class QuerrySingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuerrySingleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		MeetingRoomService ms = new MeetingRoomServiceImplements();
		Meetingroom mr = null;
		String midstr = request.getParameter("mid");
		int mid = 0;
		if(midstr != null && !midstr.equals("")){
			mid = Integer.parseInt(midstr);
		}
		try {
			mr = ms.querySingle(mid);
			request.setAttribute("mr", mr);
			request.getRequestDispatcher("jsp/roomdetails.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
