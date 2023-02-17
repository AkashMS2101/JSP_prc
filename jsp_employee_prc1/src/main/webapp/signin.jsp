<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="signin" method="post">
	
		<table>
			<tbody>
				<tr>
					<td> <label for="name">Name : </label> </td>
					<td><input type="text" name="name" placeholder="enter your name"></td>
				</tr>
				<tr>
					<td> <label for="address">Address : </label> </td>
					<td><input type="text" name="address" placeholder="enter your address"></td>
				</tr>
				<tr>
					<td> <label for="email">Email : </label> </td>
					<td><input type="email" name="email" placeholder="enter your email"></td>
				</tr>
				<tr>
					<td> <label for="password">Password : </label> </td>
					<td><input type="password" name="password" placeholder="enter your password"></td>
				</tr>
				<tr>
					<td> <label for="phone">Phone number : </label> </td>
					<td><input type="tel" name="phone" placeholder="enter your phonenumber"></td>
				</tr>
				<tr>
					<td><input type="submit"></td>
				</tr>
				
			</tbody>
		</table>
	</form>
</body>
</html>