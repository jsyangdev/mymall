package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBHelper {
	/**
	 * 드라이버 로딩, DB연결 메서드
	 * @return Connection객체 통해 생성된 레퍼런스 리턴
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		System.out.println("DBHelper.getConnection()");
        Connection connection = null;
        String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
        String dbUser = "root";
        String dbPass = "java0000";
        // 드라이버 로딩                              
        Class.forName("com.mysql.jdbc.Driver");
        // DB연결
        connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
        System.out.println(connection+"<--conn");
		return connection;
	}
	/**
	 * DB에 접근하는데 사용된 객체들 종료 메서드
	 * @param rs
	 * @param stmt
	 * @param conn
	 * @throws SQLException
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} 
}
