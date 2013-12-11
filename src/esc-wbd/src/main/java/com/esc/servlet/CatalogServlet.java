package com.esc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esc.beans.BarangBean;
import com.esc.util.DbConnection;
import com.esc.util.JSONMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class CatalogServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONMessage jsonMessage = null;
		int sort = 0;
		int jenisSort = 0;
		int page = 0;
		if (req.getParameter("sort") != null) {
			sort = Integer.valueOf(req.getParameter("sort"));
		}
		if (req.getParameter("jenisSort") != null) {
			jenisSort = Integer.valueOf(req.getParameter("jenisSort"));
		}
		if (req.getParameter("page") != null) {
			page = Integer.valueOf(req.getParameter("page")) - 1;
		}
		try {
			String partial1 = "";
			String partial2 = "";
			String partial3 = "";
			String partial4 = "";
			String partial5 = "";

			if (sort != 0) {
				if (sort == 1)
					partial1 = " ORDER BY barang.nama_barang ";
				else if (sort == 2)
					partial1 = " ORDER BY kategori.nama ";
				else if (sort == 3)
					partial1 = " ORDER BY barang.harga_barang ";
			}

			if (jenisSort != 0) {
				if (jenisSort == 1) {
					partial2 = " ASC ";
				} else if (jenisSort == 2) {
					partial2 = " DESC ";
				}
			}

			if (req.getParameter("name") != null) {
				partial3 = " AND (nama_barang ILIKE '%" + req.getParameter("name") + "%') ";
			}

			if (req.getParameter("category") != null) {
				if (Integer.parseInt(req.getParameter("category")) != 0)
					partial4 = " AND id_kategori=" + Integer.parseInt(req.getParameter("category")) + " ";
			}

			if (req.getParameter("price") != null) {
				if (Integer.parseInt(req.getParameter("price")) != 0)
					partial5 = " AND harga_barang=" + Integer.parseInt(req.getParameter("price")) + " ";
			}

			if (page != 0) {
				page = page * 10;
			}

			String query = "SELECT kategori.nama, barang.gambar, barang.id, barang.id_kategori, barang.nama_barang, barang.harga_barang, barang.jumlah_barang, barang.keterangan FROM barang JOIN kategori ON barang.id_kategori=kategori.id " + partial3 + partial4 + partial5 + partial1 + partial2 + "LIMIT 10 OFFSET " + page; // Select

			Connection connection = DbConnection.getConnection();
			ResultSet rs = connection.createStatement().executeQuery(query);
			ArrayList<BarangBean> allResults = new ArrayList<BarangBean>();

			while (rs.next()) {
				BarangBean barang = new BarangBean(Integer.valueOf(rs.getString("id")), Integer.valueOf(rs.getString("id_kategori")), rs.getString("nama_barang"), rs.getString("gambar"), Integer.valueOf(rs.getString("harga_barang")), rs.getString("keterangan"), Integer.valueOf(rs.getString("jumlah_barang")));
				allResults.add(barang);
			}

			String query2 = "SELECT COUNT(id) AS JmlBarang FROM barang WHERE id=id " + partial3 + partial4 + partial5;
			ResultSet rs2 = connection.createStatement().executeQuery(query2);
			rs2.next();

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonArray jsonArray = new JsonArray();

			if (req.getParameter("category") != null) {
				if (Integer.parseInt(req.getParameter("category")) != 0) {
					String query3 = "SELECT * FROM kategori WHERE id=" + Integer.parseInt(req.getParameter("category"));
					ResultSet rs3 = connection.createStatement().executeQuery(query3);
					rs3.next();
					jsonArray.add(gson.toJsonTree(rs3.getString("nama")));
				} else {
					jsonArray.add(gson.toJsonTree("kosong"));
				}
			} else {
				jsonArray.add(gson.toJsonTree("kosong"));
			}
			jsonArray.add(gson.toJsonTree(allResults));
			jsonArray.add(gson.toJsonTree(rs2.getString("JmlBarang")));
			jsonMessage = new JSONMessage(200, new Gson().toJsonTree(jsonArray));
		} catch (Exception e) {
			jsonMessage = new JSONMessage(500);
			e.printStackTrace();
		}
		resp.getWriter().print(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
