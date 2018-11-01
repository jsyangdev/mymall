package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	/**
	 * ����̹� �ε�, DB���� �޼���
	 * @return Connection��ü ���� ������ ���۷��� ����
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		System.out.println("DBHelper.getConnection()");
        Connection connection = null;
        String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
        String dbUser = "root";
        String dbPass = "java0000";
        // ����̹� �ε�                              
        Class.forName("com.mysql.jdbc.Driver");
        // DB����
        connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
        System.out.println(connection+"<--conn");
		return connection;
	}
	/**
	 * DB�� �����ϴµ� ���� ��ü�� ���� �޼���
	 * @param rs
	 * @param stmt
	 * @param conn
	 * @throws SQLException
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		System.out.println("DBHelper.close() �����ε� - 1");
		if(rs != null) {try {rs.close();} catch(Exception e) {e.printStackTrace();}}
		if(stmt != null) {try {stmt.close();} catch(Exception e) {e.printStackTrace();}}
		if(conn != null) {try {conn.close();} catch(Exception e) {e.printStackTrace();}}
	}
	public static void close(Statement stmt, Connection conn) {
		System.out.println("DBHelper.close() �����ε� - 2");
		if(stmt != null) {try {stmt.close();} catch(Exception e) {e.printStackTrace();}}
		if(conn != null) {try {conn.close();} catch(Exception e) {e.printStackTrace();}}
	} 
}
