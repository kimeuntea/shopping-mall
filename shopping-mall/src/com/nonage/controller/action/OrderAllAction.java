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

public class OrderAllAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
   HttpSession session = request.getSession();
   String url = "mypage/orderAll.jsp";
   String id = (String) session.getAttribute("id");
   List<Integer> orderoseq = new ArrayList<>();
   List<OrderBean> orderlisting = new ArrayList<>();
   List<OrderBean> orderlist = new ArrayList<>();
   OrderDao orderdao = OrderDao.getInstance();
   int totalPrice = 0;
   if(session.getAttribute("id")==null)
   {
	   url = "member/LoginForm.jsp";
   }
   else
   {
	   orderoseq =orderdao.selectOrderIng2(id);
	   
	   for (Integer oseq : orderoseq) 
	   {
		orderlisting = orderdao.orderlist(id, "%", oseq);
		OrderBean orderbean = orderlisting.get(0);
		   orderlist.add(orderbean);
		   for (OrderBean bean : orderlisting) {
			totalPrice +=bean.getPrice2()*bean.getQuantity();
		}
	}
	   request.setAttribute("totalprice",totalPrice);
	   request.setAttribute("orderlist", orderlist);
	  
	   }
   
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
}
}
