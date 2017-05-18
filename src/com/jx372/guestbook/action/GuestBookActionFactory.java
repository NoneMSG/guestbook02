package com.jx372.guestbook.action;

import com.jx372.web.action.Action;
import com.jx372.web.action.ActionFactory;
//추상화되어있는 ActionFactory를 상속받아
public class GuestBookActionFactory extends ActionFactory{

	//메서드 오버라이딩을 통해서 여러가지 기능을 수행하도록 한다.
	@Override
	public Action getAction(String actionName) {
		//클라이언트로 부터 요청받은 문자열 명령을 파라미터 값으로 전달받는다
		//Factory 패턴에 맞도록 Action값으로 액션별 값을 반환하기위해서 객체선언
		Action action = null; 
		//문자열 명령에 따른 기능을 위한 조건문
		if("add".equals(actionName)){
			action = new AddAction();
		 }else if("deleteform".equals(actionName)){
			 action = new DeleteFormAction();
		 }else if("delete".equals(actionName)){
			 action = new DeleteAction();
		 }else{
			 //기본페이지 추가,삭제 명령을 제외한 모든 요청은 이 페이지로 들어온다.
			 action = new ListAction();
		 }
		return action;
	}
	
}
