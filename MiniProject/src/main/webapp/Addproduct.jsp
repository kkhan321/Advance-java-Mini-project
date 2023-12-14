<%@page import="miniproject.pojo.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%List<Category> clist=(List<Category>)session.getAttribute("c");%>

<link rel="stylesheet" href="Resources/Css/style.css">
</head>
<body>
	<div id="lside">
	<jsp:include page="leftsidebar.jsp"></jsp:include>
			</div>
	<div id="main">	
    <div align="center">
	<h1>Add Product</h1>
	<form action="ProducttServlet" method ="post">
	<input type=hidden name=action value=addproduct>
		<table border=1 cellspacing=10px cellpadding=10px>
		<tr>
		<td>ProductName</td>
		<td><input type=text Name=productname ></td>
		</tr>
		<tr>
		<td>price</td>
		<td><input type=number Name=price ></td>
		</tr>
		<tr>
		<td>description</td>
		<td><textarea cols="20" rows="5" Name=description></textarea></td>
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
</div>
	
	</div>

</body>

</body>
</html>