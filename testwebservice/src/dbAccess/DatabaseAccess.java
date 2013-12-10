package dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DatabaseAccess {
	private String username;
	private String password;
	private String url;
	private String driver = "com.mysql.jdbc.Driver";
	private Connection connection = null;

	public DatabaseAccess(boolean value) {
		/** Get VCAP_SERVICES from Web Service */
		String vcapServices = java.lang.System.getenv("VCAP_SERVICES");
		/*
		 * JSON Parser, using json_simple-1.1.jar
		 */
		JSONParser parser = new JSONParser();
		JSONObject mainJSON = null;
		try {
			mainJSON = (JSONObject) parser.parse(vcapServices);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray infoPeers = (JSONArray) mainJSON.get("mysql-5.1"); // Get info

		/** Suppress warning for Compilation level */
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator = infoPeers.iterator();
		while (iterator.hasNext()) {
			JSONObject peer = iterator.next(); // each peer info
			JSONObject subInfoPeers = (JSONObject) peer.get("credentials");
			if (subInfoPeers.size() != 0) {
				url = "jdbc:mysql://" + subInfoPeers.get("hostname").toString()
						+ ":" + subInfoPeers.get("port").toString() + "/"
						+ subInfoPeers.get("name").toString();
				username = subInfoPeers.get("username").toString();
				password = subInfoPeers.get("password").toString();
			}
		}
	}
	
	public DatabaseAccess(){
		
	}
	
	public Connection mySqlConnection() {
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public Connection defaultConnection(){
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
