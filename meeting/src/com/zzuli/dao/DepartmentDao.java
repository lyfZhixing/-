package com.zzuli.dao;

import java.sql.SQLException;
import java.util.List;

import com.zzuli.entity.Department;

public interface DepartmentDao {

	/**
	 * Query all infomation from department
	 * @return
	 * @throws SQLException
	 */
	List<Department> queryall() throws SQLException;
	/**
	 * 增加部门
	 * @return
	 * @throws SQLException
	 */
	int insertDepartment(String dname) throws SQLException;
	/**
	 * 更新部门
	 * @param department
	 * @return
	 * @throws SQLException
	 */
	int updateDepartment(Department department) throws SQLException;
	/**
	 * 删除部门
	 * @param did
	 * @return
	 * @throws SQLException
	 */
	int deleteDepartment(int did) throws SQLException;
	/**
	 * 查询单个部门信息
	 * @param did
	 * @return
	 * @throws SQLException
	 */
	Department queryDepartment(int did) throws SQLException;
}
