package com.zzuli.entity;

public class Employee {

	private int count;//记录查询出的记录数
	private int employeeid;
	private String employeename;
	private String username;
	private String phone;
	private String email;
	private String status = "0";//默认待审核：0
	private int departmentid;
	private String password;
	private String role = "2";//administrator:1,employee:2
	
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Employee() {
		super();
	}
	public Employee(String employeename, String username, String phone, String email, String status, int departmentid,
			String password, String role) {
		super();
		this.employeename = employeename;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.departmentid = departmentid;
		this.password = password;
		this.role = role;
	}
	public Employee(int employeeid, String employeename, String username, String phone, String email, String status,
			int departmentid, String password, String role) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.departmentid = departmentid;
		this.password = password;
		this.role = role;
	}
	public Employee(int count, int employeeid, String employeename, String username, String phone, String email,
			String status, int departmentid, String password, String role) {
		super();
		this.count = count;
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.departmentid = departmentid;
		this.password = password;
		this.role = role;
	}
	public Employee(String username, String phone, String email) {
		super();
		this.username = username;
		this.phone = phone;
		this.email = email;
	}
	public Employee(int employeeid, String status, String role) {
		super();
		this.employeeid = employeeid;
		this.status = status;
		this.role = role;
	}

	
	
	
}
