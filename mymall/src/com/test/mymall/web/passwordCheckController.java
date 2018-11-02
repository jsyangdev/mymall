package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/passwordCheckController")
public class passwordCheckController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("passwordCheckController.doGet()");
		int no = Integer.parseInt(request.getParameter("memberNo"));
		request.setAttribute("no", no);
		request.getRequestDispatcher("/WEB-INF/view/passwordCheck.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("passwordCheckController.doPost()");
		// ȭ�鿡�� ������ �޾ƿ� vo�� ���� ��Ű��
		int no = Integer.parseInt(request.getParameter("no"));
		String pw = request.getParameter("pw");
		Member member = new Member();
		memberService = new MemberService();
		member.setNo(no);
		member.setPw(pw);
		Member memberCheck = memberService.selectMemberForRemove(member);
		System.out.println(memberCheck+"<---memberCheck");
		// memberCheck������ null�� ������ ���� ��� �ٸ��� ����
		if(memberCheck != null) {
			request.setAttribute("memberCheck", memberCheck);
			response.sendRedirect(request.getContextPath()+"/RemoveMemberController");
		} else {
			request.getRequestDispatcher("/WEB-INF/view/passwordCheck.jsp").forward(request, response);
		}
		
	}

}
