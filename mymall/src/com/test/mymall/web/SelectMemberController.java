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
		// get������� �Ѿ�� �� �ޱ�
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		// ���� ������ �޼��� ȣ��
		memberService = new MemberService();
		Member member = memberService.selectMember(memberNo);
		// request��ü �� �Ӽ� ����
		request.setAttribute("member", member);
		// ������
		request.getRequestDispatcher("/WEB-INF/view/selectMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SelectMemberController.doPost()");
		// post������� �Ѿ�� �� �޾� vo�� ����		
		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		int level = Integer.parseInt(request.getParameter("level"));
		response.sendRedirect(request.getContextPath()+"/UpdateMemberController?memberNo="+no+"&memberID="+id+"&memberLevel="+level);
	}
}
