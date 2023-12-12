package jdbc_servlet_task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("sal"));
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Employee employee=new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setSal(phone);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);
		
		EmployeeCrud crud=new EmployeeCrud();
		
		try {
			int count=crud.updateEmployee(employee);
			if (count!=0) {
				PrintWriter out=res.getWriter();
				out.print("updated successfully");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
