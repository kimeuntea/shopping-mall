package com.nonage.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.nonage.controller.action.Action;

import dao.OrderBean;
import dao.OrderDao;
import dao.QnABean;
import dao.QnADao;

public class admin_QnaViewAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "admin/qna/qnaview.jsp";
        int qseq  = Integer.parseInt(request.getParameter("qseq"));
		QnABean bean = new QnABean();
		QnADao dao = QnADao.getInstance();
		
		bean = dao.admin_qnaview(qseq);
		
		
		request.setAttribute("qna", bean);
        
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
