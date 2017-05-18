package com.jx372.guestbook.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.guestbook.dao.GuestBookDao;
import com.jx372.guestbook.vo.GuestBookVo;
import com.jx372.web.action.Action;
import com.jx372.web.util.WebUtils;

public class ListAction implements Action {
	//기본페이지로 가기위한 클래스
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//DB에 연결되어있는(MySQL) 데이터를 가져오는 list 자료구조 Data Acessce Object를 통해서 데이터를 query문을 통해서 가져온다.
		List<GuestBookVo> list = new GuestBookDao().getList();
		//view에게 데이터를 전송해주기 위해 setAttribute해준다.
		request.setAttribute("list", list);
		//forward를 통해서 데이터를 실질적으로 전달하고 페이지를 불러온다.
		WebUtils.forward("/WEB-INF/views/index.jsp", request, response);

	}

}
