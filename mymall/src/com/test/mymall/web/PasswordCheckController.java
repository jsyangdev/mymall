package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/PasswordCheckController")
public class PasswordCheckController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("passwordCheckController.doGet()");
		int no = Integer.parseInt(request.getParameter("memberNo"));
		System.out.println(no+"<---no PasswordCheckController.doGet()");
		request.setAttribute("no", no);
		request.getRequestDispatcher("/WEB-INF/view/passwordCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("passwordCheckController.doPost()");
		// post방식으로 넘어온 값들을 vo에 셋팅
		int no = Integer.parseInt(request.getParameter("no"));
		String pw = request.getParameter("pw");
		Member member = new Member();
		member.setNo(no);
		member.setPw(pw);
		// 서비스 계층의 메서드 호출
		memberService = new MemberService();
		int memberNo = memberService.selectMemberForRemove(member);
		System.out.println(memberNo+"<---memberNo PasswordCheckController.doPost()");
		// memberNo가 0(비번 불일치)인지 0이 아닌지(비번 일치) 확인 후, 경로 설정
		if(memberNo != 0) {
			response.sendRedirect(request.getContextPath()+"/RemoveMemberController?memberNo="+memberNo);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/passwordCheck.jsp").forward(request, response);
		}
		
	}

}
