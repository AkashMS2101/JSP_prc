package jsp_student_prc1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_student_prc1.dao.StudentDao;
import jsp_student_prc1.dto.Student;

@WebServlet("/login")
public class LoginStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDao dao = new StudentDao();
		Student student = dao.loginStudent(email);
		if((student.getPassword()).equals(password)) {
			List<Student> list = dao.getListofStudent();
			req.setAttribute("lists", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}else {
			req.setAttribute("message", "invalid password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);	
		}
	}
}