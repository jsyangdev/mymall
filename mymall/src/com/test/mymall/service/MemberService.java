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
	 * �������� 泥�由щ�� ���� 硫�����瑜� �몄����� ��鍮��� 怨�痢듭�� 硫�����(��鍮��� 怨�痢듭�� ���댁�쇳���� �ㅼ����� �댁��)
	 * RemoveMemberController���� MemberService.removeMember() �몄�
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
	 * �������� ��, 鍮�踰� ���몄�� ���� 硫�����瑜� �몄����� ��鍮��� 怨�痢듭�� 硫�����
	 * @param member
	 * @return
	 */
	public int selectMemberForRemove(Member member) {
		System.out.println("MemberService.selectMemberForRemove()");
		SqlSession sqlSession = DBHelper.getSqlSession();	// �듭�쇱�깆�� ���� ��鍮��ㅼ���� getSqlSession() �몄�
		memberDao = new MemberDao();
		int resultNo = memberDao.selectMemberForpasswordCheckBeforeRemove(sqlSession, member);

		return resultNo;
	}
	/**
	 *  ������蹂대�� �������� 硫�����瑜� �몄����� ��鍮��� 怨�痢듭�� 硫�����
	 * @param member
	 * @return
	 */
	public void updateMember(Member member) {
		System.out.println("MemberService.updateMember()");
		SqlSession sqlSession = DBHelper.getSqlSession();	// �듭�쇱�깆�� ���� ��鍮��ㅼ���� getSqlSession() �몄�
		memberDao = new MemberDao();
		memberDao.updateMember(sqlSession, member);
	}
	/**
	 * pw媛� db�� �곗�댄�곗�� �쇱�����吏� 議고������ 硫�����瑜� �몄����� ��鍮��� 怨�痢듭�� 硫�����
	 * @param memberNo
	 * @return member
	 */
	public Member selectForPasswordCheck(Member member) {
		System.out.println("MemberService.selectForPasswordCheck()");
		memberDao = new MemberDao();
		SqlSession sqlSession = DBHelper.getSqlSession();	// �듭�쇱�깆�� ���� ��鍮��ㅼ���� getSqlSession() �몄�
		memberDao = new MemberDao();
		Member memberCheck = memberDao.selectMemberForPasswordCheck(sqlSession, member);
		
		return memberCheck;
	}
	/**
	 * �� 紐��� ������蹂대�� 議고������ 硫�����瑜� �몄����� ��鍮��� 怨�痢듭�� 硫�����
	 * @param memberNo
	 * @return member
	 */
	public Member selectOneMember(int memberNo) {
		System.out.println("MemberService.selectMember()");
		Member member = null;
		SqlSession sqlSession = DBHelper.getSqlSession();	// �듭�쇱�깆�� ���� ��鍮��ㅼ���� getSqlSession() �몄�
		memberDao = new MemberDao();
		member = memberDao.selectMember(sqlSession, memberNo);
		
		return member;			
	}
	/**
	 * 濡�洹몄�� 泥�由щ�� ���� 硫�����瑜� �몄����� ��鍮��� 怨�痢듭�� 硫�����
	 * @param member
	 * @return loginMember
	 */
	public Member loginMember(Member member) {
		System.out.println("MemberService.loginMember()");	
		memberDao = new MemberDao();
		SqlSession sqlSession = DBHelper.getSqlSession();	// �듭�쇱�깆�� ���� ��鍮��ㅼ���� getSqlSession() �몄�
		Member loginMember = memberDao.login(sqlSession, member);
		
		return loginMember;
	}
	/**
	 * ����媛��� 硫�����瑜� �몄����� ��鍮��� 怨�痢듭�� 硫�����
	 * @param member
	 */
	public void addMember(Member member) {
		System.out.println("MemberService.addMember()");
		memberDao = new MemberDao();
		SqlSession sqlSession = DBHelper.getSqlSession();	// �듭�쇱�깆�� ���� ��鍮��ㅼ���� getSqlSession() �몄�
		memberDao.insertMember(sqlSession, member);
	}
}
