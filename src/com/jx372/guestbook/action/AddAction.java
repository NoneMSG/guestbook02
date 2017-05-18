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
	//add요청이 들어온다면 여기서 로직이 실행된다.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//getParameter 함수로 view단에 있는 name, passwd, message요소에 있는 값들을 가져온다
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String message = request.getParameter("message");
		
		//가져온 값들을 value object에 넣어 실질적으로 값을 DB에 전달할 준비를한다.
		GuestBookVo vo = new GuestBookVo();
		//값을 vo객체에 전달하여 DB에전송할 준비를 마친다.
		vo.setName(name);
		vo.setPasswd(passwd);
		vo.setMessage(message);
		//VO객체에 저장된 데이터를 DAO를 통해서 query문을 DB로 요청해서 데이터를 저장.
		new GuestBookDao().insert(vo);
		//데이터가 저장되면 중복된 데이터 전송을 막기위해 페이지를 다른곳으로 이동시켜준다.
		WebUtils.redirect(request.getContextPath()+"/gb", request, response);
		
	}

}
