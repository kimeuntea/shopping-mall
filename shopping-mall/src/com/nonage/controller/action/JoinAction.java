package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberBean;
import dao.MemberDao;

public class JoinAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String url = "NonageServlet?command=LoginForm";
	
	MemberBean bean = new MemberBean();
	MemberDao dao = MemberDao.getInstance();
	
	bean.setId(request.getParameter("id"));
	bean.setPwd(request.getParameter("pwd"));
	bean.setName(request.getParameter("name"));
	bean.setEmail(request.getParameter("email"));
	bean.setZipcode(request.getParameter("zipcode"));
	bean.setAddress(request.getParameter("address"));
	bean.setPhone(request.getParameter("phone"));
	
	dao.join(bean);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
