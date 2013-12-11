package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.Barang;
import com.frexesc.model.BarangUserBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * 
 * Servlet implementation class DeleteBarang
 * 
 */
public class DeleteBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBarang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		String json = null;
		JsonParser jsonParser = new JsonParser();
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (session.getAttribute("username") == null) {
			response.sendRedirect("../register");
		} else {
			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			int id = 0;
			id = Integer.parseInt(request.getParameter("id"));

			// String query = "SELECT * FROM barang_user WHERE id=" + id;

			try {
				// ResultSet rs =
				// connection.createStatement().executeQuery(query);

				json = ServiceParser
						.readUrl(ServiceParser.BASE_URL
								+ "BarangUserService/baranguserService/baranguserid?id="
								+ id);

				List<BarangUserBean> allResults = ServiceParser
						.parseJsonToGenericlist(json, BarangUserBean.class);// new
																			// ArrayList<BarangUserBean>();

				// while (rs.next()) {
				// BarangUserBean barangUser = new BarangUserBean(
				// Integer.valueOf(rs.getString("id")),
				// Integer.valueOf(rs.getString("id_barang")),
				// Integer.valueOf(rs.getString("id_user")),
				// Integer.valueOf(rs.getString("status")),
				// Integer.valueOf(rs.getString("jumlah_barang")),
				// rs.getString("deskripsi_tambahan"));
				//
				// allResults.add(barangUser);
				// }
				json = WebServicesKit
						.readUrl("http://coba-soap.ap01.aws.af.cm/BS/barang/select?id="
								+ allResults.get(0).getId_item());
				JsonArray barangArray = jsonParser.parse(json).getAsJsonArray();
				ArrayList<Barang> barangList = new ArrayList<Barang>();
				for (JsonElement barang : barangArray) {
					Barang barangObj = gson.fromJson(barang, Barang.class);
					barangList.add(barangObj);
				}

				int jumlah_barang_akhir = barangList.get(0).getTotal_item()
						+ allResults.get(0).getTotal_item();

				try {
					json = WebServicesKit
							.readUrl("http://coba-soap.ap01.aws.af.cm/BS/barang/update?id="
									+ allResults.get(0).getId_item()
									+ "&jumlah=" + jumlah_barang_akhir);
				} catch (NumberFormatException e) {

					//
					// POST
					String[] param = { "id" };
					String[] val = { "" + allResults.get(0).getId() };
					ServiceParser
							.postUrl(
									ServiceParser.BASE_URL
											+ "BarangUserService/baranguserService/deletebaranguser",
									param, val);

					response.sendRedirect("./cart"); // back to previous
														// page
				}

			} catch (Exception e) {
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
		doGet(request, response);

	}

}
