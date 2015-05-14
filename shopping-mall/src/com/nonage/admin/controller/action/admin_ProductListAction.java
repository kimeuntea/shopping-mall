package com.nonage.admin.controller.action;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.controller.action.Action;

import dao.PageBean;
import dao.ProductBean;
import dao.ProductDao;

public class admin_ProductListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "admin/product/productList.jsp";
        String key1 = request.getParameter("key");
        String key2 = request.getParameter("key2");
        System.out.println(key2);
        String key=null;
        if
        (key1 != null){
        	key = key1;
        }
	     else
        {
        	
        	key=key2;
        }
        
		ProductDao dao = ProductDao.getInstance();
		
		//pagenumber
		int total = dao.total(key); 
		int pagenumber;
		if(request.getParameter("pagenumber")==null)
				{
		pagenumber =  1;
				}
		else
		{
		pagenumber = Integer.parseInt(request.getParameter("pagenumber"));
		}
		PageBean bean = new PageBean(pagenumber, total);
		
		List<ProductBean> productlist = dao.admin_ProductList(key,bean);
		request.setAttribute("key2", key);
		request.setAttribute("pageStart", bean.getPageStart());
		request.setAttribute("pageEnd", bean.getPageEnd());
		request.setAttribute("pageNumber", bean.getPageNumber());
		request.setAttribute("pageCount", bean.getPageCount());
		request.setAttribute("totalpage", bean.getTotalPage());
		request.setAttribute("bean", bean);
		request.setAttribute("productlist", productlist);
        
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}
}
