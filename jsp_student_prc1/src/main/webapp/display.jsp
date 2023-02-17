<%@page import="jsp_student_prc1.dto.Student"%>
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
	<table border="2px" >
		<thead>
			<tr>
				<th>S-Id</th>
				<th>S-Name</th>
				<th>S_Father-Name</th>
				<th>S-Email</th>
				<th>S-Password</th>
				<th>Phone</th>
				<th>S-fee</th>
				<th>delete</th>
				<th>update</th>
			</tr>
		</thead>
		
		<tbody>
		<%List<Student> students=(List)request.getAttribute("lists");%>
		<%for(Student student:students){ %>
				<tr>
					<td><%= student.getId()%></td>
					<td><%= student.getName()%></td>
					<td><%= student.getFathername()%></td>
					<td><%= student.getEmail()%></td>
					<td><%= student.getPassword()%></td>
					<td><%= student.getPhone()%></td>
					<td><%= student.getFee()%></td>
					<td><a href="delete?id=<%= student.getId() %>"><button>Delete</button> </a> </td>
					<td><a href="update?id=<%= student.getId() %>"><button>Update</button> </a> </td>
				</tr>
			<%} %>
		</tbody>
	</table>	
</body>
</html>