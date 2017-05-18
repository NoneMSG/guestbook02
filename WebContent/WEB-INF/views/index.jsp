<%@page import="java.util.List"%>
<%@page import="com.jx372.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/gb?a=add" method="post">
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
	<%
		int index = 0;
		for(GuestBookVo vo : list){
	%>
	<table width="510" border="1">
		<tr>
		<td><%=index-- +list.size() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getRegDate() %></td>
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