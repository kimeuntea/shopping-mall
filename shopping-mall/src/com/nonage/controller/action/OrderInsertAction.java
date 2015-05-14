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
import dao.OrderDao;

public class OrderInsertAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
   HttpSession session = request.getSession();
   String url = "NonageServlet?command=orderlist";
   String id = (String) session.getAttribute("id");
   CartDao cartdao = CartDao.getInstance();
   OrderDao orderdao = OrderDao.getInstance();
   int pseq = Integer.parseInt(request.getParameter("pseq"));
   int quantity = Integer.parseInt(request.getParameter("quantity"));
   if(session.getAttribute("id")==null)
   {
	   url = "member/LoginForm.jsp";
   }else
   {
	   List<CartBean> cartbean = new ArrayList<>();
			  cartbean = cartdao.cartlist(id);
		int maxOseq = orderdao.orderInsert(cartbean,id);
	   url = "NonageServlet?command=orderlist&oseq="+maxOseq;//주문번호를 주문리스트로 넘긴다.
   }
   
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
