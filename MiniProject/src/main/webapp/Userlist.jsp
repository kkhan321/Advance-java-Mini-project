<%@page import="miniproject.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
List<User> ulist =(List<User>) session.getAttribute("u");
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
			<table border=3 cellspacing=10px cellpadding=10px>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>email</th>
					<th>contact</th>
					<th>password</th>
				</tr>
				<tr>
					<%
					for (User u : ulist) {
					%>
					<td><%=u.getId()%></td>
					<td><%=u.getName()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getContact()%></td>
					<td><%=u.getPassword()%></td>
					<!--  <td><a href="UserServlet?action=delete&&id=<%=u.getId()%>">delete</a></td>
					<td><a href="UserServlet?action=edit&&id=<%=u.getId()%>">edit</a></td>-->

				</tr>
				<%
				}
				;
				%>
			</table>
			</form>
		</div>
</body>
</html>