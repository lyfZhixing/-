package com.zzuli.entity;

public class Meetingroom {

	private int roomid;			//会议室编号
	private int roomnum;		//会议室门牌号
	private String roomname;	//会议室名称
	private int capacity;		//会议室容量
	private String status;		//状态0 停用1 启用 -1删除
	private String description;	//会议室描述
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Meetingroom(int roomid, int roomnum, String roomname, int capacity, String status, String description) {
		super();
		this.roomid = roomid;
		this.roomnum = roomnum;
		this.roomname = roomname;
		this.capacity = capacity;
		this.status = status;
		this.description = description;
	}
	public Meetingroom() {
		super();
	}

	
	
}
