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

@WebServlet("/delete")
public class DeleteStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		StudentDao dao = new StudentDao();
		boolean b = dao.deleteStudent(id);
		if (b) {
			List<Student> list = dao.getListofStudent();
			req.setAttribute("lists", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
