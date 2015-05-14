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

public class MypageAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "mypage/mypage.jsp";
		String id = (String) session.getAttribute("id");
		OrderDao orderdao = OrderDao.getInstance();
		List<OrderBean> orderlist = new ArrayList<OrderBean>();
		int totalprice = 0;
		if (session.getAttribute("id") == null) {
			url = "member/LoginForm.jsp";
		} else {
			List<Integer> oseqlist = orderdao.selectOrderIng(id);// id로 주문번호 모두
																	// 반환
			for (Integer oseq : oseqlist) {
				List<OrderBean> orderlisting = orderdao
						.orderlist(id, "1", oseq);
				OrderBean orderbean = orderlisting.get(0);
				orderbean.setPname(orderbean.getPname() + ":"
						 + ":");

				orderlist.add(orderbean);
				for (OrderBean orderBean : orderlisting) {
					totalprice += orderbean.getPrice2()
							* orderBean.getQuantity();
				}
			}
			request.setAttribute("totalprice", totalprice);
			request.setAttribute("orderlist", orderlist);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
