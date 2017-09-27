package com.zzuli.service.implement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zzuli.dao.DepartmentDao;
import com.zzuli.dao.implement.DepartmentDaoImplement;
import com.zzuli.entity.Department;
import com.zzuli.service.DepartmentService;
import com.zzuli.util.JDBCUtil;

public class DepartmentServiceImplement implements DepartmentService {

	
	@Override
	public List<Department> queryall() throws SQLException {
		List<Department> departmentList = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			DepartmentDao dd = new DepartmentDaoImplement(conn);
			departmentList = dd.queryall();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return departmentList;
	}

	@Override
	public int insertDepartment(String dname) throws SQLException {
		int result = 0;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			DepartmentDao dd = new DepartmentDaoImplement(conn);
			result = dd.insertDepartment(dname);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public int updateDepartment(Department department) throws SQLException {
		int result = 0;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			DepartmentDao dd = new DepartmentDaoImplement(conn);
			result = dd.updateDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public int deleteDepartment(int did) throws SQLException {
		int result = 0;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			DepartmentDao dd = new DepartmentDaoImplement(conn);
			result = dd.deleteDepartment(did);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public Department queryDepartment(int did) throws SQLException {
		Department department = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			DepartmentDao dd = new DepartmentDaoImplement(conn);
			department = dd.queryDepartment(did);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return department;
	}

}
