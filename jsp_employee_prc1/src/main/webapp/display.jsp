<%@page import="jsp_employee_prc1.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String message1 = (String)request.getAttribute("c_name");%>
	changed by<%=  message1 %>
	<table border="2px">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
		</thead>
		
		<tbody>
		<% List<Employee>employees=(List)request.getAttribute("lists"); %>
			<%for(Employee employee:employees){ %>
				<tr>
					<td><%= employee.getId() %></td>
					<td><%= employee.getName() %></td>
					<td><%= employee.getEmail() %></td>
					<td><%= employee.getPassword() %></td>
					<td><%= employee.getAddress() %></td>
					<td><%= employee.getPhone() %></td>
					<td><a href="delete?id=<%= employee.getId() %>"><button>Delete</button> </a> </td>
					<td><a href="update?id=<%= employee.getId() %>"><button>Update</button> </a> </td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>