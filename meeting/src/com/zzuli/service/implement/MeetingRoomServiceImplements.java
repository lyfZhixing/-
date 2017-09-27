package com.zzuli.service.implement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zzuli.dao.MeetingRoomDao;
import com.zzuli.dao.implement.MeetingRoomDaoImplement;
import com.zzuli.entity.Meeting;
import com.zzuli.entity.Meetingparticipants;
import com.zzuli.entity.Meetingroom;
import com.zzuli.service.MeetingRoomService;
import com.zzuli.util.JDBCUtil;

public class MeetingRoomServiceImplements implements MeetingRoomService {

	@Override
	public int insertRoom(Meetingroom meetingroom) throws SQLException {
		int result = 0;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			MeetingRoomDao md = new MeetingRoomDaoImplement(conn);
			result = md.insertRoom(meetingroom);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public List<Meetingroom> queryall() throws SQLException {
		List<Meetingroom> meetingroomlist = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			MeetingRoomDao md = new MeetingRoomDaoImplement(conn);
			meetingroomlist = md.queryall();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return meetingroomlist;
	}

	@Override
	public Meetingroom querySingle(int mid) throws SQLException {
		Meetingroom meetingroom = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			MeetingRoomDao md = new MeetingRoomDaoImplement(conn);
			meetingroom = md.querySingle(mid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return meetingroom;
	}

	@Override
	public int update(Meetingroom meetingroom) throws SQLException {
		int result = 0;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			MeetingRoomDao md = new MeetingRoomDaoImplement(conn);
			result = md.update(meetingroom);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public boolean bookRoom(Meeting meeting, List<Meetingparticipants> mplist) {
		boolean flag = false; 
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			MeetingRoomDao md = new MeetingRoomDaoImplement(conn);
			conn.setAutoCommit(false);
			md.insertMeeting(meeting);
			int result = md.getLastId();
			for(Meetingparticipants mp : mplist){
				mp.setMeetingid(result);
				md.insertMeetingparticipants(mp);
			}
			conn.commit();
			flag = true;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return flag;
	}

	@Override
	public List<Meeting> searchMeeting(Object... keys) throws SQLException {
		List<Meeting> mlist = null;
		Connection conn = null;
		conn = JDBCUtil.getConnection();
		MeetingRoomDao mrd = new MeetingRoomDaoImplement(conn);
		try {
			mlist = mrd.searchMeeting(keys);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return mlist;
	}

}
