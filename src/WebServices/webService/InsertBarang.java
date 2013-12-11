package webService;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBarang {
	public void insertBarang(String id_kategori, String nama_barang,
			String gambar, String harga_barang, String keterangan,
			String jumlah_barang) throws SQLException {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();

		String query2 = "INSERT INTO barang (id_kategori, nama_barang, gambar, harga_barang, keterangan, jumlah_barang) VALUES ('"
				+ id_kategori
				+ "','"
				+ nama_barang
				+ "','"
				+ gambar
				+ "','"
				+ harga_barang + "','" + keterangan +"','" + jumlah_barang + "')";

		connection.createStatement().executeUpdate(query2);
	}
}
