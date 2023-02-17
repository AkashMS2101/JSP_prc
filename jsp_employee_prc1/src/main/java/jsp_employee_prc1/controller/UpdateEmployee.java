package jsp_employee_prc1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp_employee_prc1.dao.EmployeeDao;
import jsp_employee_prc1.dto.Employee;

@WebServlet("/update")
public class UpdateEmployee extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.getEmployeeByid(id);
		if(employee!=null) {
			HttpSession httpSession = req.getSession();
			String name = (String)httpSession.getAttribute("name");
			if(name!=null) {
			req.setAttribute("employee", employee);
			RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
			dispatcher.forward(req, resp);
			}else {
				req.setAttribute("message", "Login first to update");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}
		}
	}
}
