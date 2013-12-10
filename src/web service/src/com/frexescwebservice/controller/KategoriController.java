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

import com.frexescwebservice.model.KategoriBean;

/**
 * 
 * Servlet implementation class Kategori Controller
 * 
 */
public class KategoriController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KategoriController() {
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

			String query = "SELECT * FROM kategori";

			try {
				ResultSet rs3 = connection.createStatement()
						.executeQuery(query);
				ArrayList<KategoriBean> allResults3 = new ArrayList<KategoriBean>();

				while (rs3.next()) {
					KategoriBean kategori = new KategoriBean(
							Integer.valueOf(rs3.getString("id")),
							rs3.getString("nama"));
					allResults3.add(kategori);
				}

				/** ArrayList for storing JSONObject */
				ArrayList<JSONObject> returnResult = new ArrayList<JSONObject>();

				if (allResults3.size() > 0) {
					for (int i = 0; i < allResults3.size(); i++) {
						returnResult.add(allResults3.get(i).toJSON());
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
