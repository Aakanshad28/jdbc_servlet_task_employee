package jdbc_servlet_task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SignUpController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double sal = Double.parseDouble(req.getParameter("sal"));
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setSal(sal);
		employee.setSal(phone);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);

		EmployeeCrud crud = new EmployeeCrud();
		try {
			int count = crud.signUp(employee);
			if (count != 0) {
				PrintWriter out = res.getWriter();
				out.print("Registration Successfull");
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
				dispatcher.forward(req, res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
