package com.nonage.admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.controller.action.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductBean;
import dao.ProductDao;

public class admin_ProductWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "NonageServlet?command=admin_product_list";
		String image = "C:\\Program Files (x86)\\programing\\jsp10\\shopping-mall\\WebContent";
		int size = 1024*1024*5;
		String encoding = "EUC-KR";
		MultipartRequest multi = new MultipartRequest(
				request, 
				image, 
				size,
				encoding,
				new DefaultFileRenamePolicy()
				);
		ProductBean bean = new ProductBean();
		bean.setName(multi.getParameter("name"));
		bean.setContent(multi.getParameter("content"));
		bean.setPrice1(Integer.parseInt(multi.getParameter("price")));
		bean.setKind(multi.getParameter("kind"));
	    bean.setImage(multi.getFilesystemName("image"));
	    
	    ProductDao dao = ProductDao.getInstance(); 
	    dao.productwrite(bean);

		response.sendRedirect(url);
		// TODO Auto-generated method stub

	}
}
