package com.frexescwebservice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestType = request.getParameter("action");

		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter(); // for writer

		if (requestType.equals("view_profile")) {
			String id = request.getParameter("user_id");
			JSONObject json = new JSONObject();

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "SELECT * FROM user WHERE id = " + id;

			try {
				ResultSet rs2 = connection.createStatement()
						.executeQuery(query);
				if (rs2.next()) {
					UserBean user = new UserBean(rs2.getString("username"),
							rs2.getString("password"), rs2.getString("email"),
							rs2.getString("nama"), rs2.getString("handphone"),
							rs2.getString("alamat"), rs2.getString("provinsi"),
							rs2.getString("kota"), rs2.getString("kodepos"),
							Integer.valueOf(rs2.getString("role")),
							rs2.getString("nomor_kartu"),
							rs2.getString("nama_kartu"),
							rs2.getString("expire_kartu"), Integer.valueOf(rs2
									.getString("transaksi")));

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String requestType = request.getParameter("action");

		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter(); // for writer

		if (requestType.equals("edit_profile")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String telephone = request.getParameter("telephone");
			String address = request.getParameter("address");
			String province = request.getParameter("province");
			String city = request.getParameter("city");
			String postal = request.getParameter("postal");

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String updateQuery = "UPDATE user SET nama='" + name
					+ "', password='" + password + "', email='" + email
					+ "', handphone='" + telephone + "', alamat='" + address
					+ "', kota='" + city + "', provinsi='" + province
					+ "', kodepos='" + postal + "' WHERE id='" + id + "'";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(updateQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (requestType.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			JSONObject json = new JSONObject();

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "SELECT * FROM user WHERE username='" + username
					+ "' and password='" + password + "' LIMIT 1";
			try {
				UserBean user = null;
				ResultSet rs2 = connection.createStatement()
						.executeQuery(query);
				if (rs2.next()) {
					user = new UserBean(Integer.valueOf(rs2.getString("id")),
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

		if (requestType.equals("updateCard")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String num = request.getParameter("num");
			String name = request.getParameter("name");
			String expired_date = request.getParameter("expired_date");

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "UPDATE user SET nama_kartu='" + name
					+ "', nomor_kartu='" + num + "', expire_kartu='"
					+ expired_date + "' WHERE id='" + id + "'";

			try {
				connection.createStatement().executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (requestType.equals("updateTransaction")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Integer number_of_transaction = Integer.parseInt(request
					.getParameter("number_of_transaction"));

			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			String query = "UPDATE user SET transaksi=" + number_of_transaction
					+ " WHERE id=" + id;

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
