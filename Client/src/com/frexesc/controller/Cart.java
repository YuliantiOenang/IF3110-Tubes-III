package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class Cart
 * 
 */
public class Cart extends HttpServlet {
	Gson gson = new Gson();
	String json = null;
	JsonParser jsonParser = new JsonParser();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (session.getAttribute("username") == null) {
			response.sendRedirect("../register");
		} else {
			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			// String query = "SELECT * FROM barang_user WHERE id_user=" +
			// session.getAttribute("user_id") + " AND status=0";

			try {
				// ResultSet rs =
				// connection.createStatement().executeQuery(query);

				json = ServiceParser.readUrl(ServiceParser.BASE_URL
						+ "BarangUserService/baranguserService/statuszero?id="
						+ session.getAttribute("user_id"));

				List<BarangUserBean> allResults = ServiceParser
						.parseJsonToGenericlist(json, BarangUserBean.class);// new
																			// ArrayList<BarangUserBean>();

				// ArrayList<BarangUserBean> allResults = new
				// ArrayList<BarangUserBean>();

				// while (rs.next()) {
				// BarangUserBean barangUser = new BarangUserBean(
				// Integer.valueOf(rs.getString("id")),
				// Integer.valueOf(rs.getString("id_barang")),
				// Integer.valueOf(rs.getString("id_user")),
				// Integer.valueOf(rs.getString("status")),
				// Integer.valueOf(rs.getString("jumlah_barang")),
				// rs.getString("deskripsi_tambahan"));
				// allResults.add(barangUser);
				// }
				json = WebServicesKit
						.readUrl("http://localhost:8080/web-services/BS/barang/select");
				JsonArray barangArray = jsonParser.parse(json).getAsJsonArray();
				ArrayList<Barang> barangList = new ArrayList<Barang>();
				for (JsonElement barang : barangArray) {
					Barang barangObj = gson.fromJson(barang, Barang.class);
					barangList.add(barangObj);
				}
				request.setAttribute("items", barangList);

				request.setAttribute("user_items", allResults);

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/barang/cart.jsp");
				dispatcher.forward(request, response);

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
