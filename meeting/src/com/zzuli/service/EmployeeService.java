package com.zzuli.service;

import java.sql.SQLException;
import java.util.List;

import com.zzuli.entity.Employee;

public interface EmployeeService {

	/**
	 * register employee
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	int register(Employee emp) throws SQLException;
	/**
	 * 根据状态查询员工
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	List<Employee> queryEmp(Object...status) throws SQLException;
	/**
	 * 根据id修改员工的审批状态
	 * @param status
	 * @param empid
	 * @return
	 * @throws SQLException
	 */
	int updateStatus(String status,int empid) throws SQLException;
	/**
	 * 根据id删除员工
	 * @param empid
	 * @return
	 * @throws SQLException
	 */
	int deleteEmpById(int empid)throws SQLException;
	/**
	 * 模糊搜索员工信息
	 * @param keys
	 * @return
	 * @throws SQLException
	 */
  	List<Employee> searchEmp(Object...keys) throws SQLException;
  	/**
  	 * 登录
  	 * @param uname
  	 * @param upwd
  	 * @return
  	 * @throws SQLException
  	 */
  	Employee login(String uname, String upwd) throws SQLException;
  	
	/**
  	 * 查询部门员工
  	 * @param did
  	 * @return
  	 * @throws SQLException
  	 */
  	List<Employee> queryEmpByDid(int did) throws SQLException;
  	/**
  	 * 根据id查信息
  	 * @param empid
  	 * @return
  	 * @throws SQLException
  	 */
  	Employee queryEmpById(int empid)throws SQLException;
	/**
  	 * 修改密码
  	 * @param empid
  	 * @param pwd
  	 * @return
  	 * @throws SQLException
  	 */
  	int changePwd(int empid,String pwd)throws SQLException;
  	/**
  	 * 查询所有
  	 * @return
  	 * @throws SQLException
  	 */
  	List<Employee> queryEmp() throws SQLException;
}
