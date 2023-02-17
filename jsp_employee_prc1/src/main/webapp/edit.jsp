<%@page import="jsp_employee_prc1.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
</body>
<% Employee employee =(Employee)request.getAttribute("employee"); %>
</html><form action="edit" method="post">
	
		<table>
			<tbody>
			<tr>
					<td> <label for="id">id : </label> </td>
					<td><input type="number" name="id" placeholder="enter your id" value=<%=employee.getId() %> readonly="readonly"></td>
				</tr>
				<tr>
					<td> <label for="name">Name : </label> </td>
					<td><input type="text" name="name" placeholder="enter your name"  value=<%=employee.getName() %>></td>
				</tr>
				<tr>
					<td> <label for="address">Address : </label> </td>
					<td><input type="text" name="address" placeholder="enter your address"  value=<%=employee.getAddress() %>></td>
				</tr>
				<tr>
					<td> <label for="email">Email : </label> </td>
					<td><input type="email" name="email" placeholder="enter your email"  value=<%=employee.getEmail() %>></td>
				</tr>
				<tr>
					<td> <label for="password">Password : </label> </td>
					<td><input type="password" name="password" placeholder="enter your password"  value=<%=employee.getPassword() %>></td>
				</tr>
				<tr>
					<td> <label for="phone">Phone number : </label> </td>
					<td><input type="tel" name="phone" placeholder="enter your phonenumber"  value=<%=employee.getPhone() %>></td>
				</tr>
				<tr>
					<td><input type="submit"></td>
				</tr>
				
			</tbody>
		</table>
	</form>