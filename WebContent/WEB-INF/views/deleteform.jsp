<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<!-- no값을 controller에게 전달해주기 위해 파라미터로 값을 저장 passwd는 post로 action요청은 get방식으로 요청된다. -->
	<form method="post" action="<%=request.getContextPath()%>/gb?a=delete">
	<input type='hidden' name="no" value=<%=request.getParameter("no") %>>
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="<%=request.getContextPath() %>/gb">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
	
</body>
</html>