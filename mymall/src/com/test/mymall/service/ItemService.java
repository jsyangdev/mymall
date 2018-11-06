package com.test.mymall.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	public int rowCount() {
		System.out.println("ItemService.rowCount()");
		itemDao = new ItemDao();
		SqlSession sqlSession = DBHelper.getSqlSession();
		// ## 아이템리스트 페이징
		// 전체 데이터의 수 구하기
		int rowCount = itemDao.totalRowCount(sqlSession);
		System.out.println(rowCount+"<---rowCount");
		System.out.println("------------ ItemService.rowCount() END ------------");
		
		return rowCount;
	}
	public ArrayList<Item> itemList(int currentPage, int rowsPerPage) {
		System.out.println("ItemService.itemList()");
		itemDao = new ItemDao();
		SqlSession sqlSession = DBHelper.getSqlSession();
		// 한 페이지당 몇 개의 데이터를 보여줄 것인지, rowsPerPage 정하기
		
		// startRow 구하기
		int startRow = (currentPage-1)*rowsPerPage;
		SqlSession sqlSessionForItemList = DBHelper.getSqlSession();
		// currentPage, rowsPerPage를 해쉬맵에 담기
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("rowsPerPage", rowsPerPage);
		ArrayList<Item> itemList = itemDao.selectAllItem(sqlSessionForItemList, map);
		System.out.println("------------ ItemService.itemList() END ------------");
		
		return itemList;
	}
	
}
