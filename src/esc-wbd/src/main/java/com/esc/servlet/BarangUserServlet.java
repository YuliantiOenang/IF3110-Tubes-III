package com.esc.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esc.beans.BarangUserBean;
import com.esc.util.DbConnection;
import com.esc.util.JSONMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BarangUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONMessage jsonMessage = null;
		if (req.getSession(true).getAttribute("id") == null) {
			jsonMessage = new JSONMessage(401);
		} else {
			if (req.getParameter("action").equals("byid")) {
				String id = req.getParameter("id");
				String selectQuery = "SELECT * FROM barang_user WHERE id=" + id;
				try {
					Statement stmt = DbConnection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery(selectQuery);
					if (rs.next()) {
						BarangUserBean bub = new BarangUserBean(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("id_barang")), Integer.parseInt(rs.getString("id_user")), Integer.parseInt(rs.getString("status")), Integer.parseInt(rs.getString("jumlah_barang")), rs.getString("tanggal_pembelian"), rs.getString("deskripsi_tambahan"));
						jsonMessage = new JSONMessage(200, new Gson().toJsonTree(bub));
					} else {
						jsonMessage = new JSONMessage(404);
					}
				} catch (Exception e) {
					jsonMessage = new JSONMessage(500);
					e.printStackTrace();
				}
			} else if (req.getParameter("action").equals("chstatus")) {
				String idUser = req.getParameter("iduser");
				String selectQuery = "SELECT * FROM barang_user WHERE id_user=" + idUser + " AND status = 0";
				try {
					Statement stmt = DbConnection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery(selectQuery);
					ArrayList<BarangUserBean> barangUserBeans = new ArrayList<BarangUserBean>();
					while (rs.next()) {
						BarangUserBean bub = new BarangUserBean(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("id_barang")), Integer.parseInt(rs.getString("id_user")), Integer.parseInt(rs.getString("status")), Integer.parseInt(rs.getString("jumlah_barang")), rs.getString("tanggal_pembelian"), rs.getString("deskripsi_tambahan"));
						barangUserBeans.add(bub);
					}
					jsonMessage = new JSONMessage(200, new Gson().toJsonTree(barangUserBeans));
				} catch (Exception e) {
					jsonMessage = new JSONMessage(500);
					e.printStackTrace();
				}
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
			if (req.getParameter("action").equals("transaksi")) {
				String id = (String) req.getSession(true).getAttribute("id");
				updateQuery = "UPDATE barang_user SET status=1 WHERE id_user=" + id;
			} else if (req.getParameter("action").equals("edit")) {
				String id = req.getParameter("id");
				String jumlah = req.getParameter("jumlah");
				updateQuery = "UPDATE barang_user SET jumlah_barang = " + jumlah + " WHERE id=" + id;
			}
			try {
				Statement stmt = DbConnection.getConnection().createStatement();
				stmt.executeUpdate(updateQuery);
				jsonMessage = new JSONMessage(204);
			} catch (Exception e) {
				jsonMessage = new JSONMessage(500);
				e.printStackTrace();
			}
		}
		resp.getWriter().write(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONMessage jsonMessage = null;
		if (req.getSession(true).getAttribute("id") == null) {
			jsonMessage = new JSONMessage(401);
		} else {
			String id = req.getParameter("id");
			String deleteQuery = "DELETE barang_user WHERE id=" + id;
			try {
				Statement stmt = DbConnection.getConnection().createStatement();
				stmt.executeUpdate(deleteQuery);
				jsonMessage = new JSONMessage(204);
			} catch (Exception e) {
				jsonMessage = new JSONMessage(500);
				e.printStackTrace();
			}
		}
		resp.getWriter().print(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}
}
