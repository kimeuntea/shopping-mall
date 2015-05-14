package com.nonage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.controller.action.Action;


@WebServlet("/NonageServlet")
public class NonageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NonageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command =  request.getParameter("command");
		System.out.println("NonageServlet : "+ command);
		
		ActionFactory af = ActionFactory.getInstance();
		Action action =af.getAction(command);;
		
		if(action != null)
		{
			action.execute(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
