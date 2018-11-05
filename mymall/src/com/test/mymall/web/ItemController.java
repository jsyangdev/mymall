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
		// get방식으로 넘어오는 currentPage가 있는 경우 받기
		int currentPage = 1;	// 넘어오지않는 경우
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		// currentPage를 매개변수로 서비스 계층의 메서드 호출
		System.out.println(currentPage+"<---currentPage ItemService.doGet()");
		itemList = itemService.itemList(currentPage);
		
		
		//-------------------------------------------------------------------------
		
		
		
		
		
		
		
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request, response);
		System.out.println("------------ ItemController.doGet() END ------------");
	}

}