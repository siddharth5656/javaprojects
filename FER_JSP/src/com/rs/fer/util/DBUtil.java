package com.rs.fer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc1";

	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static Connection getconnection() {
		Connection connection = null;

		{
			try {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
				System.out.println("connection to a select database");
			}

			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();

			}
			return connection;
		}
	}

	public static void closeConnection(Connection Connection) {
		try {
			Connection.close();
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}
}
