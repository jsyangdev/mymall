package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class MemberItemDao {
	public void deleteMemberItem(Connection conn, int no) {
		String sql="";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Member INNER JOIN Item
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNo){
		Connection conn;	// 통일이 안되므로 얘도 커넥션을 매개변수로 가져오겠다.
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "";
		
		/* 
		 	SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price
			FROM member_item mi inner join item i
			on mi.item_no = i.no
			where mi.member_no = ?

			while(rs.next()) {
				// 원래는 이렇게 만들어야하는데 MemberItemJoinItem 일회용이니까 HashMap 쓸 것
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("memberItemNo", rs.getInt("mi.no"));
				map.put("itemPrice", rs.getInt("i.price"));
				list.add(map);
			}
		*/
		return list;
	}
}
