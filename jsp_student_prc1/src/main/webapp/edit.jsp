<%@page import="jsp_student_prc1.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="edit" method="post">
	
	<%Student student =(Student)request.getAttribute("student");%>
	
	Eid: <input type="number" name="id" placeholder="enter student id" value=<%=student.getId()%> readonly="readonly"><br>
	Name: <input type="text" name="name" placeholder="enter student name" value=<%=student.getName()%> ><br>
	FatherName: <input type="text" name="fathername" placeholder="enter student's father name" value=<%=student.getFathername()%>><br>
	Email: <input type="email" name="email" placeholder="enter student mail" value=<%=student.getEmail()%>><br>
	Password: <input type="password" name="password" placeholder="enter password" value=<%=student.getPassword()%>><br>
	Phonenumber: <input type="tel" name="phone" placeholder="enter phone number" value=<%=student.getPhone()%>><br>
	<input type="submit">
	</form>
</body>
</html>