package jdbc_servlet_task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeCrud crud = new EmployeeCrud();
		try {
			String dbPassword = crud.getEmployee(email);
			PrintWriter out = resp.getWriter();
			if (dbPassword != null) {
				if (password.equals(dbPassword)) {
					// out.print("Login Successful");
					RequestDispatcher dispatcher = req.getRequestDispatcher("Home.html");
					dispatcher.forward(req, resp);
				} else {
					RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
					dispatcher.forward(req, resp);
				}

			} else {
				// out.print("User not found,please register")
				RequestDispatcher dispatcher = req.getRequestDispatcher("SignUp.html");
				dispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
