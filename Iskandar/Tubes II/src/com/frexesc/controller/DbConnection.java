package com.frexesc.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	Connection connection = null;

	public Connection mySqlConnection() {
		String url = "jdbc:mysql://localhost:3306/frexesc";
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "";

		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
