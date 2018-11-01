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
	
	// RemoveMemberController에서 MemberService.removeMember() 호출
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
	
	public Member loginMember(Member member) {
		System.out.println("MemberService.loginMember()");	
		memberDao = new MemberDao();
		Member memberLogin = memberDao.login(member);
		return memberLogin;
	}
	
	public void addMember(Member member) {
		System.out.println("MemberService.addMember()");
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}
