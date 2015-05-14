package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberBean;
import dao.MemberDao;

public class MemberUpdateForm_2Action implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String url = "member/MemberUpdateForm_1.jsp";
	
	MemberDao dao = MemberDao.getInstance();
	MemberBean bean = new MemberBean();
	HttpSession session = request.getSession();
	
	 String id = (String) session.getAttribute("id");
	 String pwd=request.getParameter("pwd");
	 
	 int result = dao.login(id, pwd);
	 if(result == 1  )
	 {
		 url ="member/MemberUpdateForm_2.jsp";
		 bean = dao.getByid(id);
		 request.setAttribute("bean", bean);
	 }else
	 {
		 url ="member/MemberUpdateForm_1.jsp";
		 request.setAttribute("message", "비번 부적절함");
	 }
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
} 
