package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

public class IdCheckFormAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String url = "member/IdCheckForm.jsp";
 	String id = request.getParameter("id");
 	
 	MemberDao dao = MemberDao.getInstance();
 	int result = dao.idcheck(id);
	//dao로 아이디 중복체크 확인후 
 	String message = "";
 	if(result != 1)
 	{
 		message = "사용가능한 아이디입니다.";
 	}else
 	{
 		message = "중복된아이디입니다.";
 	}
 	request.setAttribute("result",result);
	request.setAttribute("message",message);
	request.setAttribute("id",id);
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
