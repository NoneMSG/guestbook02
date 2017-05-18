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
//패스를 gb로 설정
@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩설정
		request.setCharacterEncoding("utf-8");
		//view로부터 전달되는 요청을 받기위한 action변수 폼 a에저장된 값을 가져온다
		String actionName = request.getParameter("a");
		//각 action별로 로직을 설정하기 위해 factory mathod pattern 객체를 사용
		ActionFactory gBAF= new GuestBookActionFactory();
		//인터페이스와 추상클래스로 작성된 팩토리 메서드 패턴을 이용하여 인터페이스를 구체화 하고 클래스를 상속받는 
		//action 기능들의 객체를 각 action에 맞게 받아온다.
		Action action = gBAF.getAction(actionName);;
		//해당 action을 실행시키는 함수
		action.execute(request, response);

	}


}
