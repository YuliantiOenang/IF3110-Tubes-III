package com.esc.soap;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() throws URISyntaxException, SQLException {
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			String dbUrl = "jdbc:postgresql://" + "localhost" + ':' + "5432" + "/postgres";
			return DriverManager.getConnection(dbUrl, "postgres", "apotoxin4869");
		} else {
			URI dbUri = new URI(System.getenv("DATABASE_URL"));

			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

			return DriverManager.getConnection(dbUrl, username, password);
		}
	}
}
