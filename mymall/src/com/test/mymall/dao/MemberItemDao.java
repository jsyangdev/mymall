package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.MemberItem;


public class MemberItemDao {
	/**
	 * 특정 member_no값에 해당하는 데이터를 삭제하는 메서드
	 * @param conn
	 * @param no
	 */
	public void deleteMemberItem(Connection conn, int no) {
		System.out.println("MemberItemDao.deleteMemberItem()");
		String sql="DELETE FROM member_item WHERE member_no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt, conn);
		}
	}
	/**
	 * 한 명의 회원이 주문한 정보를 DB에 접근해 데이터 추가
	 * @param conn
	 * @param memberItem
	 */
	public void addMemberItem(Connection conn, MemberItem memberItem) {
		System.out.println("MemberItemDao.addMemberItemList()");
		String sql = "INSERT INTO member_item(member_no, item_no, order_date) values(?, ?, now())";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberItem.getMember_no());
			pstmt.setInt(2, memberItem.getItem_no());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt, conn);
		}
	}
	/**
	 * 한 명의 회원이 주문한 전체 주문리스트를 select하는 메서드
	 * Member INNER JOIN Item
	 * @param memberNo
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> getMemberItemList(Connection conn, int memberNo){
		// Connection conn; ---> 통일이 안되므로 커넥션을 매개변수로 가져옴
		System.out.println("MemberItemDao.getMemberItemList()");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT mi.no, mi.item_no, i.name, i.price, mi.order_date FROM member_item mi INNER JOIN item i ON mi.item_no = i.no WHERE mi.member_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("memberItemNo", rs.getInt("mi.no"));
				map.put("itemNo", rs.getInt("mi.item_no"));
				map.put("itemName", rs.getString("i.name"));
				map.put("itemPrice", rs.getString("i.price"));
				map.put("orderDate", rs.getString("mi.order_date"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, pstmt, conn);
		}
		return list;
	}
}
