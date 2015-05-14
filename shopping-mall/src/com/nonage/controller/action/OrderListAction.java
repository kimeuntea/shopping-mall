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

public class OrderListAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
   HttpSession session = request.getSession();
   String url = "";
   String id = (String) session.getAttribute("id");
   int oseq = Integer.parseInt(request.getParameter("oseq"));
   OrderDao orderdao = OrderDao.getInstance();
   int totalPrice = 0;
   if(session.getAttribute("id")==null)
   {
	   url = "member/LoginForm.jsp";
   }
   else
   {
	   List<OrderBean> orderlist = orderdao.orderlist(id,"1",oseq);
	   for (OrderBean orderBean : orderlist) 
	   {
		totalPrice +=orderBean.getPrice2()*orderBean.getQuantity();
	}
	   
	   request.setAttribute("orderlist", orderlist);
	   request.setAttribute("totalprice", totalPrice);
	   url = "mypage/orderList.jsp";
   }
   
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
