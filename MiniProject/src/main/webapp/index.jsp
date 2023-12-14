<%@page import="miniproject.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Resources/Css/style.css">
</head>
<%
User user = (User) session.getAttribute("user");
%>
<body>
	<div id="lside">
		<jsp:include page="leftsidebar.jsp"></jsp:include>
	</div>
	<div id="main">
		<%
		if (user != null) {
		%>
		<h2>welcome:<span style="color:red;font-size: 40px"><%=user.getName() %> </span> </h2>

		<%
		} else{
		%>
		<h2>welcome to Advance java miniproject</h2>
		<%} %>
	</div>

</body>
</html>