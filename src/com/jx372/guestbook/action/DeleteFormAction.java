package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.web.action.Action;
import com.jx372.web.util.WebUtils;

public class DeleteFormAction implements Action {
//delete를 요청받으면 deleteform페이지로 이동시키고 데이터를 옮겨주는 작업을 한다. 실제 삭제는 delete에서 이루어짐
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		WebUtils.forward("/WEB-INF/views/deleteform.jsp", request, response);
	}

}
