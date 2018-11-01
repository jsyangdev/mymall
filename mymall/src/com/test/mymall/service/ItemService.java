package com.test.mymall.service;

import java.util.ArrayList;

import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	
	public ArrayList<Item> itemList() {
		System.out.println("ItemService.itemList()");
		itemDao = new ItemDao();
		ArrayList<Item> itemList = itemDao.selectAllItem();
		return itemList;
	}
	
}
