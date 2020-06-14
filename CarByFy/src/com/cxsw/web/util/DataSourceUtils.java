package com.cxsw.web.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static DataSource ds=new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = tl.get();
		if(conn	== null){
			conn=ds.getConnection();
			
			tl.set(conn);
		}
		
		return conn;
	}
	
	public static void beginTransaction() throws SQLException{
		Connection conn = getConnection();
		
		conn.setAutoCommit(false);
	}
	
	
	public static void commitAndClose(){
		try {
			Connection conn = getConnection();
			
			if(conn != null){
				conn.commit();
			}
			
			closeConn(conn);
		} catch(Exception e){
			
		}
		
	}
	
	public static void rollbackAndClose(){
		try {
			Connection conn = getConnection();
			
			if(conn != null){
				conn.rollback();
			}
			
			closeConn(conn);
			
		} catch (SQLException e) {
			//
		}
	}
	
	public static void  closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
			tl.remove();
		} catch (Exception e) {
		}
		
		conn = null;
	}
}

