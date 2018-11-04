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

@WebServlet("/PasswordCheckForUpdateController")
public class PasswordCheckForUpdateController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PasswordCheckForUpdateController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/passwordCheckForUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PasswordCheckForUpdateController.doPost()");
		// 화면에서 값 받고 vo에 셋팅
		String pw = request.getParameter("pw");
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("pw: "+pw);
		System.out.println("no: "+no);
		Member member = new Member();
		member.setNo(no);
		member.setPw(pw);
		// 서비스 계층의 메서드 호출
		memberService = new MemberService();
		Member memberCheck = memberService.selectForPasswordCheck(member);
		if(memberCheck != null) {
			System.out.println("비번일치 ! 수정폼으로!");
			no = memberCheck.getNo();
			response.sendRedirect(request.getContextPath()+"/UpdateMemberController?memberNo="+no);
		} else {
			System.out.println("비번일치 ! 비번체크 폼으로!");
			request.getRequestDispatcher("/WEB-INF/view/passwordCheckForUpdate.jsp").forward(request, response);
		}
	}

}
