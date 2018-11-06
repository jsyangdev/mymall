package com.test.mymall.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	public ArrayList<Item> itemList(int currentPage) {
		System.out.println("ItemService.itemList()");
		itemDao = new ItemDao();
		SqlSession sqlSession = DBHelper.getSqlSession();
		// ## �����۸���Ʈ ����¡
		// ��ü �������� �� ���ϱ�
		int rowCount = itemDao.totalRowCount(sqlSession);
		System.out.println(rowCount+"<---rowCount");
		// �� �������� �� ���� �����͸� ������ ������, rowsPerPage ���ϱ�
		int rowsPerPage = 10;
		// startRow ���ϱ�
		int startRow = (currentPage-1)*rowsPerPage;
		SqlSession sqlSessionForItemList = DBHelper.getSqlSession();
		// currentPage, rowsPerPage�� �ؽ��ʿ� ���
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("rowsPerPage", rowsPerPage);
		ArrayList<Item> itemList = itemDao.selectAllItem(sqlSessionForItemList, map);
		System.out.println("------------ ItemService.itemList() END ------------");
		
		return itemList;
	}
	
}
