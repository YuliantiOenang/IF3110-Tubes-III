package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * Servlet implementation class AddCart
 * 
 */
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCart() {
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
			response.getWriter().write("Redirect: ../register");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();

		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.getWriter().write("Redirect: ../register");
		} else {
			response.setContentType("text/html"); // set Content Type for AJAX

			String query = "SELECT * FROM barang WHERE id="
					+ request.getParameter("id_barang");

			try {
				ResultSet rs = connection.createStatement().executeQuery(query);
				
				while (rs.next()) {
					if (Integer.valueOf(rs.getString("jumlah_barang")) < Integer
							.valueOf(request.getParameter("qty"))
							|| Integer.valueOf(request.getParameter("qty")) <= 0) {
						response.getWriter()
								.write("Failure: Transaksi tidak berhasil, qty yang dimasukkan tidak valid.");
					} else {
						String deskripsiTambahan = request
								.getParameter("deskripsi_tambahan");
						if (deskripsiTambahan == null)
							deskripsiTambahan = "";

						// Add to Cart here
						String query2 = "INSERT INTO barang_user (id_barang,id_user,status,jumlah_barang,deskripsi_tambahan) VALUES ("
								+ request.getParameter("id_barang")
								+ ", "
								+ session.getAttribute("user_id")
								+ ", 0, "
								+ request.getParameter("qty")
								+ ", \""
								+ deskripsiTambahan + "\")";
						
						connection.createStatement().executeUpdate(query2);
						
						// Update to Barang here
						String query3 = "UPDATE barang SET jumlah_barang=" + (Integer.parseInt(rs.getString("jumlah_barang")) - Integer.parseInt(request.getParameter("qty"))) + " WHERE id=" + request.getParameter("id_barang"); 
						
						connection.createStatement().executeUpdate(query3);
						
						response.getWriter().write("Success: Transaksi berhasil!");
					}					
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
