package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {

	public int totalRowCount(SqlSession sqlSession) {
		System.out.println("ItemDao.totalRowCount()");
		// 아이템 리스트의 전체 행 수를 구하는 쿼리 날리기
		int rowCount = (Integer)sqlSession.selectOne("selectRowCountOfItemList");
		sqlSession.commit();
		sqlSession.close();
		System.out.println(rowCount+"<---rowCount");
		System.out.println("------------ ItemDao.totalRowCount() END ------------");	
		return rowCount;
	}
	/**
	 * 상품리스트 조회하는 메서드
	 * @param sqlSession
	 * @return
	 */
	//	HashMap으로 매개변수 보내야될 듯.
	public ArrayList<Item> selectAllItem(SqlSession sqlSession, HashMap<String, Object> map) {
		System.out.println("ItemDao.selectAllItem()");
		ArrayList<Item> itemList = (ArrayList)sqlSession.selectList("selectItemList", map);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(itemList+"<---itemList ItemDao.selectAllItem()");
		System.out.println("------------ ItemDao.selectAllItem() END ------------");	
		return itemList;
	}
}
