package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.MemberItem;

public class MemberItemService {
	private MemberItemDao memberItemDao;
	/**
	 * 한 명의 회원이 주문한 전체 주문리스트를 select하는 메서드를 호출하는 서비스 계층의 메서드
	 * @param memberNo
	 */
	public ArrayList<HashMap<String, Object>> selectMemberItem(int memberNo) {
		System.out.println("MemberItemService.selectMemberItem()");
		Connection conn = null;
		ArrayList<HashMap<String, Object>> list = null;
		try {
			conn = DBHelper.getConnection();
			memberItemDao = new MemberItemDao();
			list = memberItemDao.getMemberItemList(conn, memberNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, conn);
		}
		return list;		
	}
	/**
	 * 
	 * @param memberItem
	 */
	public void insertMemberItem(MemberItem memberItem) {
		System.out.println("MemberItemService.insertMemberItem()");
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			memberItemDao = new MemberItemDao();
			memberItemDao.addMemberItem(conn, memberItem);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, conn);
		}	
	}
}
