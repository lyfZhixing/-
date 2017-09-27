package com.zzuli.service;

import java.sql.SQLException;
import java.util.List;

import com.zzuli.entity.Meeting;
import com.zzuli.entity.Meetingparticipants;
import com.zzuli.entity.Meetingroom;

public interface MeetingRoomService {


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
	 * 预定会议室（对meeting和meetingparticipants做增加操作）
	 * @param meeting
	 * @param mp
	 * @return
	 */
	boolean bookRoom(Meeting meeting,List<Meetingparticipants> mplist);
	/**
	 * 模糊搜索会议信息
	 * @param keys
	 * @return
	 * @throws SQLException
	 */
  	List<Meeting> searchMeeting(Object...keys) throws SQLException;
}
