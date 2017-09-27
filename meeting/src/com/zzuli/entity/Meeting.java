package com.zzuli.entity;

import java.util.Date;

public class Meeting {

	private int count;
	private int meetingid;				//会议编号
	private String meetingname;			//会议名称
	private int roomid;					//会议室编号
	private int reservationistid;		//预定者id
	private int numberofparticipants;	//参会人数
	private Date starttime;				
	private Date endtime;
	private Date reservationtime;		//预定时间
	private Date canceledtime;			//撤销时间
	private String cancledreason;
	private String description;			//会议描述
	private String status;				//会议状态  1撤销
	private Meetingroom meetingroom;	//会议室信息
	private Employee employee;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getCancledreason() {
		return cancledreason;
	}
	public void setCancledreason(String cancledreason) {
		this.cancledreason = cancledreason;
	}
	public Meetingroom getMeetingroom() {
		return meetingroom;
	}
	public void setMeetingroom(Meetingroom meetingroom) {
		this.meetingroom = meetingroom;
	}
	public int getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}
	public String getMeetingname() {
		return meetingname;
	}
	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public int getReservationistid() {
		return reservationistid;
	}
	public void setReservationistid(int reservationistid) {
		this.reservationistid = reservationistid;
	}
	public int getNumberofparticipants() {
		return numberofparticipants;
	}
	public void setNumberofparticipants(int numberofparticipants) {
		this.numberofparticipants = numberofparticipants;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Date getReservationtime() {
		return reservationtime;
	}
	public void setReservationtime(Date reservationtime) {
		this.reservationtime = reservationtime;
	}
	public Date getCanceledtime() {
		return canceledtime;
	}
	public void setCanceledtime(Date canceledtime) {
		this.canceledtime = canceledtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Meeting() {
		super();
	}
	/**
	 * 查询最近未开会议的构造方法
	 * @param meetingname
	 * @param starttime
	 * @param endtime
	 * @param meetingroom
	 */
	public Meeting(String meetingname, Date starttime, Date endtime, Meetingroom meetingroom) {
		super();
		this.meetingname = meetingname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.meetingroom = meetingroom;
	}
	/**
	 * 查询已撤销会议的构造方法
	 * @param meetingname
	 * @param starttime
	 * @param endtime
	 * @param cancledreason
	 * @param meetingroom
	 */
	public Meeting(String meetingname, Date starttime, Date endtime, String cancledreason, Meetingroom meetingroom) {
		super();
		this.meetingname = meetingname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.cancledreason = cancledreason;
		this.meetingroom = meetingroom;
	}
	public Meeting(String meetingname, int numberofparticipants, Date starttime, Date endtime, String description) {
		super();
		this.meetingname = meetingname;
		this.numberofparticipants = numberofparticipants;
		this.starttime = starttime;
		this.endtime = endtime;
		this.description = description;
	}
	/**
	 * 查询所有的信息
	 * @param count
	 * @param meetingid
	 * @param meetingname
	 * @param roomid
	 * @param reservationistid
	 * @param numberofparticipants
	 * @param starttime
	 * @param endtime
	 * @param reservationtime
	 * @param canceledtime
	 * @param cancledreason
	 * @param description
	 * @param status
	 * @param meetingroom
	 * @param employee
	 */
	public Meeting(int count, int meetingid, String meetingname, int roomid, int reservationistid,
			int numberofparticipants, Date starttime, Date endtime, Date reservationtime, Date canceledtime,
			String cancledreason, String description, String status, Meetingroom meetingroom, Employee employee) {
		super();
		this.count = count;
		this.meetingid = meetingid;
		this.meetingname = meetingname;
		this.roomid = roomid;
		this.reservationistid = reservationistid;
		this.numberofparticipants = numberofparticipants;
		this.starttime = starttime;
		this.endtime = endtime;
		this.reservationtime = reservationtime;
		this.canceledtime = canceledtime;
		this.cancledreason = cancledreason;
		this.description = description;
		this.status = status;
		this.meetingroom = meetingroom;
		this.employee = employee;
	}

	
	
	
}
