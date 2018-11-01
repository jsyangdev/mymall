package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	/**
	 * 회원 탈퇴 메서드
	 * @param no
	 */
	public void deleteMember(Connection conn, int no) {
		
		
		
		
	}
	/**
	 * 화면에서 넘어온 값들과 DB내 값들을 비교하여 로그인 여부를 결정하는 메서드
	 * 로그인 실패시 -> null
	 * 로그인 성공시 -> Member
	 * @param member
	 * @return
	 * @throws Exception 
	 */
	public Member login(Member member){
		System.out.println("MemberDao.login()");
		Member memberLogin = null;
		// Member vo에 셋팅된 값 가지고 오기
		String id = member.getId();
		String pw = member.getPw();
		// 드라이버 로딩, DB연결 메서드 호출
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT no, id, level FROM member WHERE id='"+id+"' AND pw='"+pw+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				memberLogin = new Member();
				memberLogin.setNo(rs.getInt("no"));
				memberLogin.setId(rs.getString("id"));
				memberLogin.setLevel(rs.getInt("level"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}	
		return memberLogin;
		}
	/**
	 * 멤버를 가입시키는 메서드
	 * @param member
	 * @throws Exception
	 */
	public void insertMember(Member member) {
		System.out.println("MemberDao.insertMember()");
		// Member vo에 셋팅된 값 가지고 오기
		String id = member.getId();
		String pw = member.getPw();
		int level = member.getLevel();
		// 드라이버 로딩, DB연결 메서드 호출
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.createStatement();
			String sql = "INSERT INTO member(id, pw, level) VALUES("+id+","+pw+","+level+")";
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}	
	}
}
