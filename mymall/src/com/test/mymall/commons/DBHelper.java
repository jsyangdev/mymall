package com.test.mymall.commons;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBHelper {
	private static SqlSessionFactory sqlSessionFactory;
	public static SqlSession getSqlSession() {
		InputStream inputStream = null;
		  try {
		   String resource = "mybatis-config.xml";
		   inputStream = Resources.getResourceAsStream(resource);
		  } catch (IOException e) {
			 e.printStackTrace();
		  }
		  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		  SqlSession sqlSession = sqlSessionFactory.openSession();

		  return sqlSession;		  
	}

	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		System.out.println("DBHelper.close() �ㅻ�濡��� - 1");
		if(rs != null) {try {rs.close();} catch(Exception e) {e.printStackTrace();}}
		if(stmt != null) {try {stmt.close();} catch(Exception e) {e.printStackTrace();}}
		if(conn != null) {try {conn.close();} catch(Exception e) {e.printStackTrace();}}
	}

}
