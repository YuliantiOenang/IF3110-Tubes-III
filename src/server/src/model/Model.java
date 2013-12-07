package model;

import java.util.*;
import java.sql.*;

import json.JSONArray;
import json.JSONObject;

public class Model
{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static String DB_URL;

	//  Database credentials
	private static String USER;
	private static String PASS;
	
	public String errorMessage;
	
	private Vector<HashMap<String,String>> data;
	
	private String tabelname;
	
	public void GlobalConfig()
	{
		try
		{
			if (java.lang.System.getenv("VCAP_SERVICES") != null)
			{
				if (!java.lang.System.getenv("VCAP_SERVICES").equals(""))
				{
					JSONObject jsonVCAP = new JSONObject(java.lang.System.getenv("VCAP_SERVICES"));
					JSONArray mysql = jsonVCAP.getJSONArray("mysql-5.1");
					String table = mysql.getJSONObject(0).getJSONObject("credentials").getString("name");
					DB_URL = "jdbc:mysql://"+mysql.getJSONObject(0).getJSONObject("credentials").getString("hostname")+":3306/"+table;
					USER = mysql.getJSONObject(0).getJSONObject("credentials").getString("username");
					PASS = mysql.getJSONObject(0).getJSONObject("credentials").getString("password");
				}
			}
		}catch (Exception e){}
	}
	
	public Model(String tabel)
	{
		if (DB_URL==null)
			GlobalConfig();
		data = new Vector<HashMap<String,String>>();
		tabelname = tabel;
	}
	
	public Vector<HashMap<String,String>> findAll()
	{
		execute("SELECT * FROM `" + tabelname +"`");
		return getDataVector();
	}
	
	public Vector<HashMap<String,String>> findByCondition(String cond)
	{
		execute("SELECT * FROM `" + tabelname + "` WHERE " + cond);
		return getDataVector();
	}
	
	public HashMap<String,String> findById(int id)
	{
		findByCondition("id = " + id);
		return getDataVector().firstElement();
	}
	
	public boolean runSQLSyntax(String sql){
		java.sql.Connection con;
		java.sql.Statement stmt;
		ResultSet rs;
		ResultSetMetaData rsmd;
		try{
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			
			 // Open a connection
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			 
			// Execute a query
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
			// Clean-up environment
			stmt.close();
			con.close();
			return true;
		} catch(SQLException e) {
			errorMessage = e.getMessage();
			return false;
		} catch (ClassNotFoundException cnfex) {
			errorMessage = cnfex.getMessage();
			return false;
		}
	}
	
	protected void execute(String sql)
	{
		java.sql.Connection con;
		java.sql.Statement stmt;
		ResultSet rs;
		ResultSetMetaData rsmd;
		try{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			 // Open a connection
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			 
			// Execute a query
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			
			//Extract data from result set
			data.clear();
			while(rs.next()){
				HashMap<String,String> hasm = new HashMap<String,String>();
				for (int i = 1;i<=rsmd.getColumnCount();i++) {
					hasm.put(rsmd.getColumnName(i), rs.getString(i));
				}
				data.add(hasm);
		    }
			
			// Clean-up environment
			rs.close();
			stmt.close();
			con.close();
			
		} catch(SQLException e) {
			System.out.println("SQL Error.");
			e.printStackTrace();
		} catch (ClassNotFoundException cnfex) {
			System.out.println("com.mysql.Driver class not found.");
			cnfex.printStackTrace();
		}
	}
	
	public Vector<HashMap<String,String>> getDataVector() {
		return data;
	}
	public int getDataCount() {
		return data.size();
	}
	public HashMap<String,String> getData(int idx) {
		if (idx<getDataCount())
			return data.elementAt(idx);
		else
			return null;
	}
	public String getDataColumn(int idx,String column) {
		return getData(idx).get(column);
	}
	public void newRecord(){
		data.clear();
		data.add(new HashMap<String,String>());
	}
	public void addValue(String column, String value){
		if (data.size()!=1)
		{
			data.clear();
			data.add(new HashMap<String,String>());
		}
		data.firstElement().put(column, value);
	}
	public void save(){
		java.sql.Connection con;
		java.sql.Statement stmt;
		ResultSet rs;
		ResultSetMetaData rsmd;
		String sql;
		
		// Generate Query
		sql = "INSERT INTO `" + tabelname + "` (";
		boolean first = true;
		for (String key : data.firstElement().keySet())
		{
			if (first) first = false;else sql = sql + ",";
			sql = sql + "`" + key + "`";
		}
		sql = sql + ") VALUES (";
		first = false;
		for (String key : data.firstElement().keySet())
		{
			if (first) first = false; else sql = sql + ",";
			sql = sql + "'" + data.firstElement().get(key) + "'";
		}
		sql = sql + ");";
		
		try{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			 // Open a connection
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			 
			// Execute a query
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			
			//Extract data from result set
			data.clear();
			while(rs.next()){
				HashMap<String,String> hasm = new HashMap<String,String>();
				for (int i = 1;i<=rsmd.getColumnCount();i++)
					hasm.put(rsmd.getCatalogName(i), rs.getString(i));
				data.add(hasm);
		    }
			
			// Clean-up environment
			rs.close();
			stmt.close();
			con.close();
			
		} catch(SQLException e) {
			System.out.println("SQL Error.");
			e.printStackTrace();
		} catch (ClassNotFoundException cnfex) {
			System.out.println("org.gjt.mm.mysql.Driver class not found.");
			cnfex.printStackTrace();
		}
	}
	
	public static String rupiahFormatter(String raw)
	{
		int nchar = raw.length();
		String rp = "";
		for (int i = nchar-1;i>=0;i--)
		{
			rp = raw.charAt(i) + rp;
			if (((nchar-i)%3==0)&&(i!=0))
				rp = "." + rp;
		}
		return rp;
	}
}
