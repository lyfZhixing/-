package com.zzuli.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.zzuli.dao.EmployeeDao;
import com.zzuli.dao.JDBCTemplate;
import com.zzuli.entity.Employee;
import com.zzuli.util.JDBCUtil;

public class EmployeeDaoImplement extends JDBCTemplate implements EmployeeDao {

	public EmployeeDaoImplement(Connection conn) {
		super(conn);
	}

	/**
	 * register employee
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	@Override
	public int register(Employee emp) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO employee(employeename,username,phone,email,status,departmentid,password,role) VALUES (?,?,?,?,?,?,?,?)";
		Object[] params = {emp.getEmployeename(),emp.getUsername(),emp.getPhone(),emp.getEmail(),
							emp.getStatus(),emp.getDepartmentid(),emp.getPassword(),emp.getRole()};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Employee> queryEmp(Object... status) throws SQLException {
		List<Employee> emplist = new ArrayList<Employee>();
		ResultSet rs = null;
		Employee emp = null;
		String sql = "SELECT employeeid,employeename,username,phone,email,status,departmentid,password,role FROM employee WHERE status in (?,?,?)";
		Object[] params = status;
		rs = executeQuery(sql, params);
		while(rs.next()){
			emp = new Employee(rs.getInt("employeeid"), rs.getString("employeename"),
					rs.getString("username"), rs.getString("phone"), 
					rs.getString("email"), rs.getString("status"), 
					rs.getInt("departmentid"), rs.getString("password"), rs.getString("role"));
			emplist.add(emp);
			
		}
		return emplist;
	}

	@Override
	public int updateStatus(String status,int empid) throws SQLException {
		int result = 0;
		String sql = "UPDATE employee SET status=? WHERE employeeid=?";
		Object[] params = {status,empid};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteEmpById(int empid) throws SQLException {
		int result = 0;
		String sql = "DELETE FROM employee WHERE employeeid=?";
		Object[] params = {empid};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Employee> searchEmp(Object... keys) throws SQLException {
		List<Employee> emplist = new ArrayList<Employee>();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Employee emp = null;
		String sql1 = "SELECT employeeid,employeename,username,phone,email,status,departmentid,password,role FROM employee WHERE employeename like ? AND username like ? AND status=? LIMIT ?,?";
		String sql2 = "SELECT COUNT(1) num FROM employee WHERE employeename like ? AND username like ? AND status=?";
		Object[] params1 = {"%"+keys[0]+"%","%"+keys[1]+"%",keys[2],keys[3],keys[4]};
		Object[] params2 = {"%"+keys[0]+"%","%"+keys[1]+"%",keys[2]};
		int count = 0;
		rs2 = executeQuery(sql2, params2);
		if(rs2.next()){
			count = rs2.getInt("num");
		}
		rs1 = executeQuery(sql1, params1);
		while(rs1.next()){
			emp = new Employee(count,rs1.getInt("employeeid"), rs1.getString("employeename"),
					rs1.getString("username"), rs1.getString("phone"), 
					rs1.getString("email"), rs1.getString("status"), 
					rs1.getInt("departmentid"), rs1.getString("password"), rs1.getString("role"));
			emplist.add(emp);
			
		}
		
		return emplist;
	}

	@Override
	public Employee login(String uname, String upwd) throws SQLException {
		Employee emp = null;
		String sql = "SELECT employeeid,status,role FROM employee WHERE username=? AND password=?";
		ResultSet rs = null;
		Object[] params = {uname,upwd};
		try {
			rs = executeQuery(sql, params);
			if(rs.next()){
				emp = new Employee(rs.getInt("employeeid"),rs.getString("status"),rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return emp;
	}

	@Override
	public List<Employee> queryEmpByDid(int did) throws SQLException {
		List<Employee> emplist = new ArrayList<Employee>();
		ResultSet rs = null;
		Employee emp = null;
		String sql = "SELECT e.employeeid,employeename,username,phone,email,status,e.departmentid,password,role FROM employee e,department d WHERE e.departmentid=d.departmentid AND d.departmentid=?";
		Object[] params = {did};
		try {
			rs = executeQuery(sql, params);
			while(rs.next()){
				emp = new Employee(rs.getInt("employeeid"), rs.getString("employeename"),
						rs.getString("username"), rs.getString("phone"), 
						rs.getString("email"), rs.getString("status"), 
						rs.getInt("departmentid"), rs.getString("password"), rs.getString("role"));
				emplist.add(emp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return emplist;
	}

	@Override
	public Employee queryEmpById(int empid) throws SQLException {
		ResultSet rs = null;
		Employee emp = null;
		String sql = "SELECT * FROM employee WHERE employeeid=?";
		Object[] params = {empid};
		try {
			rs = executeQuery(sql, params);
			if(rs.next()){
				emp = new Employee(rs.getInt("employeeid"), rs.getString("employeename"),
						rs.getString("username"), rs.getString("phone"), 
						rs.getString("email"), rs.getString("status"), 
						rs.getInt("departmentid"), rs.getString("password"), rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return emp;
	}

	@Override
	public int changePwd(int empid, String pwd) throws SQLException {
		int result = 0;
		String sql = "UPDATE employee SET password=? WHERE employeeid=?";
		Object[] params = {pwd,empid};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Employee> queryEmp() throws SQLException {
		List<Employee> emplist = new ArrayList<Employee>();
		ResultSet rs = null;
		Employee emp = null;
		String sql = "SELECT * FROM employee";
		try {
			rs = executeQuery(sql);
			while(rs.next()){
				emp = new Employee(rs.getInt("employeeid"), rs.getString("employeename"),
						rs.getString("username"), rs.getString("phone"), 
						rs.getString("email"), rs.getString("status"), 
						rs.getInt("departmentid"), rs.getString("password"), rs.getString("role"));
				emplist.add(emp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return emplist;
	}

}
