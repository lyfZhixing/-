package com.zzuli.controler.meetingbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zzuli.entity.Meeting;
import com.zzuli.entity.Meetingparticipants;
import com.zzuli.service.MeetingRoomService;
import com.zzuli.service.implement.MeetingRoomServiceImplements;

/**
 * Servlet implementation class MeetingBookServlet
 */
public class MeetingBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingBookServlet() {
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
		//meetingname,roomid,reservationistid,numberofparticipants,starttime,endtime,reservationtime,description,status
		String meetingname = request.getParameter("meetingname");
		String roomidstr = request.getParameter("roomid");
		int roomid = 0;
		if(roomidstr != null && !roomidstr.equals("")){
			roomid = Integer.parseInt(roomidstr);
		}
		int reservationistid = (int)request.getSession().getAttribute("employeeid_session");
		//System.out.println(reservationistid);
		String starttimestr = request.getParameter("starttime");
		System.out.println(starttimestr);
		String endtimestr = request.getParameter("endtime");
		System.out.println(starttimestr);
		//  6/1/2012 12:30
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date starttime = null;
		Date endtime = null;
		try {
			if(starttimestr != null && !starttimestr.equals("")){
				starttime = sdf.parse(starttimestr);
				System.out.println(starttime.toString());
			}
			if(endtimestr != null && !endtimestr.equals("")){
				endtime = sdf.parse(endtimestr);
				System.out.println(endtimestr.toString());
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		String description = request.getParameter("description");
		Date reservationtime = new Date();
		String emp = request.getParameter("emps");
		String[] emplist = emp.split(",");
//		String[] emplist = request.getParameterValues("emps");
		int numberofparticipants = emplist.length;
		String status = "0";
		
		Meeting meeting = new Meeting(meetingname, starttime, endtime, null);
		meeting.setRoomid(roomid);
		meeting.setReservationistid(reservationistid);
		meeting.setDescription(description);
		meeting.setReservationtime(reservationtime);
		meeting.setStatus(status);
		meeting.setNumberofparticipants(numberofparticipants);
		MeetingRoomService mrs = new MeetingRoomServiceImplements();
		List<Meetingparticipants> mplist = new ArrayList<Meetingparticipants>();
		Meetingparticipants mp = null;
		for(String x : emplist){
			if(x != null && !x.equals("")){
				int empid = Integer.parseInt(x);
				mp = new Meetingparticipants(empid);
				mplist.add(mp);
			}
			
		}
		
		try {
			mrs.bookRoom(meeting, mplist);
			PrintWriter out = response.getWriter();
			String json = JSON.toJSONString(true);
			out.print(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
