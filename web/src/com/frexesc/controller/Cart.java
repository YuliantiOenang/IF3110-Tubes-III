package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.BarangBean;
import com.frexesc.model.BarangUserBean;

/**
 * 
 * Servlet implementation class Cart
 * 
 */
public class Cart extends HttpServlet {
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

			String query = "SELECT * FROM barang_user WHERE id_user="
					+ session.getAttribute("user_id") + " AND status=0";
			String query2 = "SELECT * FROM barang";

			try {
				ResultSet rs = connection.createStatement().executeQuery(query);

				ArrayList<BarangUserBean> allResults = new ArrayList<BarangUserBean>();

				while (rs.next()) {
					BarangUserBean barangUser = new BarangUserBean(
							Integer.valueOf(rs.getString("id")),
							Integer.valueOf(rs.getString("id_barang")),
							Integer.valueOf(rs.getString("id_user")),
							Integer.valueOf(rs.getString("status")),
							Integer.valueOf(rs.getString("jumlah_barang")),
							rs.getString("deskripsi_tambahan"));
					allResults.add(barangUser);
				}

				ResultSet rs2 = connection.createStatement().executeQuery(
						query2);
				ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();

				while (rs2.next()) {
					BarangBean barang = new BarangBean(Integer.valueOf(rs2
							.getString("id")), Integer.valueOf(rs2
							.getString("id_kategori")),
							rs2.getString("nama_barang"),
							rs2.getString("gambar"), Integer.valueOf(rs2
									.getString("harga_barang")),
							rs2.getString("keterangan"), Integer.valueOf(rs2
									.getString("jumlah_barang")));
					allResults2.add(barang);
				}

				request.setAttribute("user_items", allResults);
				request.setAttribute("items", allResults2);

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/barang/cart.jsp");
				dispatcher.forward(request, response);

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
