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

public class admin_QnaReplyAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "NonageServlet?command=admin_qna_list";
        String qseq  = request.getParameter("qseq");
        String reply = request.getParameter("reply");
		QnABean bean = new QnABean();
		QnADao dao = QnADao.getInstance();
		
		dao.admin_qnareply(Integer.parseInt(qseq),reply);
		
	
		response.sendRedirect(url);
	}
}
