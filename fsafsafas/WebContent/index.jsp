<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<!-- 메인화면을 구현하세요 -->
	<h1>사용자관리 페이지 JSTL_EL</h1>
	

	<ul>
		<li>
			<a href="main?action=regist">사용자등록</a>
		</li>
		<li>
			<a href="main?action=list">사용자리스트</a>
		</li>
		<li>
			<a href="modify.jsp">사용자수정</a>
		</li>
		<li>
			<a href="delete.jsp">사용자삭제</a>
		</li>
	</ul>
</body>
</html>