package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.BarangBean;
import com.frexesc.model.KategoriBean;

/**
 * 
 * Servlet implementation class Detail (Barang)
 * 
 */
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Detail() {
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
			response.sendRedirect("../register.jsp");
		} else {
			
			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			int id = 0;

			if (request.getParameter("id") != null) {
				id = Integer.valueOf(request.getParameter("id"));
			}

			try {
				String query = "SELECT * FROM barang JOIN kategori ON barang.id_kategori=kategori.id AND barang.id="
						+ id; // Select item based on id
				ResultSet rs = connection.createStatement().executeQuery(query);

				ArrayList<BarangBean> allResults = new ArrayList<BarangBean>();

				while (rs.next()) {
					BarangBean barang = new BarangBean(Integer.valueOf(rs
							.getString("id")), Integer.valueOf(rs
							.getString("id_kategori")),
							rs.getString("nama_barang"), rs.getString("gambar"),
							Integer.valueOf(rs.getString("harga_barang")),
							rs.getString("keterangan"), Integer.valueOf(rs
									.getString("jumlah_barang")));
					allResults.add(barang);
				}

				String query2 = "SELECT * FROM kategori";
				ResultSet rs2 = connection.createStatement().executeQuery(query2);

				ArrayList<KategoriBean> allResults2 = new ArrayList<KategoriBean>();

				while (rs2.next()) {
					KategoriBean kategori = new KategoriBean(Integer.valueOf(rs2
							.getString("id")), rs2.getString("nama"));
					allResults2.add(kategori);
				}

				request.setAttribute("items", allResults);
				request.setAttribute("categories", allResults2);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/barang/detail.jsp");
				dispatcher.forward(request, response);

			} catch (Exception e) {
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
