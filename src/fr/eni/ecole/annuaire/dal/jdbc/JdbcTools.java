package fr.eni.ecole.annuaire.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.ecole.annuaire.dal.Settings;

public class JdbcTools {
	static Connection connection = null;

	static {
		try {
			Class.forName(Settings.getProperty("driverjdbc"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		connection = DriverManager.getConnection(Settings.getProperty("url"), Settings.getProperty("user"),
				Settings.getProperty("password"));
		return connection;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
