package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private MemberItemService memberItemService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController.doGet()");
		// get방식으로 넘어온 값들 MemberItem vo에 셋팅
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		Member member = (Member)request.getSession().getAttribute("loginMember");
		int memberNo = member.getNo();
		MemberItem memberItem = new MemberItem();
		memberItem.setItem_no(itemNo);
		memberItem.setMember_no(memberNo);
		// 서비스 계층 호출
		memberItemService = new MemberItemService();
		memberItemService.insertMemberItem(memberItem);
		// OrderListController로 redirect
		response.sendRedirect(request.getContextPath()+"/OrderListController?memberNo="+memberNo);
		// MemberItemDao.insertMemberItem(MemberItem);	
	}

}
