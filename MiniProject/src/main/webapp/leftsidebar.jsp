<%@page import="miniproject.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String admin = (String) session.getAttribute("Admin");
User user = (User) session.getAttribute("user");
//System.out.println(admin);
System.out.println(user);
%>
<body>
	<h2>
		<a href="index.jsp">Home</a>
	</h2>
	<%
	if (user != null && admin == null) {
	%>
	<h2>
		<a href="UserServlet?action=edit&&id=<%=user.getId()%>">UpdateProfile</a>
	</h2>
	<h2>
		<a href="UserServlet?action=delete&&id=<%=user.getId()%>">deleteProfile</a>
	</h2>
	
	<h2>
		<a href="ProducttServlet?action=add">Addproduct</a>
	</h2>
	<h2>
		<a href="ProducttServlet?action=list">productlist2</a>
	</h2>
	<h2>
		<a href=AddCategory.jsp>AddCategory</a>
	</h2>
	<h2>
		<a href=CategoryServlet>Categorylist</a>
	</h2>
	<h2>
		<a href="ProducttServlet?">productlist</a>
	</h2>
	<%
	}
	if (user == null && admin != null) {
	%>
	<h2>
		<a href="UserServlet">Userlist</a>
	</h2>
	<%
	}
	if (user == null && admin == null) {
	%>
	<h2>
		<a href=Useradd.jsp>Register</a>
	</h2>
	<h2>
		<a href="login.jsp">login</a>
	</h2>
	<%
	}
	if (user != null || admin != null) {
	%>
	<h2>
		<a href="LoginServlet">logout</a>
	</h2>
	<%
	}
	;
	%>
</body>
</html>
