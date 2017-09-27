package com.zzuli.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzuli.dao.DepartmentDao;
import com.zzuli.dao.JDBCTemplate;
import com.zzuli.entity.Department;
import com.zzuli.util.JDBCUtil;

public class DepartmentDaoImplement extends JDBCTemplate implements DepartmentDao {

	public DepartmentDaoImplement(Connection conn) {
		super(conn);
	}

	/**
	 * query * from department
	 */
	@Override
	public List<Department> queryall() throws SQLException {
		List<Department> departmentList = new ArrayList<Department>();
		Department department = null;
		ResultSet rs = null;
		String sql = "SELECT departmentid,departmentname FROM department";
		try {
			rs = executeQuery(sql);
			while(rs.next()){
				department = new Department(rs.getInt("departmentid"), rs.getString("departmentname"));
				departmentList.add(department);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return departmentList;
	}

	@Override
	public int insertDepartment(String dname) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO department(departmentname) values (?)";
		Object[] params = {dname};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateDepartment(Department department) throws SQLException {
		int result = 0;
		String sql = "UPDATE department SET departmentname=? WHERE departmentid=?";
		Object[] params = {department.getDepartmentname(),department.getDepartmentid()};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteDepartment(int did) throws SQLException {
		int result = 0;
		String sql = "DELETE FROM department WHERE departmentid=?";
		Object[] params = {did};
		try {
			result = executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Department queryDepartment(int did) throws SQLException {
		Department department = null;
		ResultSet rs = null;
		String sql = "SELECT departmentid,departmentname FROM department WHERE departmentid = ?";
		Object[] params = {did};
		try {
			rs = executeQuery(sql,params);
			if(rs.next()){
				department = new Department(rs.getInt("departmentid"), rs.getString("departmentname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return department;
	}

}
