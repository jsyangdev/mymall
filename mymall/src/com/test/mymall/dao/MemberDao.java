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
	 * ȸ�� Ż�� �޼���
	 * @param no
	 */
	public void deleteMember(Connection conn, int no) {
		
		
		
		
	}
	/**
	 * ȭ�鿡�� �Ѿ�� ����� DB�� ������ ���Ͽ� �α��� ���θ� �����ϴ� �޼���
	 * �α��� ���н� -> null
	 * �α��� ������ -> Member
	 * @param member
	 * @return
	 * @throws Exception 
	 */
	public Member login(Member member){
		System.out.println("MemberDao.login()");
		Member memberLogin = null;
		// Member vo�� ���õ� �� ������ ����
		String id = member.getId();
		String pw = member.getPw();
		// ����̹� �ε�, DB���� �޼��� ȣ��
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
	 * ����� ���Խ�Ű�� �޼���
	 * @param member
	 * @throws Exception
	 */
	public void insertMember(Member member) {
		System.out.println("MemberDao.insertMember()");
		// Member vo�� ���õ� �� ������ ����
		String id = member.getId();
		String pw = member.getPw();
		int level = member.getLevel();
		// ����̹� �ε�, DB���� �޼��� ȣ��
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
