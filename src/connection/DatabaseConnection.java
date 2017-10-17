package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public Connection getConnection() {
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;

		}

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/pizza", "postgres",
					"postgres");

		} catch (SQLException e) {

			System.out.println("Connection Failed!");
			e.printStackTrace();
			return connection;

		}

		if (connection != null) {
			return connection;
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}

}
