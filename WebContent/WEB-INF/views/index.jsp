<%@page import="java.util.List"%>
<%@page import="com.jx372.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//controller로 부터 forawrd된 데이터를 list자료구조 객체에 저장
	List<GuestBookVo> list = //getAttribute함수에는 배열로 데이터가 저장되어 있기때문에 다운 캐스팅이필요
		(List<GuestBookVo>)request.getAttribute("list");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<!-- action값을 컨트롤러에 전달해주기 위해 기본경로에 gb어노테이션으로 a의 값을 전달  -->
	<form action="<%=request.getContextPath() %>/gb" method="post">
	<input type="hidden" name="a" value="add"/>
	<table border="1" width="500">
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="4"><textarea name="message" cols="60" rows="5"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right"><input type="submit" VALUE=" 등록 "></td>
		</tr>
	</table>
	</form>
	<br>
	<!-- 저장된 데이터를 컨트롤로부터 받아와 보여준다.  -->
	<%
		int index = 0;
		for(GuestBookVo vo : list){
	%>
	<table width="510" border="1">
		<tr>
		<td><%=index-- +list.size() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getRegDate() %></td>
			<!-- 삭제를 하기위해 컨트롤에 요청한다. 데이터를 식별하기 위한 no값을 get으로 같이 전달-->
			<td><a href="<%=request.getContextPath()%>/gb?a=deleteform&no=<%=vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4"><%=vo.getMessage().replaceAll("\n", "<br>") %></td>
		</tr>
	</table>
	<br/>
	<%
		}
	%>
</body>
</html>