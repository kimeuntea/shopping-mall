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

public class admin_OrderListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "admin/order/orderList.jsp";
        String key  = request.getParameter("key");
		OrderBean bean = new OrderBean();
		OrderDao dao = OrderDao.getInstance();
		
		List<OrderBean> orderlist = new ArrayList<>();
		orderlist = dao.admin_orderList(key);
		
		
		request.setAttribute("orderlist", orderlist);
        
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
