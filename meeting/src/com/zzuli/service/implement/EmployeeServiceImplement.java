package com.zzuli.service.implement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zzuli.dao.EmployeeDao;
import com.zzuli.dao.implement.EmployeeDaoImplement;
import com.zzuli.entity.Employee;
import com.zzuli.service.EmployeeService;
import com.zzuli.util.JDBCUtil;

public class EmployeeServiceImplement implements EmployeeService {

	/**
	 * register employee
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	@Override
	public int register(Employee emp) throws SQLException {
		int result = 0;
		
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			EmployeeDao ed = new EmployeeDaoImplement(conn);
			result = ed.register(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		
		return result;
	}

	@Override
	public List<Employee> queryEmp(Object... status) throws SQLException {

		List<Employee> emplist = null;
		Connection conn = null;
		conn = JDBCUtil.getConnection();
		EmployeeDao ed = new EmployeeDaoImplement(conn);
		try {
			emplist = ed.queryEmp(status);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return emplist;
	}

	@Override
	public int updateStatus(String status, int empid) throws SQLException {
		int result = 0;
		
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			EmployeeDao ed = new EmployeeDaoImplement(conn);
			result = ed.updateStatus(status, empid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		
		return result;
	}

	@Override
	public int deleteEmpById(int empid) throws SQLException {
		int result = 0;
		
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			EmployeeDao ed = new EmployeeDaoImplement(conn);
			result = ed.deleteEmpById(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		
		return result;
	}

	@Override
	public List<Employee> searchEmp(Object... keys) throws SQLException {
		List<Employee> emplist = null;
		Connection conn = null;
		conn = JDBCUtil.getConnection();
		EmployeeDao ed = new EmployeeDaoImplement(conn);
		try {
			emplist = ed.searchEmp(keys);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return emplist;
	}

	@Override
	public Employee login(String uname, String upwd) throws SQLException {
		Employee emp = null;
		Connection conn = null;
		conn = JDBCUtil.getConnection();
		EmployeeDao ed = new EmployeeDaoImplement(conn);
		try {
			emp = ed.login(uname, upwd);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return emp;
	}

	@Override
	public List<Employee> queryEmpByDid(int did) throws SQLException {
		List<Employee> emplist = null;
		Connection conn = null;
		conn = JDBCUtil.getConnection();
		EmployeeDao ed = new EmployeeDaoImplement(conn);
		try {
			emplist = ed.queryEmpByDid(did);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return emplist;
	}

	@Override
	public Employee queryEmpById(int empid) throws SQLException {
		Employee emp = null;
		Connection conn = null;
		conn = JDBCUtil.getConnection();
		EmployeeDao ed = new EmployeeDaoImplement(conn);
		try {
			emp = ed.queryEmpById(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return emp;
	}

	@Override
	public int changePwd(int empid, String pwd) throws SQLException {
		int result = 0;
		Connection conn = null;
		conn = JDBCUtil.getConnection();
		EmployeeDao ed = new EmployeeDaoImplement(conn);
		try {
			result = ed.changePwd(empid, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Employee> queryEmp() throws SQLException {
		List<Employee> emplist = null;
		Connection conn = null;
		conn = JDBCUtil.getConnection();
		EmployeeDao ed = new EmployeeDaoImplement(conn);
		try {
			emplist = ed.queryEmp();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return emplist;
	}
}
