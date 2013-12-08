package webService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import model.AccessManager;

import com.google.gson.Gson;

import dto.Barang;

@Path("/Service")
// GantiNama
public class BarangService {
	String query;
	Connection con = new AccessManager().getCon();
	private Gson gson;

	@GET
	@Path("/insert")
	@Produces("application/json")
	public String insertBarang(@Context UriInfo info) {
		String insertResult = null;
		int temp;
		try {
			String idKat = info.getQueryParameters().getFirst("idKat");
			String nama = info.getQueryParameters().getFirst("nama");
			String gambar = info.getQueryParameters().getFirst("gambar");
			String keterangan = info.getQueryParameters()
					.getFirst("keterangan");
			String harga = info.getQueryParameters().getFirst("harga");
			String jumlah = info.getQueryParameters().getFirst("jumlah");
			query = "INSERT INTO barang (id_kategori, nama_barang, gambar, harga_barang, keterangan, jumlah_barang) VALUES ('"
					+ idKat
					+ "','"
					+ nama
					+ "','"
					+ gambar
					+ "','"
					+ harga
					+ "','" + keterangan + "','" + jumlah + "')";
			PreparedStatement stmt = con.prepareStatement(query);
			temp = stmt.executeUpdate();
			gson = new Gson();
			insertResult = gson.toJson(temp);
		} catch (Exception e) {
		}
		return insertResult;
	}

	@GET
	@Path("/select")
	@Produces("application/json")
	public String selectBarang(@DefaultValue("-1") @QueryParam("id") int id,
			@DefaultValue("-1") @QueryParam("idKat") int idKat,
			@DefaultValue("-1") @QueryParam("nama") String nama) {
		String selectResult = null;
		try {
			ArrayList<Barang> barangList = new ArrayList<Barang>();
			query = "SELECT * FROM barang WHERE 1";
			if (id != -1)
				query += (" && id=" + id);
			if (idKat != -1)
				query += (" && id_kategori=" + idKat);
			if (nama != "-1")
				query += (" && nama_barang=" + nama);
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Barang barang = new Barang();
				barang.setId(rs.getInt("id"));
				barang.setId_category(rs.getInt("id_kategori"));
				barang.setName(rs.getString("nama_barang"));
				barang.setPicture(rs.getString("gambar"));
				barang.setPrice(rs.getInt("harga_barang"));
				;
				barang.setDescription(rs.getString("keterangan"));
				barang.setName(rs.getString("jumlah_barang"));
				barangList.add(barang);
			}
			gson = new Gson();
			selectResult = gson.toJson(barangList);
		} catch (Exception e) {
		}
		return selectResult;
	}

	@GET
	@Path("/update")
	@Produces("application/json")
	public String updateBarang(@QueryParam("id") int id,
			@DefaultValue("-1") @QueryParam("idKat") int idKat,
			@DefaultValue("-1") @QueryParam("nama") String nama,
			@DefaultValue("-1") @QueryParam("gambar") String gambar,
			@DefaultValue("-1") @QueryParam("keterangan") String keterangan,
			@DefaultValue("-1") @QueryParam("harga") int harga,
			@DefaultValue("-1") @QueryParam("jumlah") int jumlah) {
		String updateResult = null;
		int temp;
		try {
			query = "UPDATE barang SET id=barang.id,";
			if (idKat != -1)
				query += (", id_kategori=" + idKat);
			if (nama != "-1")
				query += (", nama_barang=" + nama);
			if (gambar != "-1")
				query += (", gambar=" + gambar);
			if (keterangan != "-1")
				query += (", keterangan=" + keterangan);
			if (harga != -1)
				query += (", harga_barang=" + harga);
			if (jumlah != -1)
				query += (", jumlah_barang=" + jumlah);
			if (id != -1)
				query += (" WHERE id=" + id);
			PreparedStatement stmt = con.prepareStatement(query);
			temp = stmt.executeUpdate();
			gson = new Gson();
			updateResult = gson.toJson(temp);
		} catch (Exception e) {}
		return updateResult;
	}

	@GET
	@Path("/delete")
	@Produces("application/json")
	public String deleteBarang(@Context UriInfo info) {
		String deleteResult = null;
		int temp;
		try {
			String id = info.getQueryParameters().getFirst("id");
			query = "DELETE FROM barang WHERE id=" + id;
			PreparedStatement stmt = con.prepareStatement(query);
			temp = stmt.executeUpdate();
			gson = new Gson();
			deleteResult = gson.toJson(temp);
		} catch (Exception e) {}
		return deleteResult;
	}
}
