package com.frexescwebservice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.frexescwebservice.model.BarangUserBean;

/**
 * 
 * Servlet implementation class BarangUser Controller
 * 
 */
public class BarangUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BarangUserController() {
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

		if (requestType.equals("homeRank")) {
			Long id = Long.parseLong(request.getParameter("id"));
			JSONObject json = new JSONObject();

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "SELECT barang.id FROM barang JOIN barang_user ON barang.id=barang_user.id_barang AND barang.id_kategori="
					+ id
					+ " GROUP BY barang.id ORDER BY COUNT(barang.id) DESC LIMIT 0,4";

			try {
				ResultSet rss = connection.createStatement()
						.executeQuery(query);
				ArrayList<Integer> allResults = new ArrayList<Integer>();

				while (rss.next()) {
					allResults.add(Integer.parseInt(rss.getString("id")));
				}

				/** ArrayList for storing JSONObject */
				ArrayList<JSONObject> returnResult = new ArrayList<JSONObject>();

				if (allResults.size() > 0) {
					for (int i = 0; i < allResults.size(); i++) {
						JSONObject jsons = new JSONObject();
						jsons.put("id", allResults.get(i));
						returnResult.add(jsons);
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
		} else if (requestType.equals("readAll")) {
			Long id = Long.parseLong(request.getParameter("user_id"));
			JSONObject json = new JSONObject();

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "SELECT * FROM barang_user WHERE id_user=" + id
					+ " AND status=0";

			try {
				ResultSet rss = connection.createStatement()
						.executeQuery(query);

				ArrayList<BarangUserBean> allResults = new ArrayList<BarangUserBean>();

				while (rss.next()) {
					BarangUserBean barang = new BarangUserBean(Long.valueOf(rss
							.getString("id")), Long.valueOf(rss
							.getString("id_barang")), Long.valueOf(rss
							.getString("id_user")), Integer.valueOf(rss
							.getString("status")), Integer.valueOf(rss
							.getString("jumlah_barang")),
							rss.getString("deskripsi_tambahan"));
					allResults.add(barang);
				}

				/** ArrayList for storing JSONObject */
				ArrayList<JSONObject> returnResult = new ArrayList<JSONObject>();

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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
