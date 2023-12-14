<%@page import="miniproject.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
List<Product> plist=(List<Product>)session.getAttribute("p");
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
				<th>productId</th>
				<th>productname</th>
				<th>price</th>
				<th>description</th>
				<th>categoryName</th>
							</tr>
			<tr>
				<%for(Product p:plist){ %>
				<td><%=p.getId()%></td>
				<td><%=p.getProductName()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getDescription()%></td>
				<td><%=p.getCategoryName()%></td>
				<!-- <td><a href="ProducttServlet?action=delete&&id=<%=p.getId()%>">delete</a></td>
				<td><a href="ProducttServlet?action=edit&&id=<%=p.getId()%>">edit</a></td>-->

			</tr>
			<%} %>
		</table>
	</div>

</body>
</html>