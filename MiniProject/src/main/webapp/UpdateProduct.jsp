<%@page import="java.util.List"%>
<%@page import="miniproject.pojo.Category"%>
<%@page import="miniproject.pojo.Product"%>
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
Product p=(Product)session.getAttribute("k"); 
  List<Category> clist=(List<Category>)session.getAttribute("c");
%>
<body>
<div align=center><h1>updateprofile</h1></div>
    <div align="center">
	<form action="ProducttServlet" method ="post">
	<input type=hidden name=action value=updateproduct>
		<table border=1 cellspacing=10px cellpadding=10px>
		<tr>
		<td>Id</td>
		<td><input type=text Name=id value=<%=p.getId()%> required=required></td>
		</tr>
		
		<tr>
		<td>ProductName</td>
		<td><input type=text Name=productname value=<%=p.getProductName()%> required=required></td>
		</tr>
		<tr>
		<td>price</td>
		<td><input type=Number Name=price value=<%=p.getPrice()%> required=required></td>
		</tr>
		<tr>
		<td>description</td>
		<td><input type=text Name=description value=<%=p.getDescription()%> required=required></td>
		</tr>
		<tr>
		<td>CategoryId</td>
		<td><select name="categoryid">
		<option value="0">---select category----</option>
		<%for(Category c:clist){ %>
		<option value="<%=c.getId()%>"><%=c.getName()%></option>
		<%} %>
		</select></td>
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

</body>
</html>