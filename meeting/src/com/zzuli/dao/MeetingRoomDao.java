package com.zzuli.dao;

import java.sql.SQLException;
import java.util.List;

import com.zzuli.entity.Department;
import com.zzuli.entity.Meeting;
import com.zzuli.entity.Meetingparticipants;
import com.zzuli.entity.Meetingroom;

public interface MeetingRoomDao {

	/**
	 * 添加会议室信息
	 * @return
	 * @throws SQLException
	 */
	int insertRoom(Meetingroom meetingroom) throws SQLException;
	/**
	 * 查询所有会议室信息
	 * @return
	 * @throws SQLException
	 */
	List<Meetingroom> queryall() throws SQLException;
	/**
	 * 查询单个会议室详细信息
	 * @return
	 * @throws SQLException
	 */
	Meetingroom querySingle(int mid) throws SQLException;
	/**
	 * 修改会议室详细信息
	 * @param mid
	 * @return
	 * @throws SQLException
	 */
	int update(Meetingroom meetingroom) throws SQLException;
	/**
	 * 添加预定会议信息
	 * @param meeting
	 * @return
	 * @throws SQLException
	 */
	int insertMeeting(Meeting meeting)throws SQLException;
	/**
	 * 查询所有部门信息
	 * @return
	 * @throws SQLException
	 */
	List<Department> queryAllDepartment()throws SQLException; 
	/**
	 * 添加会议和人员对照表
	 * @param mp
	 * @return
	 * @throws SQLException
	 */
	int insertMeetingparticipants (Meetingparticipants mp) throws SQLException;
	/**
	 * 模糊搜索会议信息
	 * @param keys
	 * @return
	 * @throws SQLException
	 */
  	List<Meeting> searchMeeting(Object...keys) throws SQLException;
  	/**
  	 * 获取最后添加的id
  	 */
  	int getLastId()throws SQLException;
}
