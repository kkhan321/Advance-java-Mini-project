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
<%
String lmsg =(String)request.getAttribute("lmsg");
%>
	<div id="lside">
	<jsp:include page="leftsidebar.jsp"></jsp:include>
			</div>
	<div id="main">
	<h2>welcome to Advance java miniproject</h2>
	
	<%if(lmsg!=null){%>
		<h2 style="color: red"><%=lmsg%></h2>
		
      <%}%>
	
	<form action="LoginServlet" method=post>
	<table border=3 cellspacing=10px cellpadding=10px>
	<tr>
	<th>Usertype</th>
	<td>
	<select name=usertype>
	<option>----select user type----</option>
		<option value="Admin">admin</option>
		<option value="user">user</option>
	</select>
	</td>
	</tr>
	<tr>
	<th>Email</th>
	<td><input type=text name="email"></td>
	</tr>
	<tr>
	<th>password</th>
	<td><input type="password" name="password"></td>
	</tr>
	<tr>
	<th><input type="submit" value="login"></th>
	<td><input type="reset" name="reset"></td>
	</tr>
	</table>
	</form>
	
	</div>
	
</body>
</html>