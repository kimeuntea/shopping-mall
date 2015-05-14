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

public class CartlistAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
   HttpSession session = request.getSession();
   String url = "";
   CartBean bean = new CartBean();
   CartDao dao = CartDao.getInstance();
   /*int pseq = Integer.parseInt(request.getParameter("pseq"));
   int quantity = Integer.parseInt(request.getParameter("quantity"));*/
   String id = (String) session.getAttribute("id");
   
   if(session.getAttribute("id")==null)
   {
	   url = "member/LoginForm.jsp";
   }
   else
   {
	   int totalPrice = 0;
	   List<CartBean>list = new ArrayList<CartBean>();
	   list =dao.cartlist(id);
	   for (CartBean cartBean : list) {
		 totalPrice += cartBean.getPrice1()*cartBean.getQuantity();
	}
	   request.setAttribute("totalPrice", totalPrice);//รัพื
	   request.setAttribute("cartlist",list);
	   
	     url = "mypage/cartList.jsp";
   }
   
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
