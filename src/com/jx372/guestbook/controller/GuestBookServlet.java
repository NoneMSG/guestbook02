package com.jx372.guestbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.guestbook.action.GuestBookActionFactory;
import com.jx372.web.action.Action;
import com.jx372.web.action.ActionFactory;
import com.jx372.web.util.WebUtils;

@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter("a");
		ActionFactory gBAF= new GuestBookActionFactory();
		Action action = gBAF.getAction(actionName);;
		action.execute(request, response);
		
		

	}


}
