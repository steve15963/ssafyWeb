<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>

	<ul>
		<li>
			<a href="${root}/regist.jsp">도서등록</a>
		</li>
		<li>
			<a href="${root}/main?action=list">도서리스트</a>
		</li>
		<li>
			<a href="${root}/modify.jsp">도서수정</a>
		</li>
		<li>
			<a href="${root}/delete.jsp">도서삭제</a>
		</li>
	</ul>
</body>
</html>