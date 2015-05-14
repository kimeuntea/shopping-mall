package com.nonage.admin.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.controller.action.Action;

import dao.MemberDao;

public class admin_LoginAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String url = "";
 	String id = request.getParameter("workid");
 	String pwd = request.getParameter("workpwd");
 	
 	MemberDao dao = MemberDao.getInstance();
 	int result = dao.admin_login(id,pwd);
	//dao�� ���̵� �ߺ�üũ Ȯ���� 
 	String message = "";
 	if(result  == -1)
 	{
 		System.out.println("���̵����");
 		message = "��ϵ������� ���̵��Դϴ�.";
 		url= "admin/admin_LoginForm.jsp";
 	}else if(result == 0)
 	{
 		System.out.println("�������");
 		message = "��й�ȣ�� Ʋ�ǽ��ϴ�.";
 		url = "admin/admin_LoginForm.jsp";
 	}
 	else if(result == 1)
 	{
 		System.out.println("�α���");
 		url = "NonageServlet?command=admin_index";
 		HttpSession session = request.getSession();
 		session.setAttribute("adminid", id);
 	}
 	
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
