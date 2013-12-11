package tubes2wbd;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;




	public class DbConnector {
		Connection connection = null;

/*		public Connection mySqlConnection() {
			String url = "jdbc:mysql://localhost:3306/chintalian";
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
		}*/
		
		HttpServletResponse response;
		public Connection mySqlConnection(HttpServletResponse response) {
			String url = "jdbc:mysql://localhost:3306/wbd1";
			String driver = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "";
			
			try {
				PrintWriter out = response.getWriter();
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
	}
