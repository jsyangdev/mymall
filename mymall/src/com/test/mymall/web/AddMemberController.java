package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;

@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	// # ��Ʈ�ѷ��� ����
	// 1. �����
	// 2. �� ȣ��
	// 3. �� ������
	private MemberDao memberDao;	// ��ġ �߿�
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		// this.memberDao
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// this.memberDao
	}

}
