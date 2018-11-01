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
	 * 회원탈퇴 처리를 하는 메서드를 호출하는 서비스 계층의 메서드(서비스 계층이 있어야하는 실질적인 이유)
	 * RemoveMemberController에서 MemberService.removeMember() 호출
	 * @param no
	 */
	public void removeMember(int no) {
		System.out.println("MemberService.removeMember()");
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false); 	// 자동으로 커밋하지 않겠다.(커밋 잠구기)
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
	
	/**
	 * 한 명의 회원정보를 조회하는 메서드를 호출하는 서비스 계층의 메서드
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
	 * 로그인 처리를 하는 메서드를 호출하는 서비스 계층의 메서드
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
	 * 회원가입 메서드를 호출하는 서비스 계층의 메서드
	 * @param member
	 */
	public void addMember(Member member) {
		System.out.println("MemberService.addMember()");
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}
