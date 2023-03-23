<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.ws.step3.dto.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style>
	#title{
		text-align: center;
	}
	#user-info{
        text-align: right;
    }
	</style>
	<div>
	<h1 class="title">
		SSAFY 도서 관리
	</h1>
	</div>
	<div class="user-info">
		<%
			User user = (User) session.getAttribute("user");
			if(user == null){
		%>
		<%-- 로그인 : session에 저장된 user객체가 없는 경우 --%>
		<form action="main" method="post">
			<input type="hidden" name="action" value="login"/>
			<input type="text" name="id" placeholder="아이디"/>
			<input type="password" name="pass" placeholder="비밀번호">
			<input type="submit" value="로그인"/>
		</form>
		<% } else{ %>
		<%-- 로그인 : session != null --%>
			<%= user.getName() %>님 반갑습니다.
			<a href="main?action=Logout">로그아웃</a>
		<% } %>
	</div>
	<hr/>
</body>
</html>