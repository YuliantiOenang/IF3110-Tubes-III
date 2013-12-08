package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database
{
	public Connection getConnection() throws Exception
	{
		try
		{
//			String url = "jdbc:mysql://10.0.28.130:3306/d49533220d59549ea8d59a42dd0c22251";
//			String driver = "com.mysql.jdbc.Driver";
//			String username = "uq4KXgZdPVKL4";
//			String password = "pUxhgVj9EKMdX";
			
//APPFOG
			String connectionURL = "jdbc:mysql://10.0.28.130:3306/d49533220d59549ea8d59a42dd0c22251";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "uq4KXgZdPVKL4", "pUxhgVj9EKMdX");
			
//LOCALHOST
//			String connectionURL = "jdbc:mysql://localhost:3306/frexesc";
//			Connection connection = null;
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			connection = DriverManager.getConnection(connectionURL, "root", "");
			
			return connection;
		} catch (Exception e)
		{
			throw e;
		}
		
	}

}
