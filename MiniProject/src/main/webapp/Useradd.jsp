<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="Resources/Css/style.css">
</head>
<body>
	<div id="lside">
	<jsp:include page="leftsidebar.jsp"></jsp:include>
			</div>
	<div id="main">

    <div align="center">
    <h1>Register</h1>
	<form action="UserServlet" method ="post">
	<input type=hidden name=action value=adduser>
		<table border=1 cellspacing=10px cellpadding=10px>
		<tr>
		<td>Name</td>
		<td><input type=text Name=name required=required></td>
		</tr>
		<tr>
		<td>Email</td>
		<td><input type=email Name=email required=required></td>
		</tr>
		<tr>
		<td>Contact</td>
		<td><input type=text Name=contact required=required></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type=password Name=password required=required></td>
		</tr>
		<tr>
        <tr>
		<td><input type=submit value=submit></td>
		<td><input type=reset value=reset></td>
		</tr>
		

		</table>
	</form>
	<h2><a href=index.jsp>Home</a></h2>
</div>
</div>
</body>
</html>