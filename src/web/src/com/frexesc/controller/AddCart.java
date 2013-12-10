package com.frexesc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.frexesc.Constants;
import com.frexesc.model.BarangBean;
import com.frexesc.service.WebService;
import com.frexesc.soap.BarangUserSoapProxy;

/**
 * 
 * Servlet implementation class AddCart
 * 
 */
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = Constants.HOSTNAME;

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
		// DbConnection dbConnection = new DbConnection();
		// Connection connection = dbConnection.mySqlConnection();

		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.getWriter().write("Redirect: ../register");
		} else {
			response.setContentType("text/html"); // set Content Type for AJAX

			ArrayList<BarangBean> allResults = new ArrayList<BarangBean>();

			/** Set WebService (REST) for retrieving list of Barang */
			WebService _barang = new WebService(hostname + "barang");
			_barang.addParam("action", "read");
			_barang.addParam("id", request.getParameter("id_barang"));
			_barang.addHeader("GData-Version", "2");

			try {
				_barang.execute(WebService.REQUEST_METHOD.GET);
				String listBarang = _barang.getResponse();

				if (listBarang != null) {
					/*
					 * JSON Parser, using json_simple-1.1.jar
					 */
					JSONParser parser = new JSONParser();
					JSONObject mainJSON = null;
					try {
						mainJSON = (JSONObject) parser.parse(listBarang);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (mainJSON.get("status").equals("true")) {
						JSONArray infoBarang = (JSONArray) mainJSON.get("data"); // Get
						// info

						/** Suppress warning for Compilation level */
						@SuppressWarnings("unchecked")
						Iterator<JSONObject> iterator = infoBarang.iterator();
						while (iterator.hasNext()) {
							JSONObject jsonBarang = iterator.next(); // each
																		// barang
																		// info
							BarangBean barang = new BarangBean(
									(Long) jsonBarang.get("id"),
									(Long) jsonBarang.get("id_category"),
									(String) jsonBarang.get("name"),
									(String) jsonBarang.get("picture"),
									Integer.valueOf(String.valueOf(jsonBarang
											.get("price"))),
									(String) jsonBarang.get("description"),
									Integer.valueOf(String.valueOf(jsonBarang
											.get("total_item"))));
							allResults.add(barang);
						}
					}
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/** End of WebService for retrieving list of Barang */

			for (int i = 0; i < allResults.size(); i++) {
				BarangBean rs = allResults.get(i);

				if (rs.getTotal_item() < Integer.valueOf(request
						.getParameter("qty"))
						|| Integer.valueOf(request.getParameter("qty")) <= 0) {
					response.getWriter()
							.write("Failure: Transaksi tidak berhasil, qty yang dimasukkan tidak valid.");
				} else {
					String deskripsiTambahan = request
							.getParameter("deskripsi_tambahan");
					if (deskripsiTambahan == null)
						deskripsiTambahan = "";

					// Add to Cart here
					/** SOAP Invocation */
					BarangUserSoapProxy _barangUser = new BarangUserSoapProxy();
					_barangUser.addCart(
							Long.parseLong(request.getParameter("id_barang")),
							(Long) session.getAttribute("user_id"),
							Integer.parseInt(request.getParameter("qty")),
							deskripsiTambahan);

					/** Set WebService (REST) for update Barang */
					WebService _updateBarang = new WebService(hostname
							+ "barang");
					_updateBarang.addParam("action", "updateCart");
					_updateBarang.addParam("id",
							request.getParameter("id_barang"));
					_updateBarang.addParam("new_value", String.valueOf((rs
							.getTotal_item() - Integer.parseInt(request
							.getParameter("qty")))));
					_updateBarang.addHeader("GData-Version", "2");

					try {
						_updateBarang.execute(WebService.REQUEST_METHOD.POST);
						// TODO : Unsafe Operation, Need to check result!
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/** End of WebService for update Barang */

					response.getWriter().write("Success: Transaksi berhasil!");
				}
			}

		}

	}

}
