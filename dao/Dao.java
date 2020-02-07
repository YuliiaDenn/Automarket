package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

	private final String URL = "jdbc:mysql://localhost:3306/automarket";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, "root", "root"); // створюємо connection ok?
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
