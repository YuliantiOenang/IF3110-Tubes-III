package com.frexesc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnection {
	Connection connection = null;

	public Connection mySqlConnection() {
		String url = "jdbc:mysql://10.0.28.130:3306/d49533220d59549ea8d59a42dd0c22251";
		String driver = "com.mysql.jdbc.Driver";
		String username = "uq4KXgZdPVKL4";
		String password = "pUxhgVj9EKMdX";

		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
