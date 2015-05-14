package com.nonage.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.controller.action.Action;

import dao.OrderBean;
import dao.OrderDao;

public class admin_OrderSaveAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "admin/order/orderDetail.jsp";
		OrderDao orderdao = OrderDao.getInstance();
		int odseq = Integer.parseInt(request.getParameter("odseq"));
		OrderBean bean = new OrderBean();
		orderdao.sadmin_save(odseq);
		
		bean = orderdao.admin_orderdetail(odseq);
			    request.setAttribute("order", bean);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
