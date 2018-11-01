package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private MemberService memberservice;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController.doPost()");
		// post������� �Ѿ���� ���� �ѱ۱��� ������ ���ڵ�
		request.setCharacterEncoding("utf-8");
		// ȭ�鿡�� �Է��� ������ �ޱ�
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// vo�� ȭ�鿡�� �Է��� ������ ����
		Member member = new Member();
		member.setId(id);	
		member.setPw(pw);
		// memberservice.loginMember() ȣ��
		memberservice = new MemberService();
		Member loginMember = memberservice.loginMember(member);
		// �α��� �Ǿ����� Ȯ��
		if(loginMember != null) {
			System.out.println("�α��� ���� !");
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect(request.getContextPath()+"/IndexController");
		} else {
			System.out.println("�α��� ���� !");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
	}
}
