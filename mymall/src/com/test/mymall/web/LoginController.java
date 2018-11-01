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
		// post방식으로 넘어오는 값들 한글깨짐 없도록 인코딩
		request.setCharacterEncoding("utf-8");
		// 화면에서 입력한 데이터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// vo에 화면에서 입력한 데이터 셋팅
		Member member = new Member();
		member.setId(id);	
		member.setPw(pw);
		// memberservice.loginMember() 호출
		memberservice = new MemberService();
		Member loginMember = memberservice.loginMember(member);
		// 로그인 되었는지 확인
		if(loginMember != null) {
			System.out.println("로그인 성공 !");
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect(request.getContextPath()+"/IndexController");
		} else {
			System.out.println("로그인 실패 !");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
	}
}
