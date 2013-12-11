package com.esc.servlet;

import java.io.IOException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esc.util.DbConnection;

public class CreateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if (action != null) {
			String insertQuery = null;
			if (action.equals("user")) {
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String email = req.getParameter("email");
				String name = req.getParameter("name");
				String telephone = req.getParameter("telephone");
				String address = req.getParameter("address");
				String province = req.getParameter("province");
				String city = req.getParameter("city");
				String postal = req.getParameter("postal");
				int id = new Random().nextInt(1000000);
				id += 1000;
				insertQuery = "INSERT INTO \"user\" (id, nama, username, password, email, handphone, alamat, kota, provinsi, kodepos, transaksi, role) VALUES (" + id + ", '" + name + "','" + username + "','" + password + "','" + email + "','" + telephone + "','" + address + "','" + city + "','" + province + "','" + postal + "',0,0)";
			} else if (action.equals("barang")) {
				String idk = req.getParameter("idk");
				String nama = req.getParameter("nama");
				String gambar = req.getParameter("gambar");
				String harga = req.getParameter("harga");
				String keterangan = req.getParameter("keterangan");
				String jumlah = req.getParameter("jumlah");
				int id = new Random().nextInt(1000000);
				id += 1000;
				insertQuery = "INSERT INTO barang (id, id_kategori, nama_barang, gambar, harga_barang, keterangan, jumlah_barang) VALUES ('" + id + "','" + idk + "','" + nama + "','" + gambar + "','" + harga + "','" + keterangan + "','" + jumlah + "')";
			} else if (action.equals("baranguser")) {
				String idb = req.getParameter("idb");
				String idu = req.getParameter("idu");
				String jumlah = req.getParameter("jumlah");
				String deskripsi = req.getParameter("deskripsi");
				int id = new Random().nextInt(1000000);
				id += 1000;
				insertQuery = "INSERT INTO barang_user (id, id_barang,id_user,status,jumlah_barang,deskripsi_tambahan) VALUES (" + id + ", " + idb + ", " + idu + ", 0, " + jumlah + ", '" + deskripsi + "')";
			}
			try {
				Statement stmt = DbConnection.getConnection().createStatement();
				stmt.execute(insertQuery);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
}
