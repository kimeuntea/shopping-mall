package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberBean;
import dao.MemberDao;

public class findidpwAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String url = "member/findForm.jsp";
 	String id = request.getParameter("id");
 	String phone = request.getParameter("phone");
 	String name = request.getParameter("name");
 	MemberDao dao = MemberDao.getInstance();
 	int result = 0;
 	String message="";
 	if(request.getParameter("num").equals("id"))
 	{
 	 	String i_d =dao.findid(name,phone);
 	 	if(i_d != null)
 	 	{
 	 		message = "사용자님의 아이디는 : "+i_d;
 	 	  request.setAttribute("message", message);
 	 	}else
 	 	{
 	 		message = "잘못된 입력입니다.";
 	 	 	  request.setAttribute("message", message);
 	 	}
 	}
 	else
 	{
 		String pw =dao.findpw(id,phone);
	 	 if(pw != null)
	 	 {
	 		message ="사용자님의 암호는 "+ pw;
	 		request.setAttribute("message1", message);
	 		
	 	 }else
	 	 {
	 		message ="잘못된정보입니다.";
	 		request.setAttribute("message1", message);
	 	 }
 	}
 		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
