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

public class OrderDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "mypage/orderdetail.jsp";
		String id = (String) session.getAttribute("id");
		OrderDao orderdao = OrderDao.getInstance();
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		List<OrderBean> orderlist = new ArrayList<OrderBean>();
		int totalprice = 0;
		if (session.getAttribute("id") == null) {
			url = "member/LoginForm.jsp";
		} else {
			    orderlist = orderdao.orderlist(id,"%",oseq); //처리 미처리 모든 상세정보 출력
			    for (OrderBean orderbean : orderlist) {
					totalprice=orderbean.getPrice2()*orderbean.getQuantity();
				}
			    request.setAttribute("orderdetail", orderlist.get(0));
			    request.setAttribute("totalprice", totalprice);
			    request.setAttribute("orderlist", orderlist);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
