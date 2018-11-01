package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	// # ��Ʈ�ѷ��� ����
	// 1. �����
	// 2. �� ȣ��
	// 3. �� ������
	private MemberService memberService;	// ��ġ �߿�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doPost()");
		// post������� �Ѿ���� ���� �ѱ۱��� ������ ���ڵ�
		request.setCharacterEncoding("utf-8");
		// ȭ�鿡�� �Է��� ������ �ޱ�
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String levelOfString = (String)request.getParameter("level");
		int level = Integer.parseInt(levelOfString);
		// Member(vo) ���� ��, �Էµ����� ����
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setLevel(level);
		// memberService ���� ��, addMember�޼��� ȣ��
		memberService = new MemberService();
		memberService.addMember(member);
		response.sendRedirect(request.getContextPath()+"/LoginController");
	}

}
