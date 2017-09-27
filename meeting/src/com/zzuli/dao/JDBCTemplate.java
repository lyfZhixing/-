package com.zzuli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzuli.util.JDBCUtil;

public class JDBCTemplate {

	private Connection conn;

	public JDBCTemplate(Connection conn) {
		super();
		this.conn = conn;
	}
	/**
	 * Insert,update,delete template
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	protected int executeUpdate(String sql , Object...params) throws SQLException{
		int result = 0;
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			if(params != null){
				for(int i = 0; i < params.length; i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, pstmt, null);
		}
		return result;
	}
	
	/**
	 * Query template
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeQuery(String sql, Object...params){
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
	
		try {
			pstmt = conn.prepareStatement(sql);
			if(params != null){
				for(int i = 0; i < params.length; i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
