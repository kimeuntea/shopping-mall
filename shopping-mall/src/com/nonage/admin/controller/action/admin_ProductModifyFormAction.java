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

public class admin_ProductModifyFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "admin/product/productModifyForm.jsp";
        String pseq = request.getParameter("pseq");
        ProductBean bean = new ProductBean();
        ProductDao dao = ProductDao.getInstance();
        bean = dao.productdetail(pseq);
        request.setAttribute("product", bean);
        String kindlist[] = {"상위","하위","악세사리","세일"}; 
        request.setAttribute("kindlist", kindlist);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
