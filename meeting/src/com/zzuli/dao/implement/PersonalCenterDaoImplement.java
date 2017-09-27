package com.zzuli.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzuli.dao.JDBCTemplate;
import com.zzuli.dao.PersonalCenterDao;
import com.zzuli.entity.Employee;
import com.zzuli.entity.Meeting;
import com.zzuli.entity.Meetingroom;
import com.zzuli.util.JDBCUtil;

public class PersonalCenterDaoImplement extends JDBCTemplate implements PersonalCenterDao {

	public PersonalCenterDaoImplement(Connection conn) {
		super(conn);
	}

	@Override
	public List<Meeting> needAttendMeeting(int empid,int date) throws SQLException {

		List<Meeting> meetinglist = new ArrayList<Meeting>();
		ResultSet rs = null;
		Meeting meeting = null;
		String sql = "SELECT m.meetingid, m.meetingname,mr.roomname,m.starttime,m.endtime FROM meeting m,meetingroom mr,meetingparticipants mp WHERE "
				+ "mp.meetingid=m.meetingid AND m.roomid=mr.roomid AND mp.employeeid=? AND (TO_DAYS(m.starttime)-TO_DAYS(NOW())) <= ? AND (TO_DAYS(m.starttime)-TO_DAYS(NOW())) >= 0 AND m.status='0'";
		Object[] params = {empid,date};
		try {
			rs = executeQuery(sql, params);
			while(rs.next()){
				String roomname = rs.getString("roomname");
				Meetingroom mr = new Meetingroom();
				mr.setRoomname(roomname);
				meeting = new Meeting(rs.getString("meetingname"), rs.getTimestamp("starttime"), rs.getTimestamp("endtime"), mr);
				meeting.setMeetingid(rs.getInt("meetingid"));
				meetinglist.add(meeting);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return meetinglist;
	}

	@Override
	public List<Meeting> cancleMeeting(int empid) throws SQLException {
		List<Meeting> meetinglist = new ArrayList<Meeting>();
		ResultSet rs = null;
		Meeting meeting = null;
		String sql = "SELECT m.meetingid, m.meetingname,mr.roomname,m.starttime,m.endtime,m.cancledreason FROM meeting m,meetingroom mr,meetingparticipants mp WHERE "
				+ "mp.meetingid=m.meetingid AND m.roomid=mr.roomid AND mp.employeeid=? AND m.status='1'";
		Object[] params = {empid};
		try {
			rs = executeQuery(sql, params);
			while(rs.next()){
				String roomname = rs.getString("roomname");
				Meetingroom mr = new Meetingroom();
				mr.setRoomname(roomname);
				meeting = new Meeting(rs.getString("meetingname"), rs.getTimestamp("starttime"), rs.getTimestamp("endtime"),rs.getString("cancledreason"), mr);
				meeting.setMeetingid(rs.getInt("meetingid"));
				meetinglist.add(meeting);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return meetinglist;
	}

	@Override
	public Meeting meetingInfo(int meetingid) throws SQLException {
		ResultSet rs = null;
		Meeting meeting = null;
		String sql = "SELECT meetingname,numberofparticipants,starttime,endtime,description FROM meeting WHERE meetingid=?";
		Object[] params = {meetingid};
		try {
			rs = executeQuery(sql, params);
			if(rs.next()){
				meeting = new Meeting(rs.getString("meetingname"),rs.getInt("numberofparticipants"), rs.getTimestamp("starttime"), rs.getTimestamp("endtime"), rs.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return meeting;
	}

	@Override
	public List<Employee> participantInfo(int meetingid) throws SQLException {
		ResultSet rs = null;
		List<Employee> employeelist = new ArrayList<Employee>();
		Employee employee = null;
		String sql = "SELECT username,phone,email FROM employee e,meetingparticipants mp WHERE mp.employeeid=e.employeeid AND mp.meetingid=?";
		Object[] params = {meetingid};
		try {
			rs = executeQuery(sql, params);
			while(rs.next()){
				employee = new Employee(rs.getString("username"), rs.getString("phone"), rs.getString("email"));
				employeelist.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return employeelist;
	}

	@Override
	public List<Meeting> myBooking(int empid) throws SQLException {
		List<Meeting> meetinglist = new ArrayList<Meeting>();
		ResultSet rs = null;
		Meeting meeting = null;
		String sql = "SELECT meetingid,meetingname,mr.roomname,starttime,endtime,reservationtime FROM meeting m,meetingroom mr WHERE m.roomid=mr.roomid AND reservationistid=?  AND m.status='0'";
		Object[] params = {empid};
		try {
			rs = executeQuery(sql, params);
			while(rs.next()){
				String roomname = rs.getString("roomname");
				Meetingroom mr = new Meetingroom();
				mr.setRoomname(roomname);
				meeting = new Meeting(rs.getString("meetingname"), rs.getTimestamp("starttime"), rs.getTimestamp("endtime"),null, mr);
				meeting.setMeetingid(rs.getInt("meetingid"));
				meeting.setReservationtime(rs.getTimestamp("reservationtime"));
				meetinglist.add(meeting);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return meetinglist;
	}

	@Override
	public List<Meeting> myMeeting(int empid) throws SQLException {
		List<Meeting> meetinglist = new ArrayList<Meeting>();
		ResultSet rs = null;
		Meeting meeting = null;
		String sql = "SELECT m.meetingid,meetingname,mr.roomname,starttime,endtime,reservationtime,employeename FROM meeting m,meetingroom mr,meetingparticipants mp,employee e WHERE m.roomid=mr.roomid AND m.reservationistid=e.employeeid AND m.meetingid=mp.meetingid AND mp.employeeid=?  AND m.status='0'";
		Object[] params = {empid};
		try {
			rs = executeQuery(sql, params);
			while(rs.next()){
				String employeename = rs.getString("employeename");
				Employee employee = new Employee();
				employee.setEmployeename(employeename);
				String roomname = rs.getString("roomname");
				Meetingroom mr = new Meetingroom();
				mr.setRoomname(roomname);
				meeting = new Meeting(rs.getString("meetingname"), rs.getTimestamp("starttime"), rs.getTimestamp("endtime"),null, mr);
				meeting.setMeetingid(rs.getInt("meetingid"));
				meeting.setReservationtime(rs.getTimestamp("reservationtime"));
				meeting.setEmployee(employee);
				meetinglist.add(meeting);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return meetinglist;
	}

	@Override
	public int cancleMeetings( String reason,int meetingid) throws SQLException {
		int result = 0;
		String sql = "UPDATE meeting SET status=1,cancledreason=? WHERE meetingid=? ";
		Object[] params = {reason,meetingid};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
