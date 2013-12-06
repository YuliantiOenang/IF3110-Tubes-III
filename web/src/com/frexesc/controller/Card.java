package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Card
 */
public class Card extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Card() {
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
			getServletContext().getRequestDispatcher("/creditcard.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();

		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String date = request.getParameter("expired_date");
		String updateQuery = "UPDATE user SET nama_kartu='" + name + "', nomor_kartu='" + num + "', expire_kartu='" + date + "' WHERE id='" + request.getSession(true).getAttribute("user_id") + "'";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (request.getParameter("from") == null || request.getParameter("from") == "") response.sendRedirect("index");
		else response.sendRedirect("./barang/payment");
	}

}
