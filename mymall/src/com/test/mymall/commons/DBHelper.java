package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBHelper {
	// DAO���� ����ϰ� �Ͼ�� �͵� ---> getConnection, close
	public static Connection getConnection() throws Exception{
		
		return null;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		
	} 
}
