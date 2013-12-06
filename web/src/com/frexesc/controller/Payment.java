package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * Servlet implementation class Payment
 * 
 */
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Payment() {
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

			String query = "SELECT * FROM user WHERE id="
					+ session.getAttribute("user_id");

			try {
				ResultSet rs = connection.createStatement().executeQuery(query);

				while (rs.next()) {
					if (rs.getString("nomor_kartu") == null) {
						/** Redirect to Credit Card page */
						response.sendRedirect("../card?from=payment");
					} else {

						// Update status
						String query2 = "UPDATE barang_user SET status=1 WHERE id_user="
								+ session.getAttribute("user_id");
						connection.createStatement().executeUpdate(query2);

						// Update number of transaction
						String query3 = "SELECT * FROM user WHERE id="
								+ session.getAttribute("user_id");
						ResultSet rs3 = connection.createStatement()
								.executeQuery(query3);
						rs3.next();

						String query4 = "UPDATE user SET transaksi="
								+ (Integer.parseInt(rs3.getString("transaksi")) + 1)
								+ " WHERE id="
								+ session.getAttribute("user_id");
						connection.createStatement().executeUpdate(query4);

						request.setAttribute("response", "Transaksi berhasil!");

						RequestDispatcher dispatcher;
						dispatcher = getServletContext().getRequestDispatcher(
								"/barang/payment.jsp");
						dispatcher.forward(request, response);

						// redirect to gallery

					}
				}

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
		doGet(request, response);
	}
}
