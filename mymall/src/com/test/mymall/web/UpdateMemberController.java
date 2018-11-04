package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/UpdateMemberController")
public class UpdateMemberController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateMemberController.doGet()");
		int no = Integer.parseInt(request.getParameter("memberNo"));		
		request.setAttribute("no", no);
		request.getRequestDispatcher("/WEB-INF/view/updateMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateMemberController.doPost()");
		// post방식으로 넘어온 값들 받아 vo에 셋팅하기
		int no = Integer.parseInt(request.getParameter("no"));
		String pw = request.getParameter("pw");
		System.out.println(no+"<---no UpdateMemberController");
		System.out.println(pw+"<---pw UpdateMemberController");
		Member member = new Member();
		member.setNo(no);
		member.setPw(pw);
		// 서비스 계층의 메서드 호출
		memberService = new MemberService();
		memberService.updateMember(member);
		response.sendRedirect(request.getContextPath()+"/IndexController");
	}

}
