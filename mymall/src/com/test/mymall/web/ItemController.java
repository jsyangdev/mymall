package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.ItemDao;
import com.test.mymall.service.ItemService;
import com.test.mymall.vo.Item;

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private ItemService itemService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ItemController.doGet()");
		itemService = new ItemService();
		ArrayList<Item> itemList;
		// get������� �Ѿ���� currentPage�� �ִ� ��� �ޱ�
		int currentPage = 1;	// �Ѿ�����ʴ� ���
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		// currentPage�� �Ű������� ���� ������ �޼��� ȣ��
		System.out.println(currentPage+"<---currentPage ItemService.doGet()");
		itemList = itemService.itemList(currentPage);
		
		
		//-------------------------------------------------------------------------
		
		
		
		
		
		
		
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request, response);
		System.out.println("------------ ItemController.doGet() END ------------");
	}

}