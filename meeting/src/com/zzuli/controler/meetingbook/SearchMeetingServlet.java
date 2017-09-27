package com.zzuli.controler.meetingbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zzuli.entity.Meeting;
import com.zzuli.service.MeetingRoomService;
import com.zzuli.service.implement.MeetingRoomServiceImplements;
import com.zzuli.util.Paging;

/**
 * Servlet implementation class SearchMeetingServlet
 */
public class SearchMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMeetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		//meetingname LIKE ? AND roomname LIKE ? AND employeename LIKE ? AND starttime>? AND starttime<?AND endtime>? AND endtime<? LIMIT ?,?
		String meetingname = request.getParameter("meetingname");
		String roomname = request.getParameter("roomname");
		String employeename = request.getParameter("employeename");
		String starttime1str = request.getParameter("starttime1str");
		
		String starttime2str = request.getParameter("starttime2str");
		String endtime1str = request.getParameter("endtime1str");
		String endtime2str = request.getParameter("endtime2str");
		Date starttime1 = null;
		Date starttime2 = null;
		Date endtime1 = null;
		Date endtime2 = null;
		try {
			if(starttime1str != null && !starttime1str.equals("")){
				starttime1 = sdf.parse(starttime1str);
			}else{
				starttime1 = sdf.parse("01/01/1999");
			}
			if(starttime2str != null && !starttime2str.equals("")){
				starttime2 = sdf.parse(starttime2str);
			}else{
				starttime2 = sdf.parse("01/01/2999");
			}
			if(endtime1str != null && !endtime1str.equals("")){
				endtime1 = sdf.parse(endtime1str);
			}else{
				endtime1 = sdf.parse("01/01/1999");
			}
			if(endtime2str != null && !endtime2str.equals("")){
				endtime2 = sdf.parse(endtime2str);
			}else{
				endtime2 = sdf.parse("01/01/2999");
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//总 页码
		String pagemaxstr = request.getParameter("pagemax");
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
		
		MeetingRoomService mrs = new MeetingRoomServiceImplements();
		List<Meeting> mlist = null;
		Object[] keys = {meetingname,roomname,employeename,starttime1,starttime2,endtime1,endtime2,(pageindex-1)*pagesize,pagesize,};
		try {
			mlist = mrs.searchMeeting(keys);
			
			int recordmax = 0;
			if(mlist.size()>0){
				recordmax = mlist.get(0).getCount();
			}
			
			Paging page = new Paging(pageindex,pagesize);
			page.setRecordmax(recordmax);
			page.setPagemax(pagesize, recordmax);
			page.setList(mlist);
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
