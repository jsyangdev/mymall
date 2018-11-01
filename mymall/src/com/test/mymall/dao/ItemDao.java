package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {
	
	public ArrayList<Item> selectAllItem(){
		System.out.println("ItemDao.selectAllItem()");
		ArrayList<Item> itemList = new ArrayList<Item>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM item";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Item item = new Item();
				item.setNo(rs.getInt("no"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getString("price"));
				itemList.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return itemList;
		
	}
}
