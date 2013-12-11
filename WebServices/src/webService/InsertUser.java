package webService;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUser {
	public void insertUser(String nama, String username, String password,
			String email, String handphone, String alamat, String kota,
			String provinsi, String kodepos) throws SQLException {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();

		String query2 = "INSERT INTO user (nama, username, password, email, handphone, alamat, kota, provinsi, kodepos) VALUES ('"
				+ nama
				+ "','"
				+ username
				+ "','"
				+ password
				+ "','"
				+ email
				+ "','"
				+ handphone
				+ "','"
				+ alamat
				+ "','"
				+ kota
				+ "','"
				+ provinsi + "','" + kodepos + "')";

		connection.createStatement().executeUpdate(query2);
	}
}
