package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberItemService;

@WebServlet("/OrderListController")
public class OrderListController extends HttpServlet {
	private MemberItemService memberItemService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController.doGet()");
		// get방식으로 넘어온 값 받기
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		// 서비스 계층 호출
		memberItemService = new MemberItemService();
		ArrayList<HashMap<String, Object>> list = memberItemService.selectMemberItem(memberNo);
		// 세션에 리스트 셋팅
		request.setAttribute("orderList", list);
		// orderList view쪽으로 포워딩
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
		
		
		/*
		 * MemberItemDao.getMemberItemList(int memberNo);
		 * 
		 */
	}

}
