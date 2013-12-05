package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.BarangBean;
import com.frexesc.model.BarangUserBean;

/**
 * 
 * Servlet implementation class UpdateCart
 * 
 */
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCart() {
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

			if (request.getParameter("submit") != null) {
				int id = 0;
				id = Integer.parseInt(request.getParameter("id"));

				String query = "SELECT * FROM barang_user WHERE id=" + id;

				try {
					ResultSet rs = connection.createStatement().executeQuery(
							query);

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

					String query2 = "SELECT * FROM barang WHERE id="
							+ allResults.get(0).getId_item();

					ResultSet rs2 = connection.createStatement().executeQuery(
							query2);

					if (rs2 != null) {
						ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();

						while (rs2.next()) {
							BarangBean barang = new BarangBean(
									Integer.valueOf(rs2.getString("id")),
									Integer.valueOf(rs2
											.getString("id_kategori")),
									rs2.getString("nama_barang"),
									rs2.getString("gambar"),
									Integer.valueOf(rs2
											.getString("harga_barang")),
									rs2.getString("keterangan"),
									Integer.valueOf(rs2
											.getString("jumlah_barang")));
							allResults2.add(barang);
						}

						if (allResults2.get(0).getTotal_item() + allResults.get(0).getTotal_item() < Integer
								.parseInt(request.getParameter("qty"))
								|| Integer
										.parseInt(request.getParameter("qty")) <= 0) {
							/** TODO : Show remaining stock */
							response.getWriter()
									.write("Failure: Transaksi tidak berhasil, qty yang dimasukkan tidak valid. qty dikembalikan ke "
											+ allResults.get(0).getTotal_item());
						} else {
							int differences = 0;
							differences = (Integer.parseInt(request
									.getParameter("qty")) - allResults.get(0)
									.getTotal_item())
									* allResults2.get(0).getPrice();

							/** Update barang_user */
							String query3 = "UPDATE barang SET jumlah_barang=" // update
																				// stock
									+ (allResults2.get(0).getTotal_item() + (allResults
											.get(0).getTotal_item() - Integer
											.parseInt(request
													.getParameter("qty"))))
									+ " WHERE id="
									+ allResults.get(0).getId_item();
							connection.createStatement().executeUpdate(query3);

							/** Update barang */
							String query4 = "UPDATE barang_user SET jumlah_barang=" // update
																					// barang_user
									+ Integer.parseInt(request
											.getParameter("qty"))
									+ " WHERE id=" + allResults.get(0).getId();
							connection.createStatement().executeUpdate(query4);

							response.getWriter().write(
									"Success: " + differences);

						}
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
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
