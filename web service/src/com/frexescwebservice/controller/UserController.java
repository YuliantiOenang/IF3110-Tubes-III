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

import com.frexescwebservice.model.BarangBean;
import com.frexescwebservice.model.UserBean;

/**
 * 
 * Servlet implementation class User Controller
 * 
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
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
		String requestType = request.getParameter("action");

		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter(); // for writer
		
		
		if (requestType.equals("readAll")) {
			JSONObject json = new JSONObject();

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "SELECT * FROM user";

			try {
				ResultSet rs2 = connection.createStatement()
						.executeQuery(query);
				ArrayList<UserBean> allResults2 = new ArrayList<UserBean>();

				while (rs2.next()) {
					UserBean user = new UserBean(
							Integer.valueOf(rs2.getString("id")),
							rs2.getString("username"),
							rs2.getString("password"), rs2.getString("email"),
							rs2.getString("nama"), rs2.getString("handphone"),
							rs2.getString("alamat"), rs2.getString("provinsi"),
							rs2.getString("kota"), rs2.getString("kodepos"),
							Integer.valueOf(rs2.getString("role")),
							rs2.getString("nomor_kartu"),
							rs2.getString("nama_kartu"),
							rs2.getString("expire_kartu"), Integer.valueOf(rs2
									.getString("transaksi")));
					allResults2.add(user);
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

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String requestType = request.getParameter("action");

		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter(); // for writer
		
		if (requestType.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			JSONObject json = new JSONObject();
			
			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();
			
			String query = "SELECT * FROM user WHERE username='" + username + "' and password='" + password + "' LIMIT 1";
			try {
				UserBean user = null;
				ResultSet rs2 = connection.createStatement().executeQuery(query);
				if (rs2.next()) {
					user = new UserBean(
							Integer.valueOf(rs2.getString("id")),
							rs2.getString("username"),
							rs2.getString("password"), rs2.getString("email"),
							rs2.getString("nama"), rs2.getString("handphone"),
							rs2.getString("alamat"), rs2.getString("provinsi"),
							rs2.getString("kota"), rs2.getString("kodepos"),
							Integer.valueOf(rs2.getString("role")),
							rs2.getString("nomor_kartu"),
							rs2.getString("nama_kartu"),
							rs2.getString("expire_kartu"), 
							Integer.valueOf(rs2.getString("transaksi"))
							);
					JSONObject returnResult = new JSONObject();
					returnResult = user.toJSON();
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
