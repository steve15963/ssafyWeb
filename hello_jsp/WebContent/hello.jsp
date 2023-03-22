<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<%! int count=5; %>
		<ul>
			<% 
			//implicit object - request  :httpservletRequest
			//implicit object - response :httpservletResponse
			//implicit object - pageContext : pageContext
			//implicit object - session: httpsession
			//implicit object - application:serveltConfig
			//implicit object - config : servletconfig
			//implicit object - page : object
			//implicit object - out - jspWriter
			//exception : throwable
				for(int i = 1 ; i <= count; i++){ 
			%>
				<li><%= i %></li>
			<% } %>
		</ul>
	</body>
</html>