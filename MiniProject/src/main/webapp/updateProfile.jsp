<%@page import="miniproject.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
User u = (User) session.getAttribute("u");
%>
<link rel="stylesheet" href="Resources/Css/style.css">
</head>
<body>
	<div id="lside">
		<jsp:include page="leftsidebar.jsp"></jsp:include>
	</div>
	<div id="main">

		<div align=center>
			<h2>welcome to Advance java miniproject</h2>
			<h1>updateprofile</h1>
		</div>
		<div align="center">
			<form action="UserServlet" method="post">
				<input type=hidden name=action value=updateuser>
				<table border=1 cellspacing=10px cellpadding=10px>
					<tr>
						<td>Id</td>
						<td><input type=text Name=id value=<%=u.getId()%>
							       required=required></td>
					</tr>

					<tr>
						<td>Name</td>
						<td><input type=text Name=name value=<%=u.getName()%>
							required=required></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type=email Name=email value=<%=u.getEmail()%>
							required=required></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type=text Name=contact value=<%=u.getContact()%>
							required=required></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type=password Name=password
							value=<%=u.getPassword()%> required=required></td>
					</tr>
					<tr>
					<tr>
						<td><input type=submit value=submit></td>
						<td><input type=reset value=reset></td>
					</tr>


				</table>
			</form>
			<h2>
				<a href=index.jsp>Home</a>
			</h2>
		</div>
</body>
</html>