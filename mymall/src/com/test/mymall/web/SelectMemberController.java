package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/SelectMemberController")
public class SelectMemberController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SelectMemberController.doGet()");
		// get방식으로 넘어온 값 받기
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		System.out.println(memberNo+"<---memberNo SelectMemberController.doGet()");
		// 서비스 계층의 메서드 호출
		memberService = new MemberService();
		Member member = memberService.selectOneMember(memberNo);
		// request객체 내 속성 셋팅
		request.setAttribute("member", member);
		// 포워딩
		request.getRequestDispatcher("/WEB-INF/view/selectMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SelectMemberController.doPost()");
		response.sendRedirect(request.getContextPath()+"/PasswordCheckForUpdateController");
	}
}
