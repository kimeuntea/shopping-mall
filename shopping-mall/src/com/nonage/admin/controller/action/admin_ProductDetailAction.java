package com.nonage.admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.controller.action.Action;

import dao.ProductBean;
import dao.ProductDao;

public class admin_ProductDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "admin/product/productdetail.jsp";
        String pseq = request.getParameter("pseq");
        String pagenumber = request.getParameter("pagenumber");
        String key2 = request.getParameter("key2");
		ProductDao dao = ProductDao.getInstance();
		ProductBean bean = dao.productdetail(pseq);
		
		request.setAttribute("product", bean);
        request.setAttribute("pageNumber", pagenumber);
        request.setAttribute("key2", key2);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
