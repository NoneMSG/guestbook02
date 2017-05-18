package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.guestbook.dao.GuestBookDao;
import com.jx372.guestbook.vo.GuestBookVo;
import com.jx372.web.action.Action;
import com.jx372.web.util.WebUtils;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String message = request.getParameter("message");

		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPasswd(passwd);
		vo.setMessage(message);
		
		new GuestBookDao().insert(vo);
		WebUtils.redirect(request.getContextPath()+"/gb", request, response);
		
	}

}
