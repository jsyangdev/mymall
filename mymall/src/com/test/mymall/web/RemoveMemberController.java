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
/*		System.out.println("RemoveMemberController.doGet()");
		int no = Integer.parseInt(request.getParameter("memberNo"));
		request.setAttribute("no", no);
		request.getRequestDispatcher("/WEB-INF/view/passwordCheck.jsp").forward(request, response);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		System.out.println("RemoveMemberController.doPost()");
		// 화면에서 데이터 받아와 vo에 셋팅 시키기
		int no = Integer.parseInt(request.getParameter("no"));
		String pw = request.getParameter("pw");
		Member member = new Member();
		member.setNo(no);
		member.setPw(pw);
		Member memberCheck = memberService.selectMemberForRemove(member);*/
		
		
		
		
		
		
		
		
	}

}
