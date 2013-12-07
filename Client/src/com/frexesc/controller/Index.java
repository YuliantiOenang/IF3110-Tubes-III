package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.BarangBean;
import com.frexesc.model.KategoriBean;

/**
 * 
 * Servlet implementation class Index
 * 
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
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
		/* Notifikasi login gagal */
		if (request.getParameter("login") != null) {
			request.setAttribute("login", "gagal");
		}
		
		/* Login by cookie */
		Cookie[] cookies = request.getCookies();
		HttpSession sessions = request.getSession(true);
		boolean isLogin = false;
		String userid = null;
		String username = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("user_id")) {
					isLogin = true;
					userid = cookie.getValue();
				}
				if (cookie.getName().equals("username")) {
					username = cookie.getValue();
				}
			}
		}
		if (isLogin && sessions.getAttribute("user_id") == null) {
			try {
				ResultSet rs = new DbConnection().mySqlConnection().createStatement().executeQuery("SELECT role FROM user WHERE id='" + userid + "'");
				rs.next();
				sessions.setAttribute("role", rs.getString("role"));
				sessions.setAttribute("user_id", userid);
				sessions.setAttribute("username", username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();

		String query2 = "SELECT * FROM barang";
		String query3 = "SELECT * FROM kategori";

		try {
			ResultSet rs2 = connection.createStatement().executeQuery(query2);
			ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();

			while (rs2.next()) {
				BarangBean barang = new BarangBean(Integer.valueOf(rs2
						.getString("id")), Integer.valueOf(rs2
						.getString("id_kategori")),
						rs2.getString("nama_barang"), rs2.getString("gambar"),
						Integer.valueOf(rs2.getString("harga_barang")),
						rs2.getString("keterangan"), Integer.valueOf(rs2
								.getString("jumlah_barang")));
				allResults2.add(barang);
			}

			ResultSet rs3 = connection.createStatement().executeQuery(query3);
			ArrayList<KategoriBean> allResults3 = new ArrayList<KategoriBean>();

			while (rs3.next()) {
				KategoriBean kategori = new KategoriBean(Integer.valueOf(rs3
						.getString("id")), rs3.getString("nama"));
				allResults3.add(kategori);
			}

			for (int i = 0; i < allResults3.size(); i++) {
				String searchQuery = "SELECT barang.id FROM barang JOIN barang_user ON barang.id=barang_user.id_barang AND barang.id_kategori="
						+ allResults3.get(i).getId()
						+ " GROUP BY barang.id ORDER BY COUNT(barang.id) DESC LIMIT 0,4";

				ResultSet rss = connection.createStatement().executeQuery(
						searchQuery);

				while (rss.next()) {
					for (int j = 0; j < allResults2.size(); j++) {
						if (allResults2.get(j).getId() == Integer.parseInt(rss
								.getString("id"))) {
							allResults3.get(i).setItemList(allResults2.get(j)); // push
																				// back
						}
					}
				}

				while (allResults3.get(i).getItemList().size() < 4) {
					for (int j = 0; j < allResults2.size(); j++) {
						if (allResults2.get(j).getId_category() == allResults3.get(i).getId()) {
							// We need to check whether current ID has been appeared
							// before
							long current_id = allResults2.get(j).getId();
							boolean is_exist = false;
							for (int k = 0; k < allResults3.get(i).getItemList()
									.size(); k++) {
								if (allResults3.get(i).getItemList(k).getId() == current_id)
									is_exist = true;
							}
							if (!is_exist) {
								allResults3.get(i).setItemList(allResults2.get(j)); // push
																					// back
								if (allResults3.get(i).getItemList().size() == 4)
									break;
							}	
						}
					}
				}
			}

			request.setAttribute("items", allResults3);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher;
		dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
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
