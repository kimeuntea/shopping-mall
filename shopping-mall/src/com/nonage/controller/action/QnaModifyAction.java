package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.catalina.startup.SetAllPropertiesRule;

import dao.CartBean;
import dao.CartDao;
import dao.MemberDao;
import dao.OrderBean;
import dao.OrderDao;
import dao.QnABean;
import dao.QnADao;

public class QnaModifyAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "NonageServlet?command=qna";
		String id = (String) session.getAttribute("id");
		if (session.getAttribute("id") == null) {
			url = "member/LoginForm.jsp";
		} else {
			QnABean bean = new QnABean();
			bean.setQseq(Integer.parseInt(request.getParameter("qseq")));
			bean.setSubject(request.getParameter("subject"));
			bean.setContent(request.getParameter("content"));
			bean.setId(id);
			QnADao dao = QnADao.getInstance();
			dao.qnamodify(bean);
			
		}
/*
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
*/	response.sendRedirect(url);
		}
}
