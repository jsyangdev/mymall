package com.test.mymall.service;


import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

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
		SqlSession sqlSession = DBHelper.getSqlSession();
		// 1 function
		memberDao = new MemberDao();
		memberDao.deleteMember(sqlSession, no);
		// 2 function
		memberItemDao = new MemberItemDao();
/*		
		try {
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
		}*/
	}
	/**
	 * 회원탈퇴 전, 비번 확인을 위한 메서드를 호출하는 서비스 계층의 메서드
	 * @param member
	 * @return
	 */
	public int selectMemberForRemove(Member member) {
		System.out.println("MemberService.selectMemberForRemove()");
		SqlSession sqlSession = DBHelper.getSqlSession();	// 통일성을 위해 서비스에서 getSqlSession() 호출
		memberDao = new MemberDao();
		int resultNo = memberDao.selectMemberForpasswordCheckBeforeRemove(sqlSession, member);

		return resultNo;
	}
	/**
	 *  회원정보를 수정하는 메서드를 호출하는 서비스 계층의 메서드
	 * @param member
	 * @return
	 */
	public void updateMember(Member member) {
		System.out.println("MemberService.updateMember()");
		SqlSession sqlSession = DBHelper.getSqlSession();	// 통일성을 위해 서비스에서 getSqlSession() 호출
		memberDao = new MemberDao();
		memberDao.updateMember(sqlSession, member);
	}
	/**
	 * pw가 db내 데이터와 일치하는지 조회하는 메서드를 호출하는 서비스 계층의 메서드
	 * @param memberNo
	 * @return member
	 */
	public Member selectForPasswordCheck(Member member) {
		System.out.println("MemberService.selectMember()");
		memberDao = new MemberDao();
		SqlSession sqlSession = DBHelper.getSqlSession();	// 통일성을 위해 서비스에서 getSqlSession() 호출
		memberDao = new MemberDao();
		Member memberCheck = memberDao.selectMemberForPasswordCheck(sqlSession, member);
		
		return memberCheck;
	}
	/**
	 * 한 명의 회원정보를 조회하는 메서드를 호출하는 서비스 계층의 메서드
	 * @param memberNo
	 * @return member
	 */
	public Member selectOneMember(int memberNo) {
		System.out.println("MemberService.selectMember()");
		Member member = null;
		SqlSession sqlSession = DBHelper.getSqlSession();	// 통일성을 위해 서비스에서 getSqlSession() 호출
		memberDao = new MemberDao();
		member = memberDao.selectMember(sqlSession, memberNo);
		
		return member;			
	}
	/**
	 * 로그인 처리를 하는 메서드를 호출하는 서비스 계층의 메서드
	 * @param member
	 * @return loginMember
	 */
	public Member loginMember(Member member) {
		System.out.println("MemberService.loginMember()");	
		memberDao = new MemberDao();
		SqlSession sqlSession = DBHelper.getSqlSession();	// 통일성을 위해 서비스에서 getSqlSession() 호출
		Member loginMember = memberDao.login(sqlSession, member);
		
		return loginMember;
	}
	/**
	 * 회원가입 메서드를 호출하는 서비스 계층의 메서드
	 * @param member
	 */
	public void addMember(Member member) {
		System.out.println("MemberService.addMember()");
		memberDao = new MemberDao();
		SqlSession sqlSession = DBHelper.getSqlSession();	// 통일성을 위해 서비스에서 getSqlSession() 호출
		memberDao.insertMember(sqlSession, member);
	}
}
