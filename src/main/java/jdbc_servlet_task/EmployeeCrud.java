package jdbc_servlet_task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeCrud {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
		return connection;
	}

	public int signUp(Employee employee) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setDouble(4, employee.getSal());
		preparedStatement.setLong(5, employee.getPhone());
		preparedStatement.setString(6, employee.getAddress());
		preparedStatement.setString(7, employee.getEmail());
		preparedStatement.setString(8, employee.getPassword());

		int count = preparedStatement.executeUpdate();

		connection.close();
		return count;
	}

	public String getEmployee(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE email=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		return password;

	}

	public int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE EMPLOYEE SET name=?,sal=?,phone=?,address=?,email=?,password=? ");
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setDouble(3, employee.getSal());
		preparedStatement.setLong(4, employee.getPhone());
		preparedStatement.setString(5, employee.getAddress());
		preparedStatement.setString(6, employee.getEmail());
		preparedStatement.setString(7, employee.getPassword());

		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;

	}

}
