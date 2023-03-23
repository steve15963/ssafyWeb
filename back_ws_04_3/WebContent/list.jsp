<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<H2> 도서 목록</H2>
<table border="1">
	<tr>
		<th>번호</th>
		<th>ISBN</th>
		<th>저자</th>
		<th>가격</th>
	</tr>

	<c:forEach items="${books}" var="book" varStatus="vs">
	<tr>
		<td>${vs.count}</td>
		<td>${book.isbn}</td>
		<td>${book.author}</td>
		<td>${book.price}</td>
	</tr>
	</c:forEach>
	
</table>
</body>
</html>