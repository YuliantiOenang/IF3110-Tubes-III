package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frexesc.model.UserBean;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession(true).getAttribute("user_id") == null) {
			response.sendRedirect("register");
		} else {
			if (request.getParameter("action") == null) {
				DbConnection dbConnection = new DbConnection();
				Connection connection = dbConnection.mySqlConnection();
				String id = request.getParameter("id");
				try {
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE id='" + id + "' LIMIT 1");
					if (rs.next()) {
						UserBean user = new UserBean(rs.getString("username"), null, rs.getString("email"), rs.getString("nama"), rs.getString("handphone"), rs.getString("alamat"), rs.getString("provinsi"), rs.getString("kota"), rs.getString("kodepos"), rs.getInt("role"), rs.getString("nomor_kartu"), rs.getString("nama_kartu"), rs.getString("expire_kartu"), Integer.parseInt(rs.getString("transaksi")));
						request.setAttribute("user", user);
						request.setAttribute("id", id);
					}
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				DbConnection dbConnection = new DbConnection();
				Connection connection = dbConnection.mySqlConnection();
				String id = request.getParameter("id");
				try {
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE id='" + id + "' LIMIT 1");
					if (rs.next()) {
						UserBean user = new UserBean(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("nama"), rs.getString("handphone"), rs.getString("alamat"), rs.getString("provinsi"), rs.getString("kota"), rs.getString("kodepos"), rs.getInt("role"), rs.getString("nomor_kartu"), rs.getString("nama_kartu"), rs.getString("expire_kartu"), Integer.parseInt(rs.getString("transaksi")));
						request.setAttribute("user", user);
					}
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editprofile.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();
		String password = request.getParameter("password1");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String postal = request.getParameter("postal");
		if (action.equals("register")) {
			String username = request.getParameter("username");
			// HttpSession session = request.getSession(true);
			String insertQuery = "INSERT INTO user (nama, username, password, email, handphone, alamat, kota, provinsi, kodepos) VALUES ('" + name + "','" + username + "','" + password + "','" + email + "','" + telephone + "','" + address + "','" + city + "','" + province + "','" + postal + "')";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(insertQuery);
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.setAttribute("register", "y");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/login").forward(request, response);
		} else if (action.equals("edit")) {
			String updateQuery = "UPDATE user SET nama='" + name + "', password='" + password + "', email='" + email + "', handphone='" + telephone + "', alamat='" + address + "', kota='" + city + "', provinsi='" + province + "', kodepos='" + postal + "' WHERE id='" + request.getSession(true).getAttribute("user_id") + "'";
			System.out.println(updateQuery);
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(updateQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("user?id=" + request.getSession(true).getAttribute("user_id"));
		}

	}

}
