package com.nonage.controller.action;

import java.io.IOException;
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

public class CartinsertAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
   HttpSession session = request.getSession();
   String url = "";
   CartBean bean = new CartBean();
   CartDao dao = CartDao.getInstance();
   int pseq = Integer.parseInt(request.getParameter("pseq"));
   int quantity = Integer.parseInt(request.getParameter("quantity"));
   String id = (String) session.getAttribute("id");
   
   if(session.getAttribute("id")==null)
   {
	   url = "member/LoginForm.jsp";
   }
   else
   {
	   
	   bean.setPseq(pseq);
	   bean.setId(id);
	   bean.setQuantity(quantity);
	   dao.cartinsert(bean);
	   
	   url = "NonageServlet?command=cartlist";
   }
   
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
