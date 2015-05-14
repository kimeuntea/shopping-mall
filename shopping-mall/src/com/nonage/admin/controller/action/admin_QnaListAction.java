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

public class admin_QnaListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "admin/qna/qnaList.jsp";
        String key  = request.getParameter("key");
		QnABean bean = new QnABean();
		QnADao dao = QnADao.getInstance();
		
		List<QnABean> qnalist = new ArrayList<>();
		qnalist = dao.admin_qnalist(key);
		
		
		request.setAttribute("qnalist", qnalist);
        
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
