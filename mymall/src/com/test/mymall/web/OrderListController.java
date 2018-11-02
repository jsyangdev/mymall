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
		// get諛⑹���쇰� ���댁�� 媛� 諛�湲�
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		// ��鍮��� 怨�痢� �몄�
		memberItemService = new MemberItemService();
		ArrayList<HashMap<String, Object>> list = memberItemService.selectMemberItem(memberNo);
		// �몄���� 由ъ�ㅽ�� ����
		request.setAttribute("orderList", list);
		// orderList view履쎌�쇰� �ъ����
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
		/*
		 * MemberItemDao.getMemberItemList(int memberNo);
		 * 
		 */
	}

}
