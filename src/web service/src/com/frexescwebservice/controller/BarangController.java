package com.frexescwebservice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.frexescwebservice.controller.DbConnection;
import com.frexescwebservice.model.KategoriBean;
import com.frexescwebservice.model.BarangBean;

/**
 * 
 * Servlet implementation class Barang Controller
 * 
 */
public class BarangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BarangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestType = request.getParameter("action");

		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter(); // for writer

		if (requestType.equals("readAll")) {
			JSONObject json = new JSONObject();

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "SELECT * FROM barang";

			try {
				ResultSet rs2 = connection.createStatement()
						.executeQuery(query);
				ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();

				while (rs2.next()) {
					BarangBean barang = new BarangBean(Integer.valueOf(rs2
							.getString("id")), Integer.valueOf(rs2
							.getString("id_kategori")),
							rs2.getString("nama_barang"),
							rs2.getString("gambar"), Integer.valueOf(rs2
									.getString("harga_barang")),
							rs2.getString("keterangan"), Integer.valueOf(rs2
									.getString("jumlah_barang")));
					allResults2.add(barang);
				}

				/** ArrayList for storing JSONObject */
				ArrayList<JSONObject> returnResult = new ArrayList<JSONObject>();

				if (allResults2.size() > 0) {
					for (int i = 0; i < allResults2.size(); i++) {
						returnResult.add(allResults2.get(i).toJSON());
					}
					json.put("status", "true");
					json.put("data", returnResult);
				} else {
					json.put("status", "false");
				}

				out.println(json.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (requestType.equals("read")) {
			Long id = Long.parseLong(request.getParameter("id"));
			JSONObject json = new JSONObject();

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "SELECT * FROM barang JOIN kategori ON barang.id_kategori=kategori.id AND barang.id="
					+ id; // Select item based on id

			try {
				ResultSet rs2 = connection.createStatement()
						.executeQuery(query);
				ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();

				while (rs2.next()) {
					BarangBean barang = new BarangBean(Integer.valueOf(rs2
							.getString("id")), Integer.valueOf(rs2
							.getString("id_kategori")),
							rs2.getString("nama_barang"),
							rs2.getString("gambar"), Integer.valueOf(rs2
									.getString("harga_barang")),
							rs2.getString("keterangan"), Integer.valueOf(rs2
									.getString("jumlah_barang")));
					allResults2.add(barang); 
				}

				/** ArrayList for storing JSONObject */
				ArrayList<JSONObject> returnResult = new ArrayList<JSONObject>();

				if (allResults2.size() > 0) {
					for (int i = 0; i < allResults2.size(); i++) {
						returnResult.add(allResults2.get(i).toJSON());
					}
					json.put("status", "true");
					json.put("data", returnResult);
				} else {
					json.put("status", "false");
				}

				out.println(json.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (requestType.equals("readId")) {
			String nama_barang = request.getParameter("nama_barang").toString();
			JSONObject json = new JSONObject();

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "SELECT * FROM barang WHERE nama_barang='"
					+ nama_barang + "'";

			try {
				ResultSet rs2 = connection.createStatement()
						.executeQuery(query);

				if (rs2.next()) {
					json.put("status", "true");
					json.put("data", rs2.getString("id").toString());
				} else {
					json.put("status", "false");
				}
				out.println(json.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (requestType.equals("search")) {
			JSONObject json = new JSONObject();

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			int sort = 0;
			int jenisSort = 0;
			int page = 0;

			if (request.getParameter("sort") != null) {
				sort = Integer.valueOf(request.getParameter("sort"));
			}

			if (request.getParameter("jenisSort") != null) {
				jenisSort = Integer.valueOf(request.getParameter("jenisSort"));
			}

			if (request.getParameter("page") != null) {
				page = Integer.valueOf(request.getParameter("page")) - 1;
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

				if (request.getParameter("name") != null) {
					partial3 = " AND ( barang.nama_barang LIKE '%"
							+ request.getParameter("name") + "%' ) ";
				}

				if (request.getParameter("category") != null) {
					if (Integer.parseInt(request.getParameter("category")) != 0)
						partial4 = " AND barang.id_kategori="
								+ Integer.parseInt(request
										.getParameter("category")) + " ";
				}

				if (request.getParameter("price") != null) {
					if (Integer.parseInt(request.getParameter("price")) != 0)
						partial5 = " AND barang.harga_barang="
								+ Integer.parseInt(request
										.getParameter("price")) + " ";
				}

				if (page != 0) {
					page = page * 10;
				}

				String query = "SELECT kategori.nama, barang.gambar, barang.id, barang.id_kategori, barang.nama_barang, barang.harga_barang, barang.jumlah_barang, barang.keterangan FROM barang JOIN kategori ON barang.id_kategori=kategori.id "
						+ partial3
						+ partial4
						+ partial5
						+ partial1
						+ partial2
						+ "LIMIT " + page + ",10"; // Select
				// all
				// items
				// based
				// on
				// selection
				ResultSet rs = connection.createStatement().executeQuery(query);

				ArrayList<BarangBean> allResults = new ArrayList<BarangBean>();

				while (rs.next()) {
					BarangBean barang = new BarangBean(Integer.valueOf(rs
							.getString("id")), Integer.valueOf(rs
							.getString("id_kategori")),
							rs.getString("nama_barang"),
							rs.getString("gambar"), Integer.valueOf(rs
									.getString("harga_barang")),
							rs.getString("keterangan"), Integer.valueOf(rs
									.getString("jumlah_barang")));
					allResults.add(barang);
				}

				String query2 = "SELECT COUNT(id) AS JmlBarang FROM barang WHERE id=id "
						+ partial3 + partial4 + partial5;

				ResultSet rs2 = connection.createStatement().executeQuery(
						query2);
				rs2.next();

				if (request.getParameter("category") != null) {
					if (Integer.parseInt(request.getParameter("category")) != 0) {
						String query3 = "SELECT * FROM kategori WHERE id="
								+ Integer.parseInt(request
										.getParameter("category"));
						ResultSet rs3 = connection.createStatement()
								.executeQuery(query3);
						rs3.next();
						request.setAttribute("category_name",
								rs3.getString("nama"));
					}
				}

				/** ArrayList for storing JSONObject */
				ArrayList<JSONObject> returnResult = new ArrayList<JSONObject>();
				json.put("total_pages", rs2.getString("JmlBarang"));

				if (allResults.size() > 0) {
					for (int i = 0; i < allResults.size(); i++) {
						returnResult.add(allResults.get(i).toJSON());
					}
					json.put("status", "true");
					json.put("data", returnResult);
				} else {
					json.put("status", "false");
				}

				out.println(json.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (requestType.equals("edit")) {
			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();
			JSONObject json = new JSONObject();
			String category = request.getParameter("category");
			String selectQuery = "SELECT * FROM barang WHERE id_kategori='"
					+ category + "'";
			String selectCQuery = "SELECT * FROM kategori";

			try {
				ResultSet rsc = connection.createStatement().executeQuery(
						selectCQuery);
				ArrayList<KategoriBean> kategoris = new ArrayList<KategoriBean>();
				while (rsc.next()) {
					kategoris.add(new KategoriBean(rsc.getInt("id"), rsc
							.getString("nama")));
				}

				ArrayList<JSONObject> ResultKategoris = new ArrayList<JSONObject>();
				if (kategoris.size() > 0) {
					for (int i = 0; i < kategoris.size(); i++) {
						ResultKategoris.add(kategoris.get(i).toJSON());
					}
					json.put("status", "true");
					json.put("kategoris", ResultKategoris);
				}

				ResultSet rs = connection.createStatement().executeQuery(
						selectQuery);
				ArrayList<BarangBean> barangs = new ArrayList<BarangBean>();
				while (rs.next()) {
					barangs.add(new BarangBean(rs.getLong("id"), rs
							.getLong("id_kategori"), rs
							.getString("nama_barang"), rs.getString("gambar"),
							rs.getInt("harga_barang"), rs
									.getString("keterangan"), rs
									.getInt("jumlah_barang")));
				}
				ArrayList<JSONObject> ResultBarangs = new ArrayList<JSONObject>();
				if (barangs.size() > 0) {
					for (int i = 0; i < barangs.size(); i++) {
						ResultBarangs.add(barangs.get(i).toJSON());
					}
					json.put("status", "true");
					json.put("barangs", ResultBarangs);
				} else {
					json.put("status", "false");
				}
				out.println(json.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestType = request.getParameter("action");

		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");

		if (requestType.equals("updateCart")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Integer new_value = Integer.parseInt(request
					.getParameter("new_value"));

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "UPDATE barang SET jumlah_barang=" // update
					// stock
					+ new_value + " WHERE id=" + id;
			try {
				connection.createStatement().executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (requestType.equals("updateGambar")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String path = request.getParameter("path");

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String updateQuery = "UPDATE barang SET gambar='" + id + "."
					+ path + "' WHERE id='" + id + "'";
			
			try {
				connection.createStatement().executeUpdate(updateQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (requestType.equals("updateBarang")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Long id_category = Long.parseLong(request
					.getParameter("id_category"));
			String name = request.getParameter("name").toString();
			Integer price = Integer.parseInt(request.getParameter("price"));
			String description = request.getParameter("description").toString();
			Integer total_item = Integer.parseInt(request
					.getParameter("total_item"));

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String updateQuery = "UPDATE barang SET id_kategori='"
					+ id_category + "', nama_barang='" + name
					+ "', harga_barang='" + price + "', keterangan='"
					+ description + "', jumlah_barang='" + total_item
					+ "' WHERE id='" + id + "'";

			try {
				Statement statement = connection.createStatement();
				// PrintWriter out = response.getWriter();
				if (statement.executeUpdate(updateQuery) < 1) {
					// out.print("not");
				} else {
					// out.print("success");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (requestType.equals("delete")) {

			Long id = Long.parseLong(request.getParameter("id"));

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "DELETE FROM barang WHERE id=" + id; // delete
			// entry
			try {
				connection.createStatement().executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
