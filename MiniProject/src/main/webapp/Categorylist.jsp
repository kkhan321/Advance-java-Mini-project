<%@page import="miniproject.pojo.Category"%>
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
List<Category> clist = (List<Category>) session.getAttribute("c");
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
					<th>description</th>
					<th colspan=2>Action</th>
				</tr>
				<tr>
					<%
					for (Category c : clist) {
					%>
					<td><%=c.getId()%></td>
					<td><%=c.getName()%></td>
					<td><%=c.getDescription()%></td>
					<td><a href="CategoryServlet?action=delete&&id=<%=c.getId()%>">delete</a></td>
					<td><a href="CategoryServlet?action=edit&id=<%=c.getId()%>">edit</a></td>

				</tr>
				<%
				}
				;
				%>
			</table>
		</div>
	</div>
</body>
</html>