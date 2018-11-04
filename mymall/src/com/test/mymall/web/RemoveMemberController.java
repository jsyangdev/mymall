package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/RemoveMemberController")
public class RemoveMemberController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RemoveMemberController.doGet()");
		// get방식으로 넘어온 값 받아 매개변수로 전달
		int no = Integer.parseInt(request.getParameter("memberNo"));
		System.out.println(no+"<---no RemoveMemberController.doGet()");
		memberService = new MemberService();
		memberService.removeMember(no);
		response.sendRedirect(request.getContextPath()+"/IndexController");
		
	}

}
