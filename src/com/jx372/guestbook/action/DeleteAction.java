package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.guestbook.dao.GuestBookDao;
import com.jx372.guestbook.vo.GuestBookVo;
import com.jx372.web.action.Action;
import com.jx372.web.util.WebUtils;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String passwd = request.getParameter("passwd");
		Long no = Long.parseLong(request.getParameter("no"));
				
		
		GuestBookVo vo = new GuestBookVo();
		vo.setNo(no);
		vo.setPasswd(passwd);

		new GuestBookDao().delete(vo);
		
		WebUtils.redirect(request.getContextPath()+"/gb", request, response);
		
	}

}
