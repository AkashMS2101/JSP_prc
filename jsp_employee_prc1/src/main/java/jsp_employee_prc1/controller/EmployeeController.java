package jsp_employee_prc1.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jsp_employee_prc1.dao.EmployeeDao;
import jsp_employee_prc1.dto.Employee;

@WebServlet("/signin")
public class EmployeeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String passsword = req.getParameter("password");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));

		Employee employee = new Employee();
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setName(name);
		employee.setPassword(passsword);
		employee.setPhone(phone);

		EmployeeDao dao = new EmployeeDao();
		Employee employee2 = dao.saveEmployee(employee);

		if (employee2 != null) {
			req.setAttribute("message", "sign up successfully");
			req.setAttribute("name1", name);
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}