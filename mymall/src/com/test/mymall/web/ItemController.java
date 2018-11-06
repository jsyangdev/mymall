package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
		System.out.println(currentPage+"<---currentPage ItemService.doGet()");
		// 
		int rowsPerPage = 10;
		// # lastPage 구하기
		// 전체 행 수 구하기
		int rowCount = itemService.rowCount();
		// lastPage 구하기
		int lastPage = rowCount/rowsPerPage;
		if(rowCount % rowsPerPage != 0) {
			lastPage++;
		}
		// currentPage를 매개변수로 서비스 계층의 메서드 호출
		itemList = itemService.itemList(currentPage, rowsPerPage);
		request.setAttribute("itemList", itemList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request, response);
		System.out.println("------------ ItemController.doGet() END ------------");
	}

}