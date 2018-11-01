package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		System.out.println("DBHelper.close() 오버로딩 - 1");
		if(rs != null) {try {rs.close();} catch(Exception e) {e.printStackTrace();}}
		if(stmt != null) {try {stmt.close();} catch(Exception e) {e.printStackTrace();}}
		if(conn != null) {try {conn.close();} catch(Exception e) {e.printStackTrace();}}
	}
	public static void close(Statement stmt, Connection conn) {
		System.out.println("DBHelper.close() 오버로딩 - 2");
		if(stmt != null) {try {stmt.close();} catch(Exception e) {e.printStackTrace();}}
		if(conn != null) {try {conn.close();} catch(Exception e) {e.printStackTrace();}}
	} 
}
