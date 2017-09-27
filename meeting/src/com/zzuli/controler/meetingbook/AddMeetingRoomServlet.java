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
 * Servlet implementation class AddMeetingRoomServlet
 */
public class AddMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMeetingRoomServlet() {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String roomnumberstr = request.getParameter("roomnumber");
		int roomnumber = 0;
		if(roomnumberstr != null && !roomnumberstr.equals("")){
			roomnumber = Integer.parseInt(roomnumberstr);
		}
		String capacity = request.getParameter("capacity");
		String roomcapacitystr = request.getParameter("roomcapacity");
		int roomcapacity = 0;
		if(roomcapacitystr != null && !roomcapacitystr.equals("")){
			roomcapacity = Integer.parseInt(roomcapacitystr);
		}
		String status = request.getParameter("status");
		String description = request.getParameter("description");
		Meetingroom meetingroom = new Meetingroom( 0, roomnumber, capacity, roomcapacity, status, description);
		MeetingRoomService mrs = new MeetingRoomServiceImplements();
		int result = 0;
		try {
			result = mrs.insertRoom(meetingroom);
			if(result != 0){
				response.sendRedirect("QuerryAllMeetingRoomServlet");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
