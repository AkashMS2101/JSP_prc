<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String message = (String)request.getAttribute("message");%>
	<% if(message!=null){ %>
	<%=  message %>
	<%} %>
	<form action="login" method="post">
		<table>
			<tbody>
				<tr>
					<td> <label for="email">Email</label> </td>
					<td> <input type="email" name="email" placeholder="enter your mail id"></td>
				</tr>
				<tr>
					<td> <label for="password">Password</label> </td>
					<td> <input type="password" name="password" placeholder="enter password"> </td>
				</tr>
				<tr>
					<td> <input type="submit" value="Login"> </td> 
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>