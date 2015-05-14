package com.nonage.admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.controller.action.Action;

import dao.MemberBean;
import dao.MemberDao;

public class admin_memberlistAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String url = "admin/member/memberList.jsp";
	String key = request.getParameter("id");
	MemberDao mdao = MemberDao.getInstance();
	List<MemberBean> bean = mdao.memberlist(key);
	
	request.setAttribute("memberlist", bean);
 	
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
