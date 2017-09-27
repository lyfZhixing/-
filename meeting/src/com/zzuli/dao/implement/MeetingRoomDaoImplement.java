package com.zzuli.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzuli.dao.JDBCTemplate;
import com.zzuli.dao.MeetingRoomDao;
import com.zzuli.entity.Department;
import com.zzuli.entity.Employee;
import com.zzuli.entity.Meeting;
import com.zzuli.entity.Meetingparticipants;
import com.zzuli.entity.Meetingroom;
import com.zzuli.util.JDBCUtil;

public class MeetingRoomDaoImplement extends JDBCTemplate implements MeetingRoomDao {

	public MeetingRoomDaoImplement(Connection conn) {
		super(conn);
	}

	@Override
	public int insertRoom(Meetingroom meetingroom) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO meetingroom(roomnum,roomname,capacity,status,description) values (?,?,?,?,?)";
		Object[] params = {meetingroom.getRoomnum(),meetingroom.getRoomname(),meetingroom.getCapacity(),meetingroom.getStatus(),meetingroom.getDescription()};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Meetingroom> queryall() throws SQLException {
		List<Meetingroom> meetingroomlist = new ArrayList<Meetingroom>();
		Meetingroom meetingroom = null;
		ResultSet rs = null;
		String sql = "SELECT roomid,roomnum,roomname,capacity,status,description FROM meetingroom";
		try {
			rs = executeQuery(sql);
			while(rs.next()){
				meetingroom = new Meetingroom(rs.getInt("roomid"),rs.getInt("roomnum"), rs.getString("roomname"),rs.getInt("capacity"), rs.getString("status"), rs.getString("description"));
				meetingroomlist.add(meetingroom);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return meetingroomlist;
	}

	@Override
	public Meetingroom querySingle(int mid) throws SQLException {
		Meetingroom meetingroom = null;
		ResultSet rs = null;
		String sql = "SELECT roomid,roomnum,roomname,capacity,status,description FROM meetingroom WHERE roomid = ?";
		Object[] params = {mid};
		try {
			rs = executeQuery(sql,params);
			if(rs.next()){
				meetingroom = new Meetingroom(rs.getInt("roomid"),rs.getInt("roomnum"), rs.getString("roomname"),rs.getInt("capacity"), rs.getString("status"), rs.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return meetingroom;
	}

	@Override
	public int update(Meetingroom meetingroom) throws SQLException {
		int result = 0;
		String sql = "UPDATE meetingroom SET roomnum=?,roomname=?,capacity=?,status=?,description=? WHERE roomid=?";
		Object[] params = {meetingroom.getRoomnum(),meetingroom.getRoomname(),meetingroom.getCapacity(),meetingroom.getStatus(),meetingroom.getDescription(),meetingroom.getRoomid()};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertMeeting(Meeting meeting) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO meeting(meetingname,roomid,reservationistid,numberofparticipants,starttime,endtime,reservationtime,description,status)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] params = {meeting.getMeetingname(),meeting.getRoomid(),
							meeting.getReservationistid(),meeting.getNumberofparticipants(),
							meeting.getStarttime(),meeting.getEndtime(),meeting.getReservationtime(),
							meeting.getDescription(),meeting.getStatus()
							};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Department> queryAllDepartment() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMeetingparticipants(Meetingparticipants mp) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO meetingparticipants(meetingid,employeeid) VALUES(?,?)";
		Object[] params = {mp.getMeetingid(),mp.getEmployeeid()};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Meeting> searchMeeting(Object... keys) throws SQLException {
		List<Meeting> mlist = new ArrayList<Meeting>();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Meeting meeting = null;
		String sql1 = "SELECT t.* "+
					"FROM ("+
							"SELECT DISTINCT m.meetingid, m.meetingname,mr.roomname,m.starttime,m.endtime,m.reservationtime,e.employeename "+
							"FROM meeting m,meetingroom mr,meetingparticipants mp ,employee e "+
							"WHERE mp.meetingid=m.meetingid AND m.roomid=mr.roomid AND m.reservationistid=e.employeeid) t "+
					"WHERE meetingname LIKE ? AND roomname LIKE ? AND employeename LIKE ? AND starttime>? AND starttime<? AND endtime>? AND endtime<? LIMIT ?,?";
		
		
		String sql2 = "SELECT count(1) num "+
						"FROM ("+
							"SELECT DISTINCT m.meetingid, m.meetingname,mr.roomname,m.starttime,m.endtime,m.reservationtime,e.employeename "+
							"FROM meeting m,meetingroom mr,meetingparticipants mp ,employee e "+
							"WHERE mp.meetingid=m.meetingid AND m.roomid=mr.roomid AND m.reservationistid=e.employeeid) t "
							+ "WHERE meetingname LIKE ? AND roomname LIKE ? AND employeename LIKE ? AND starttime>? AND starttime<? AND endtime>? AND endtime<?";
		Object[] params1 = {"%"+keys[0]+"%","%"+keys[1]+"%","%"+keys[2]+"%",keys[3],
							keys[4],keys[5],keys[6],keys[7],keys[8]};
		Object[] params2 = {"%"+keys[0]+"%","%"+keys[1]+"%","%"+keys[2]+"%",keys[3],
							keys[4],keys[5],keys[6]};
		int count = 0;
		rs2 = executeQuery(sql2, params2);
		if(rs2.next()){
			count = rs2.getInt("num");
		}
		rs1 = executeQuery(sql1, params1);
		while(rs1.next()){
			meeting = new Meeting();
			
			meeting.setCount(count);
			meeting.setMeetingid(rs1.getInt("meetingid"));
			meeting.setMeetingname(rs1.getString("meetingname"));
			//
			
			Meetingroom mr = new Meetingroom();
			mr.setRoomname(rs1.getString("roomname"));
			meeting.setMeetingroom(mr);
			meeting.setStarttime(rs1.getTimestamp("starttime"));
			meeting.setEndtime(rs1.getTimestamp("endtime"));
			meeting.setReservationtime(rs1.getTimestamp("reservationtime"));
			//
			Employee emp = new Employee();
			emp.setEmployeename(rs1.getString("employeename"));
			meeting.setEmployee(emp);
			
			mlist.add(meeting);
			
		}
		
		return mlist;
	}

	@Override
	public int getLastId() throws SQLException {
		int result = 0;
		ResultSet rs = null;
		String sql = "select max(meetingid) id from meeting ";
		try {
			rs = executeQuery(sql);
			if(rs.next()){
				result = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return result;
	}

}
