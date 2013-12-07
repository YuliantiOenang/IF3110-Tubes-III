package com.frexescwebservice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.frexescwebservice.model.BarangBean;

/**
 * 
 * Servlet implementation class Barang Controller
 * 
 */
public class BarangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BarangController() {
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

		if (requestType.equals("action")) {
			JSONObject json = new JSONObject();
            json.put("status", "true");
            out.println(json.toString());
            
			if (requestType.equals("readAll")) {
				JSONObject json1 = new JSONObject();
	
				DbConnection dbConnection = new DbConnection();
				Connection connection = dbConnection.mySqlConnection();
	
				String query = "SELECT * FROM barang";
	
				try {
					ResultSet rs2 = connection.createStatement().executeQuery(query);
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
	
					/** ArrayList for storing JSONObject */
					ArrayList<JSONObject> returnResult = new ArrayList<JSONObject>();
	
					if (allResults2.size() > 0) {
						for (int i = 0; i < allResults2.size(); i++) {
							returnResult.add(allResults2.get(i).toJSON());
						}
						json1.put("status", "true");
						json1.put("data", returnResult);
					} else {
						json1.put("status", "false");
					}
	
					out.println(json1.toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
