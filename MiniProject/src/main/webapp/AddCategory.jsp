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
	<div align=center>

		<div id="lside">
			<jsp:include page="leftsidebar.jsp"></jsp:include>
		</div>

		<div id="main">
			<h1>Add category</h1>
			<div align="center">
				<form action="CategoryServlet" method="post">
					<input type=hidden name=action value=addcategory>
					<table border=1 cellspacing=10px cellpadding=10px>
						<tr>
							<td>Name</td>
							<td><input type=text Name=name required=required></td>
						</tr>
						<tr>
							<td>description</td>
							<td><textarea name=description rows="5" cols="20"></textarea></td>
						</tr>

						<td><input type=submit value=submit></td>
						<td><input type=reset value=reset></td>
						</tr>


					</table>
				</form>
			</div>
		</div>
	</div>

</body>
</html>