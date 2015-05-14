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

public class CartDeleteAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
   String url = "NonageServlet?command=cartlist";
   CartDao dao = CartDao.getInstance();
   
   String []check = request.getParameterValues("cseq");
   System.out.println(check);
  /* 
   for(int i =0 ; i<check.length;i++)
   {
	   dao.cartdelete(Integer.parseInt(check[i]));
   }*/
    for (String str : check) {
		dao.cartdelete(Integer.parseInt(str));
	}
   
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
}
