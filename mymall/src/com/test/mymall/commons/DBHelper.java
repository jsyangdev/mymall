package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBHelper {
	// DAO에서 빈번하게 일어나는 것들 ---> getConnection, close
	public static Connection getConnection() throws Exception{
		
		return null;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		
	} 
}
