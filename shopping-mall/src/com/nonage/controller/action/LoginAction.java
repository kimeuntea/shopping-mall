package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

public class LoginAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String url = "";
 	String id = request.getParameter("id");
 	String pwd = request.getParameter("pwd");
 	
 	MemberDao dao = MemberDao.getInstance();
 	int result = dao.login(id,pwd);
	//dao로 아이디 중복체크 확인후 
 	String message = "";
 	if(result  == -1)
 	{
 		System.out.println("아이디오류");
 		message = "등록되지않은 아이디입니다.";
 		url= "member/LoginForm.jsp";
 	}else if(result == 0)
 	{
 		System.out.println("비번오류");
 		message = "비밀번호가 틀렷습니다.";
 		url = "member/LoginForm.jsp";
 	}
 	else if(result == 1)
 	{
 		System.out.println("로그인");
 		url = "NonageServlet?command=index";
 		HttpSession session = request.getSession();
 		session.setAttribute("id", id);
 	}
 	
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
