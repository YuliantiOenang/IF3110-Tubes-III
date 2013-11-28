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

/**
 * 
 * Servlet implementation class Gallery
 * 
 */
public class Gallery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Gallery() {
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

			int sort = 0;
			int jenisSort = 0;
			int page = 0;

			if (request.getParameter("sort") != null) {
				sort = Integer.valueOf(request.getParameter("sort"));
			}

			if (request.getParameter("jenisSort") != null) {
				jenisSort = Integer.valueOf(request.getParameter("jenisSort"));
			}

			if (request.getParameter("page") != null) {
				page = Integer.valueOf(request.getParameter("page")) - 1;
			}

			try {
				String partial1 = "";
				String partial2 = "";
				String partial3 = "";
				String partial4 = "";
				String partial5 = "";

				if (sort != 0) {
					if (sort == 1)
						partial1 = " ORDER BY barang.nama_barang ";
					else if (sort == 2)
						partial1 = " ORDER BY kategori.nama ";
					else if (sort == 3)
						partial1 = " ORDER BY barang.harga_barang ";
				}

				if (jenisSort != 0) {
					if (jenisSort == 1) {
						partial2 = " ASC ";
					} else if (jenisSort == 2) {
						partial2 = " DESC ";
					}
				}
				
				if (request.getParameter("name") != null) {
					partial3 = " AND ( barang.nama_barang LIKE '%" + request.getParameter("name") + "%' ) ";
				}
				
				if (request.getParameter("category") != null) {
					if (Integer.parseInt(request.getParameter("category")) != 0)
						partial4 = " AND barang.id_kategori=" + Integer.parseInt(request.getParameter("category")) +" ";
				}
				
				if (request.getParameter("price") != null) {
					if (Integer.parseInt(request.getParameter("price")) != 0)
						partial5 = " AND barang.harga_barang=" + Integer.parseInt(request.getParameter("price")) + " ";
				}

				if (page != 0) {
					page = page * 10;
				}
				

				String query = "SELECT kategori.nama, barang.gambar, barang.id, barang.id_kategori, barang.nama_barang, barang.harga_barang, barang.jumlah_barang, barang.keterangan FROM barang JOIN kategori ON barang.id_kategori=kategori.id "
						 + partial3 + partial4 + partial5 + partial1 + partial2 + "LIMIT " + page + ",10"; // Select
																			// all
																			// items
																			// based
																			// on
																			// selection
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
				
				String query2 = "SELECT COUNT(id) AS JmlBarang FROM barang WHERE id=id " + partial3 + partial4 + partial5;
				
				ResultSet rs2 = connection.createStatement().executeQuery(query2);
				rs2.next();
				
				if (request.getParameter("category") != null) {
					if (Integer.parseInt(request.getParameter("category")) != 0) {
						String query3 = "SELECT * FROM kategori WHERE id=" + Integer.parseInt(request.getParameter("category"));
						ResultSet rs3 = connection.createStatement().executeQuery(query3);
						rs3.next();
						request.setAttribute("category_name", rs3.getString("nama"));	
					}
				}

				request.setAttribute("items", allResults);
				request.setAttribute("total_pages", rs2.getString("JmlBarang"));

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/barang/index.jsp");
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
