package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper2 {
	/**
	 * ???¼ì?´ë? ë¡???, DB?°ê²° ë©?????
	 * @return Connectionê°?ì²? ?µí?? ???±ë?? ???¼ë?°ì?? ë¦¬í??
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		System.out.println("DBHelper.getConnection()");
        Connection connection = null;
        String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
        String dbUser = "root";
        String dbPass = "java0000";
        // ???¼ì?´ë? ë¡???                            
        Class.forName("com.mysql.jdbc.Driver");
        // DB?°ê²°
        connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
        System.out.println(connection+"<--conn");
		return connection;
	}
	/**
	 * DB?? ??ê·¼í?????? ?¬ì?©ë?? ê°?ì²´ë?? ì¢?ë£? ë©?????
	 * @param rs
	 * @param stmt
	 * @param conn
	 * @throws SQLException
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		System.out.println("DBHelper.close() ?¤ë?ë¡??? - 1");
		if(rs != null) {try {rs.close();} catch(Exception e) {e.printStackTrace();}}
		if(stmt != null) {try {stmt.close();} catch(Exception e) {e.printStackTrace();}}
		if(conn != null) {try {conn.close();} catch(Exception e) {e.printStackTrace();}}
	}
	public static void close(Statement stmt, Connection conn) {
		System.out.println("DBHelper.close() ?¤ë?ë¡??? - 2");
		if(stmt != null) {try {stmt.close();} catch(Exception e) {e.printStackTrace();}}
		if(conn != null) {try {conn.close();} catch(Exception e) {e.printStackTrace();}}
	} 
}
