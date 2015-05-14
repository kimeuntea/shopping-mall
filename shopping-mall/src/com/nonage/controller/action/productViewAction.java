package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.SetAllPropertiesRule;

import dao.MemberBean;
import dao.MemberDao;
import dao.ProductBean;
import dao.ProductDao;

public class productViewAction implements Action{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String url = "product/productView.jsp";
	ProductDao dao = ProductDao.getInstance();
	ProductBean bean = new ProductBean();
	String pseq = request.getParameter("seq");
	 bean= dao.productdetail(pseq);
	 
	 request.setAttribute("product",bean);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	
}
} 
