package com.zzuli.dao;

import java.sql.SQLException;
import java.util.List;

import com.zzuli.entity.Employee;
import com.zzuli.entity.Meeting;

public interface PersonalCenterDao {

	/**
	 * 查询最近要参加的会议
	 * @param empid
	 * @param date		
	 * @return
	 * @throws SQLException
	 */
	 List<Meeting> needAttendMeeting(int empid,int date) throws SQLException;
	 /**
	  * 查询已经取消的会议
	  * @param empid
	  * @return
	  * @throws SQLException
	  */
	 List<Meeting> cancleMeeting(int empid) throws SQLException;
	 /**
	  * 查询会议详情
	  * @param meetingid
	  * @return
	  * @throws SQLException
	  */
	 Meeting meetingInfo(int meetingid) throws SQLException;
	 /**
	  * 查询参会人员信息
	  * @param meetingid
	  * @return
	  * @throws SQLException
	  */
	 List<Employee> participantInfo(int meetingid)throws SQLException;
	 /**
	  * 我的预定
	  * @param empid
	  * @return
	  * @throws SQLException
	  */
	 List<Meeting> myBooking(int empid) throws SQLException;
	 /**
	  * 我将参加的所有会议
	  * @param empid
	  * @return
	  * @throws SQLException
	  */
	 List<Meeting> myMeeting(int empid) throws SQLException;
	 /**
	  * 撤销会议
	  * @param meetingid
	  * @return
	  * @throws SQLException
	  */
	 int cancleMeetings(String reason,int meetingid) throws SQLException;
}
