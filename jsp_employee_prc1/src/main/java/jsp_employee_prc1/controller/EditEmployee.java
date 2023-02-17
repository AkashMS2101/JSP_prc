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

import jsp_employee_prc1.dao.EmployeeDao;
import jsp_employee_prc1.dto.Employee;

@WebServlet("/edit")
public class EditEmployee extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String passsword = req.getParameter("password");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));

		Employee employee = new Employee();
		employee.setId(id);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setName(name);
		employee.setPassword(passsword);
		employee.setPhone(phone);
		
		EmployeeDao dao = new EmployeeDao();
		Employee employee2 = dao.updateEmployee(employee);
		if(employee2!=null) {
			List<Employee>list=dao.getListofEmployee();
			req.setAttribute("lists", list);
			
			
			Cookie[] cookies = req.getCookies();
			String value =null;
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("c_name")) {
					value=cookie.getValue();
				}
			}
			req.setAttribute("c_name", value);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
			
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
