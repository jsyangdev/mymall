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
		// 서비스 계층의 메서드 호출
		memberService = new MemberService();
		Member member = memberService.selectMember(memberNo);
		// request객체 내 속성 셋팅
		request.setAttribute("member", member);
		// 포워딩
		request.getRequestDispatcher("/WEB-INF/view/selectMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SelectMemberController.doPost()");
		// post방식으로 넘어온 값 받아 vo에 셋팅		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int level = Integer.parseInt(request.getParameter("level"));
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setLevel(level);
		// 서비스계층 메서드 호출
		memberService = new MemberService();
		memberService.updateMember(member);
		
		
		
		
	}

}
