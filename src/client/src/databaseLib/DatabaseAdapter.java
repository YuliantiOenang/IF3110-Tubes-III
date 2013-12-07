package databaseLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Config.GlobalConfig;

public class DatabaseAdapter {

	private Connection con = null;  
    private Statement stmt = null;
    private ResultSet rs = null;
    
	public DatabaseAdapter()
	{
		//Koneksiin ke MySQL
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	  	  	con = DriverManager.getConnection(GlobalConfig.URLSQL,GlobalConfig.SQLUser,GlobalConfig.SQLPass);
		}catch (Exception e){System.out.println(e.getMessage());}
	}
	
	public void executeQuery(String Query)
	{
		try
		{
			stmt = con.createStatement();
	  	  	rs = stmt.executeQuery(Query);
		}catch (SQLException e){System.out.println("Error saat execute : "+e.getMessage());}
	}
	
	public void insertQuery(String Query)
	{
		try
		{
			stmt = con.createStatement();
	  	  	stmt.execute(Query);
		}catch (SQLException e){System.out.println("Error saat execute : "+e.getMessage());}
	}
	
	public void deleteQuery(String Query)
	{
		//khusus delete
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.execute(Query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet getQueryResult(){
		if (rs == null)
		{
			System.out.println("Keanehan");
			return null;
		}
		else
			return rs;
	}
}
