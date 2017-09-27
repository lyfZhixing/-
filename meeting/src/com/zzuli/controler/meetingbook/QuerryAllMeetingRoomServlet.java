package com.zzuli.controler.meetingbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zzuli.entity.Meetingroom;
import com.zzuli.service.MeetingRoomService;
import com.zzuli.service.implement.MeetingRoomServiceImplements;

public class QuerryAllMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuerryAllMeetingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		MeetingRoomService ms = new MeetingRoomServiceImplements();
		List<Meetingroom> mlist = null;
		
		try {
			mlist = ms.queryall();
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("jsp/meetingrooms.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		MeetingRoomService ms = new MeetingRoomServiceImplements();
		List<Meetingroom> mlist = null;
		
		try {
			mlist = ms.queryall();
			PrintWriter out = response.getWriter();
			String json = JSON.toJSONString(mlist);
			out.print(json);
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
