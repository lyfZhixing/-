package com.zzuli.service.implement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzuli.dao.PersonalCenterDao;
import com.zzuli.dao.implement.PersonalCenterDaoImplement;
import com.zzuli.entity.Employee;
import com.zzuli.entity.Meeting;
import com.zzuli.service.PersonalCenterService;
import com.zzuli.util.JDBCUtil;

public class PersonalCenterServiceImplement implements PersonalCenterService {

	@Override
	public List<Meeting> needAttendMeeting(int empid, int date) throws SQLException {
		List<Meeting> meetinglist = new ArrayList<Meeting>();
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			PersonalCenterDao pd = new PersonalCenterDaoImplement(conn);
			meetinglist = pd.needAttendMeeting(empid, date);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		
		return meetinglist;
	}

	@Override
	public List<Meeting> cancleMeeting(int empid) throws SQLException {
		List<Meeting> meetinglist = new ArrayList<Meeting>();
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			PersonalCenterDao pd = new PersonalCenterDaoImplement(conn);
			meetinglist = pd.cancleMeeting(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		
		return meetinglist;
	}

	@Override
	public Meeting meetingInfo(int meetingid) throws SQLException {
		Meeting meeting = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			PersonalCenterDao pd = new PersonalCenterDaoImplement(conn);
			meeting = pd.meetingInfo(meetingid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return meeting;
	}

	@Override
	public List<Employee> participantInfo(int meetingid) throws SQLException {
		List<Employee> employeelist = new ArrayList<Employee>();
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			PersonalCenterDao pd = new PersonalCenterDaoImplement(conn);
			employeelist = pd.participantInfo(meetingid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return employeelist;
	}

	@Override
	public List<Meeting> myBooking(int empid) throws SQLException {
		List<Meeting> meetinglist = new ArrayList<Meeting>();
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			PersonalCenterDao pd = new PersonalCenterDaoImplement(conn);
			meetinglist = pd.myBooking(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		
		return meetinglist;
	}

	@Override
	public List<Meeting> myMeeting(int empid) throws SQLException {
		List<Meeting> meetinglist = new ArrayList<Meeting>();
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			PersonalCenterDao pd = new PersonalCenterDaoImplement(conn);
			meetinglist = pd.myMeeting(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		
		return meetinglist;
	}

	@Override
	public int cancleMeetings(String reason,int meetingid) throws SQLException {
		int result = 0;
		
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			PersonalCenterDao pd = new PersonalCenterDaoImplement(conn);
			result = pd.cancleMeetings(reason,meetingid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		
		return result;
	}

	
}
