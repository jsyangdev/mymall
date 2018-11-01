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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ItemController.doGet()");
		ItemService itemService = new ItemService();
		ArrayList<Item> itemList = itemService.itemList();
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request, response);
	}

}
