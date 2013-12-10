package servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dbAccess.DatabaseAccess;

public class QueryController {
	public static String getQuery(String query) {
		// Initialization
		Connection con;
		Statement state = null;
		ResultSet result = null;
		String output = "";

		// Get Connection from DbAccess
		DatabaseAccess db = new DatabaseAccess();
		con = db.mySqlConnection();
		if (con == null){
			return "MySQLConnection failed";
		}
		System.out.println("DB Connect Success");

		// Run query
		try {
			state = con.createStatement();
			result = state.executeQuery(query);
			System.out.println("Query Success");

			output = toJSONString(result);
			System.out.println("Query Parse Success");
		} catch (SQLException e) {
			e.printStackTrace();
			return "Query failed";
		}
		return output;
	}

	public static int updateQuery(String query) {
		// Initialization
		Connection con = null;
		Statement state = null;

		// Get Connection from DbAccess
		DatabaseAccess db = new DatabaseAccess();
		con = db.mySqlConnection();

		// Run query
		try {
			state = con.createStatement();
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

		return 0;
	}

	private static String toJSONString(ResultSet rs) throws SQLException {
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int columnCount = rsMetaData.getColumnCount();
		JSONArray json = new JSONArray();
		
		while(rs.next()){
			JSONArray arr = new JSONArray();
			for (int i = 1; i<=columnCount; i++){
				arr.add(rs.getObject(i).toString());
			}
			json.add(arr);
		}
//
//		for (int i = 1; i <= columnCount; i++) {
//			JSONArray jarr = new JSONArray();
//			rs.first();
//			while (!rs.isAfterLast()) {
//				jarr.add(rs.getObject(i).toString());
//				if (!rs.next()) break; // impossible ?
//			}
//			ResultSetMetaData rsmd = rs.getMetaData();
//			String name = rsmd.getColumnName(i);
//			json.put(i, jarr);
//		}
		return json.toJSONString();
	}
}
