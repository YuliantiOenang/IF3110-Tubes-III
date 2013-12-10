package com.frexesc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DbConnection {
	private Connection connection = null;
	public String url = "jdbc:mysql://localhost:3306/progin_13511073";
	private String driver = "com.mysql.jdbc.Driver";
	public String username = "root";
	public String password = "";
	public String test = "";
	
	public DbConnection() {}
	public DbConnection(int x) {

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
		test = mainJSON.toJSONString();

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

	public Connection mySqlConnection() {
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
