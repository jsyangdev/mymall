package com.test.mymall.service;


import java.sql.Connection;
import java.sql.SQLException;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao; 
	private MemberItemDao memberItemDao;
	/**
	 * ȸ��Ż�� ó���� �ϴ� �޼��带 ȣ���ϴ� ���� ������ �޼���(���� ������ �־���ϴ� �������� ����)
	 * RemoveMemberController���� MemberService.removeMember() ȣ��
	 * @param no
	 */
	public void removeMember(int no) {
		System.out.println("MemberService.removeMember()");
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false); 	// �ڵ����� Ŀ������ �ʰڴ�.(Ŀ�� �ᱸ��)
			// 1 function
			memberDao = new MemberDao();
			memberDao.deleteMember(conn, no);
			// 2 function
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(conn, no);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
	}
	
	// ȸ�������� �����ϴ� �޼��带 ȣ���ϴ� ���� ������ �޼���
	public Member updateMember(Member member) {
		System.out.println("MemberService.updateMember()");
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			memberDao = new MemberDao();
			memberDao.updateMember(conn, member);
		} catch(Exception e) {
			e.printStackTrace();	
		} finally {
			DBHelper.close(null, conn);
		}	
		return member;
	}
	
	/**
	 * �� ���� ȸ�������� ��ȸ�ϴ� �޼��带 ȣ���ϴ� ���� ������ �޼���
	 * @param memberNo
	 * @return member
	 */
	public Member selectMember(int memberNo) {
		System.out.println("MemberService.selectMember()");
		Member member = null;
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			memberDao = new MemberDao();
			member = memberDao.selectMember(conn, memberNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, conn);
		}
		return member;
				
	}
	/**
	 * �α��� ó���� �ϴ� �޼��带 ȣ���ϴ� ���� ������ �޼���
	 * @param member
	 * @return memberLogin
	 */
	public Member loginMember(Member member) {
		System.out.println("MemberService.loginMember()");	
		memberDao = new MemberDao();
		Member memberLogin = memberDao.login(member);
		return memberLogin;
	}
	/**
	 * ȸ������ �޼��带 ȣ���ϴ� ���� ������ �޼���
	 * @param member
	 */
	public void addMember(Member member) {
		System.out.println("MemberService.addMember()");
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}
