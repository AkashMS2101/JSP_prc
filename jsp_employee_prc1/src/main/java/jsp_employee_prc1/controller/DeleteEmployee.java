package jsp_employee_prc1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_employee_prc1.dao.EmployeeDao;
import jsp_employee_prc1.dto.Employee;

@WebServlet("/delete")
public class DeleteEmployee extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao dao = new EmployeeDao();
		boolean b= dao.deleteEmployee(id);
		if(b) {
			List<Employee>list = dao.getListofEmployee();
			req.setAttribute("lists", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
