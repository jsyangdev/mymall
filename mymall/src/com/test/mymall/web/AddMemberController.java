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
	// # 컨트롤러의 역할
	// 1. 라우터
	// 2. 모델 호출
	// 3. 뷰 렌더링
	private MemberService memberService;	// 위치 중요
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doPost()");
		// post방식으로 넘어온 입력데이터 한글깨짐 없게 인코딩
		request.setCharacterEncoding("utf-8");
		// 입력데이터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String levelOfString = (String)request.getParameter("level");
		int level = Integer.parseInt(levelOfString);
		// Member(vo) 생성 후, 값 셋팅
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setLevel(level);
		// memberService 생성 후, addMember메서드 호출
		memberService = new MemberService();
		memberService.addMember(member);
		response.sendRedirect(request.getContextPath()+"/LoginController");
	}

}
