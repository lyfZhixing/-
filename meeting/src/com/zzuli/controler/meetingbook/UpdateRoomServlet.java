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
 * Servlet implementation class UpdateRoomServlet
 */
public class UpdateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRoomServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String roomidstr = request.getParameter("roomid");
		int roomid = 0;
		if(roomidstr != null && !roomidstr.equals("")){
			roomid = Integer.parseInt(roomidstr);
		}
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
		Meetingroom meetingroom = new Meetingroom( roomid, roomnumber, capacity, roomcapacity, status, description);
		MeetingRoomService mrs = new MeetingRoomServiceImplements();
		int result = 0;
		try {
			result = mrs.update(meetingroom);
			if(result != 0){
				request.getRequestDispatcher("QuerryAllMeetingRoomServlet").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
