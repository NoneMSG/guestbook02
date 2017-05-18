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
	//delete요청이 온다면 여기서 실행된다.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//문자열로 데이터를 받고
		String passwd = request.getParameter("passwd");
		Long no = Long.parseLong(request.getParameter("no"));
		
		//vo에 값을 전달하고
		GuestBookVo vo = new GuestBookVo();
		vo.setNo(no);
		vo.setPasswd(passwd);
		//DAO를 통해서 DB의 데이터를 삭제한다.
		new GuestBookDao().delete(vo);
		//데이터의 삽입 삭제 갱신이 이루어지면 페이지를 이동시켜야 중복된 작업을 안 한다.
		WebUtils.redirect(request.getContextPath()+"/gb", request, response);
		
	}

}
