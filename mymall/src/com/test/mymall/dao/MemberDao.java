package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	/**
	 * 회원 탈퇴 메서드
	 * @param no
	 */
	public void deleteMember(SqlSession sqlSession, int no) {
		System.out.println("MemberDao.deleteMember()");
		sqlSession.delete("deleteMember", no);
		sqlSession.commit();
		sqlSession.close();
	}
	/**
	 * 화면에서 입력한 pw와 no이 db내 데이터와 일치하는지 조회하는 메서드
	 * @param sqlSession
	 * @param member
	 * @return
	 */
	public int selectMemberForpasswordCheckBeforeRemove(SqlSession sqlSession, Member member) {
		System.out.println("MemberDao.selectMemberForpasswordCheckBeforeRemove()");
		Member memberCheck = sqlSession.selectOne("selectForPasswordCheckBeforeRemove", member);
		int resultNo = 0;	// 비번이 일치하지않을 때
		if(memberCheck != null) {
			System.out.println("비번 일치 !");
			resultNo = memberCheck.getNo();	
		}
		System.out.println(resultNo+"<---resultNo MemberDao.selectMemberForpasswordCheckBeforeRemove()");
		
		return resultNo;
	}
	/**
	 * 회원정보를 수정하는 메서드
	 * @param sqlSession
	 * @param member
	 */
	public void updateMember(SqlSession sqlSession, Member member) {
		System.out.println("MemberDao.updateMember()");
		sqlSession.update("updateMember", member);
		sqlSession.commit();
		sqlSession.close();
	}
	/**
	 * 화면에서 입력한 pw와 no이 db내 데이터와 일치하는지 조회하는 메서드
	 * @param sqlSession
	 * @param member
	 * @return memberCheck
	 */
	public Member selectMemberForPasswordCheck(SqlSession sqlSession, Member member) {
		System.out.println("MemberDao.selectMemberForPasswordCheck()");
		Member memberCheck = sqlSession.selectOne("selectForPasswordCheck", member);
		System.out.println(memberCheck+"<---memberCheck");
		sqlSession.commit();
		sqlSession.close();
		
		return memberCheck;
	}
	/**
	 * 특정 회원의 정보를 조회하는 메서드
	 * @param sqlSession
	 * @param memberNo
	 * @return member
	 */
	public Member selectMember(SqlSession sqlSession, int memberNo) {	// 내 회원정보 보기
		System.out.println("MemberDao.selectMember()");
		Member member = sqlSession.selectOne("selectOneMember", memberNo);
		sqlSession.commit();
		sqlSession.close();
		
		return member;
	}
	/**
	 * 화면에서 넘어온 id, pw값과 DB내 값들을 비교하여 로그인 여부를 결정하는 메서드
	 * 로그인 실패시 -> null
	 * 로그인 성공시 -> Member에 조회된 값들 셋팅 후, 리턴
	 * @param member
	 * @return member
	 * @throws Exception 
	 */
	public Member login(SqlSession sqlSession, Member member){
		System.out.println("MemberDao.login()");
		// sqlSession 가지고 오기
		Member loginMember = sqlSession.selectOne("selectMemberForLogin", member);
		sqlSession.commit();
		sqlSession.close();
		
		return loginMember;
	}
	/**
	 * 멤버를 가입시키는 메서드
	 * @param member
	 * @param sqlSession
	 * @throws Exception
	 */
	public void insertMember(SqlSession sqlSession, Member member) {
		System.out.println("MemberDao.insertMember()");
		sqlSession.insert("insertMember", member);
		sqlSession.commit();
		sqlSession.close();
	}
	
}
