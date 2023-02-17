package jsp_employee_prc1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp_employee_prc1.dao.EmployeeDao;
import jsp_employee_prc1.dto.Employee;

@WebServlet("/login")
public class EmployeeLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.loginEmployee(email);
		if ((employee.getPassword()).equals(password)) {
			
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("name", employee.getName());
			
			Cookie cookie = new Cookie("c_name",employee.getName());
			resp.addCookie(cookie);
			
			List<Employee> list = dao.getListofEmployee();
			req.setAttribute("lists", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("message", "invalid password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}
}

