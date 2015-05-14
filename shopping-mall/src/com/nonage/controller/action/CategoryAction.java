package com.nonage.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductBean;
import dao.ProductDao;

public class CategoryAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "product/productList.jsp";
		String kind = request.getParameter("kind").trim();

		ProductDao dao = ProductDao.getInstance();
		List<ProductBean> productlist = dao.ProductList(kind);
		request.setAttribute("productlist", productlist);
        
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
