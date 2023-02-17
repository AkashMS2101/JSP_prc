package jsp_student_prc1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_student_prc1.dao.StudentDao;
import jsp_student_prc1.dto.Student;

@WebServlet("/edit")
public class EditStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id = Integer.parseInt(req.getParameter("id"));
		 String name=req.getParameter("name");
		 String fathername=req.getParameter("fathername");
		 String email = req.getParameter("email");
		 String password = req.getParameter("password");
		 long phone = Long.parseLong(req.getParameter("phone"));
		 
		 Student student= new Student();
		 student.setId(id);
		 student.setEmail(email);
		 student.setFathername(fathername);
		 student.setName(name);
		 student.setPassword(password);
		 student.setPhone(phone);
		 ServletContext context = getServletContext();
		 double fee = Double.parseDouble(context.getInitParameter("fee"));
		 student.setFee(fee);
		 
		 StudentDao dao = new StudentDao();
		 Student student2= dao.updateStudent(student);
		 if(student2!=null) {
			 List<Student>list=dao.getListofStudent();
			 req.setAttribute("lists", list);
			 RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			 dispatcher.forward(req, resp);
		 }else {
			 RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			 dispatcher.forward(req, resp);
		 }
	}
}
