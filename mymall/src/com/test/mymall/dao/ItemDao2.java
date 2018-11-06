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

public class ItemDao2 {

	public int totalRowCount(SqlSession sqlSession) {
		System.out.println("ItemDao.totalRowCount()");
		// ������ ����Ʈ�� ��ü �� ���� ���ϴ� ���� ������
		int rowCount = (Integer)sqlSession.selectOne("selectRowCountOfItemList");
		sqlSession.commit();
		sqlSession.close();
		System.out.println(rowCount+"<---rowCount");
		System.out.println("------------ ItemDao.totalRowCount() END ------------");	
		return rowCount;
	}
	/**
	 * ��ǰ����Ʈ ��ȸ�ϴ� �޼���
	 * @param sqlSession
	 * @return
	 */
	//	HashMap���� �Ű����� �����ߵ� ��.
	public ArrayList<HashMap<String, Object>> selectAllItem(SqlSession sqlSession, HashMap<String, Object> map) {
		System.out.println("ItemDao.selectAllItem()");
		ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap = (HashMap)sqlSession.selectList("selectItemList", map); 
		sqlSession.commit();
		sqlSession.close();
		itemList.add(hashMap);
		System.out.println(itemList+"<---itemList ItemDao.selectAllItem()");
		System.out.println("------------ ItemDao.selectAllItem() END ------------");	
		return itemList;
	}
}
