<%@page import="miniproject.pojo.Category"%>
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
List<Product> productlist = (List<Product>) session.getAttribute("k");
List<Category> clist = (List<Category>) session.getAttribute("c");

%>
<link rel="stylesheet" href="Resources/Css/style.css">
</head>
<body>
	<div id="lside">
		<jsp:include page="leftsidebar.jsp"></jsp:include>
	</div>
	<div id="main">
	<h1>Welcome to Advance java mini-project</h1>
				<!-- making search -->
          
		<form action="ProducttServlet" method="post">
		<input type="hidden" name=action value=searchproduct>
			<table cellspacing=10px cellpadding=10px>
				<tr>
					<td><textarea rows="2" cols="40" name=search></textarea></td><!-- making search -->
					<td><input type="submit" value="SEARCH">
				</tr>
			</table>
		</form>
		<br>

		<div>

			<table border=2 cellspacing=5px cellpadding=5px>
				<tr>
					<th>productId</th>
					<th>productname</th>
					<th>price</th>
					<th>description</th>
					<th>categoryName</th>
					<th>categorydescription</th>
					<th colspan=2>Action</th>

				</tr>
				<tr>
					<%
					for (Product p : productlist) {
					%>
					<td><%=p.getId()%></td>
					<td><%=p.getProductName()%></td>
					<td><%=p.getPrice()%></td>
					<td><textarea rows="3" cols="15"><%=p.getDescription()%></textarea></td>
					<td><%=p.getCategory().getName()%></td>
					<td><textarea rows="3" cols="15"><%=p.getCategory().getDescription()%></textarea></td>
					<td><a href="ProducttServlet?action=delete&&id=<%=p.getId()%>">delete</a></td>
					<td><a href="ProducttServlet?action=edit&&id=<%=p.getId()%>">edit</a></td>


				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
	<!-- making category sort by id we can get the data by clicking on categoryname -->
	<style>
	#rside{
	width:150px;
	height: 100%;
	background: aqua;
	text-align: center;
	position: fixed;
	right: 0%;
	top:0%;
	}
	
	</style>
	
	<div id="rside">
	<h2>sort by category</h2>
	<%for(Category c: clist){ %>
	<h3><a href="ProducttServlet?action=sort&&cid=<%=c.getId()%>"><%=c.getName()%></a></h3>
	<%} %>
	</div>
</body>
</html>