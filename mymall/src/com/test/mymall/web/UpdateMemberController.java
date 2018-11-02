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
		String id = request.getParameter("memberID");
		int level = Integer.parseInt(request.getParameter("memberLevel"));
		Member member = new Member();
		member.setNo(no);
		member.setId(id);
		member.setLevel(level);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/view/updateMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateMemberController.doPost()");
		// 화면에서 입력데이터 받아 vo에 셋팅
		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int level = Integer.parseInt(request.getParameter("level"));
		Member member = new Member();
		member.setNo(no);
		member.setId(id);
		member.setPw(pw);
		member.setLevel(level);
		// 서비스 계층 메서드 호출
		memberService = new MemberService();
		Member memberUpdate = memberService.updateMember(member);
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", memberUpdate);
		response.sendRedirect(request.getContextPath()+"/IndexController");
	}

}
