package com.zzuli.entity;

public class Meetingparticipants {

	private int meetingid;	//会议编号
	private int employeeid;	//员工id
	public int getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public Meetingparticipants(int employeeid) {
		super();
		this.employeeid = employeeid;
	}
	public Meetingparticipants() {
		super();
	}
	

}
