package dbAccess;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DatabaseAccess {
	private String username;
	private String password;
	private String url;
	private String driver = "com.mysql.jdbc.Driver";
	private Connection connection = null;

	public DatabaseAccess() {

	}	
	
	public Connection mySqlConnection() {
		String url = "jdbc:mysql://localhost:3306/wbd1";
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "";
		
		try {
			if (java.lang.System.getenv("VCAP_SERVICES") != null)
			{
				if (!java.lang.System.getenv("VCAP_SERVICES").equals(""))
				{
					JSONObject jsonVCAP = new JSONObject(java.lang.System.getenv("VCAP_SERVICES"));
					JSONArray mysql = jsonVCAP.getJSONArray("mysql-5.1");
					String table = mysql.getJSONObject(0).getJSONObject("credentials").getString("name");
					url = "jdbc:mysql://"+mysql.getJSONObject(0).getJSONObject("credentials").getString("hostname")+":3306/"+table;
					username = mysql.getJSONObject(0).getJSONObject("credentials").getString("username");
					password = mysql.getJSONObject(0).getJSONObject("credentials").getString("password");
				}
			}
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return connection;
	}

	public Connection defaultConnection() {
		String user = "root";
		String pass = "";
		String urls = "jdbc:mysql://localhost/progin_13511059";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(urls, user,
					pass);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
