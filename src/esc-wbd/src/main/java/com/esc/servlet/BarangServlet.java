package com.esc.servlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esc.beans.BarangBean;
import com.esc.beans.TopfourBean;
import com.esc.util.DbConnection;
import com.esc.util.JSONMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BarangServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONMessage jsonMessage = null;
		if (req.getParameter("action") == null) {
			String selectQuery = null;
			if (req.getParameter("id") != null) {
				String id = req.getParameter("id");
				selectQuery = "SELECT * FROM barang WHERE id = " + id;
			} else if (req.getParameter("kategori") != null) {
				String kategori = req.getParameter("kategori");
				selectQuery = "SELECT * FROM barang WHERE id_kategori = " + kategori;
			} else if (req.getParameter("nama") != null) {
				String nama = req.getParameter("nama");
				selectQuery = "SELECT * FROM barang WHERE nama_barang = '" + nama + "'";
			} else {
				selectQuery = "SELECT * FROM barang";
			}
			try {
				Connection conn = DbConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectQuery);
				ArrayList<BarangBean> barangBeans = new ArrayList<BarangBean>();
				while (rs.next()) {
					BarangBean barangBean = new BarangBean(Integer.valueOf(rs.getString("id")), Integer.valueOf(rs.getString("id_kategori")), rs.getString("nama_barang"), rs.getString("gambar"), Integer.valueOf(rs.getString("harga_barang")), rs.getString("keterangan"), Integer.valueOf(rs.getString("jumlah_barang")));
					barangBeans.add(barangBean);				
				}
				jsonMessage = new JSONMessage(200, new Gson().toJsonTree(barangBeans));
			} catch (Exception e) {
				e.printStackTrace();
				jsonMessage = new JSONMessage(500);
			}
		} else {
			String selectQuery = "SELECT * FROM kategori";
			try {
				Connection conn = DbConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectQuery);
				ArrayList<TopfourBean> fours = new ArrayList<TopfourBean>();
				while (rs.next()) {
					String q = "SELECT barang.id FROM barang JOIN barang_user ON barang.id=barang_user.id_barang AND barang.id_kategori=" + rs.getString("id") + " GROUP BY barang.id ORDER BY COUNT(barang.id) DESC LIMIT 0 OFFSET 4";
					Statement st = conn.createStatement();
					ResultSet r = st.executeQuery(q);
					ArrayList<Integer> ids = new ArrayList<Integer>();
					while (r.next()) {
						System.out.println(r.getString("id"));
						ids.add(Integer.parseInt(r.getString("id")));
					}
					TopfourBean topfour = new TopfourBean(Integer.parseInt(rs.getString("id")), ids);
					fours.add(topfour);
				}
				jsonMessage = new JSONMessage(200, new Gson().toJsonTree(fours));
			} catch (Exception e) {
				e.printStackTrace();
				jsonMessage = new JSONMessage(500);
			}
		}
		resp.getWriter().print(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONMessage jsonMessage = null;
		String updateQuery = null;
		if (req.getSession(true).getAttribute("id") == null) {
			jsonMessage = new JSONMessage(401);
		} else {
			if (req.getParameter("action").equals("edit")) {
				if (req.getSession(true).getAttribute("role").equals("1")) {
					BarangBean barang = new BarangBean(Integer.parseInt(req.getParameter("id")), Integer.parseInt(req.getParameter("category")), req.getParameter("name"), null, Integer.parseInt(req.getParameter("price")), req.getParameter("description"), Integer.parseInt(req.getParameter("amount")));
					updateQuery = "UPDATE barang SET id_kategori='" + barang.getId_kategori() + "', nama_barang='" + barang.getNama_barang() + "', harga_barang='" + barang.getHarga_barang() + "', keterangan='" + barang.getKeterangan() + "', jumlah_barang='" + barang.getJumlah_barang() + "' WHERE id='" + barang.getId() + "'";
				} else {
					jsonMessage = new JSONMessage(401);
				}
			} else if (req.getParameter("action").equals("gambar")) {
				if (req.getSession(true).getAttribute("role").equals("1")) {
					String id = req.getParameter("id");
					String gambar = req.getParameter("gambar");
					updateQuery = "UPDATE barang SET gambar = '" + gambar + "' WHERE id=" + id;
				} else {
					jsonMessage = new JSONMessage(401);
				}
			} else if (req.getParameter("action").equals("transaksi")) {
				String id = req.getParameter("id");
				String jumlah = req.getParameter("jumlah_barang");
				updateQuery = "UPDATE barang SET jumlah_barang = jumlah_barang - " + jumlah + " WHERE id=" + id;
			} else if (req.getParameter("action").equals("restock")) {
				String id = req.getParameter("id");
				String jumlah = req.getParameter("jumlah_barang");
				updateQuery = "UPDATE barang SET jumlah_barang = " + jumlah + " WHERE id=" + id;
			}
			if (jsonMessage == null) {
				try {
					Statement statement = DbConnection.getConnection().createStatement();
					statement.executeUpdate(updateQuery);
					jsonMessage = new JSONMessage(204);
				} catch (SQLException e) {
					e.printStackTrace();
					jsonMessage = new JSONMessage(500);
				} catch (URISyntaxException e) {
					e.printStackTrace();
					jsonMessage = new JSONMessage(500);
				}
			}
		}
		resp.getWriter().print(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub;
		JSONMessage jsonMessage = null;
		if (req.getSession(true).getAttribute("id") == null || req.getSession(true).getAttribute("role").equals("0")) {
			jsonMessage = new JSONMessage(401);
		} else {
			String deleteQuery = "DELETE FROM barang WHERE id='" + req.getParameter("id") + "'";
			try {
				Statement statement = DbConnection.getConnection().createStatement();
				statement.executeUpdate(deleteQuery);
				jsonMessage = new JSONMessage(204);
			} catch (SQLException e) {
				e.printStackTrace();
				jsonMessage = new JSONMessage(500);
			} catch (URISyntaxException e) {
				e.printStackTrace();
				jsonMessage = new JSONMessage(500);
			}
		}
		resp.getWriter().print(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}
}
