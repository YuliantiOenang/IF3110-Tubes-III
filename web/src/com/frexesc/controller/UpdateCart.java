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

import com.frexesc.model.BarangBean;
import com.frexesc.model.BarangUserBean;
import com.frexesc.service.WebService;

/**
 * 
 * Servlet implementation class UpdateCart
 * 
 */
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = "http://ruko.ap01.aws.af.cm/";

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
			if (request.getParameter("submit") != null) {
				ArrayList<BarangUserBean> allResults = new ArrayList<BarangUserBean>();

				/** Set WebService (REST) for retrieving list of Item Rank */
				WebService _rank = new WebService(hostname + "baranguser");
				_rank.addParam("action", "read");
				_rank.addParam("id", request.getParameter("id"));
				_rank.addHeader("GData-Version", "2");

				try {
					_rank.execute(WebService.REQUEST_METHOD.GET);
					String listRank = _rank.getResponse();

					/*
					 * JSON Parser, using json_simple-1.1.jar
					 */
					JSONParser parser = new JSONParser();
					JSONObject mainJSON = null;
					try {
						mainJSON = (JSONObject) parser.parse(listRank);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (mainJSON.get("status").equals("true")) {
						JSONArray infoRank = (JSONArray) mainJSON.get("data"); // Get
						// info

						/** Suppress warning for Compilation level */
						@SuppressWarnings("unchecked")
						Iterator<JSONObject> iterator = infoRank.iterator();
						while (iterator.hasNext()) {
							JSONObject jsonBarangUser = iterator.next(); // each
																			// barang
							// user info
							BarangUserBean barangUser = new BarangUserBean(
									(Long) jsonBarangUser.get("id"),
									(Long) jsonBarangUser.get("id_item"),
									(Long) jsonBarangUser.get("id_user"),
									Integer.valueOf(String
											.valueOf(jsonBarangUser
													.get("status"))),
									Integer.valueOf(String
											.valueOf(jsonBarangUser
													.get("total_item"))),
									(String) jsonBarangUser.get("desicription"));

							allResults.add(barangUser);
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/** End of WebService for retrieving list of Item Rank */

				ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();

				/** Set WebService (REST) for retrieving list of Barang */
				WebService _barang = new WebService(hostname + "barang");
				_barang.addParam("action", "read");
				_barang.addParam("id",
						String.valueOf(allResults.get(0).getId_item()));
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
							JSONArray infoBarang = (JSONArray) mainJSON
									.get("data"); // Get
							// info

							/** Suppress warning for Compilation level */
							@SuppressWarnings("unchecked")
							Iterator<JSONObject> iterator = infoBarang
									.iterator();
							while (iterator.hasNext()) {
								JSONObject jsonBarang = iterator.next(); // each
																			// barang
																			// info
								BarangBean barang = new BarangBean(
										(Long) jsonBarang.get("id"),
										(Long) jsonBarang.get("id_category"),
										(String) jsonBarang.get("name"),
										(String) jsonBarang.get("picture"),
										Integer.valueOf(String
												.valueOf(jsonBarang
														.get("price"))),
										(String) jsonBarang.get("description"),
										Integer.valueOf(String
												.valueOf(jsonBarang
														.get("total_item"))));
								allResults2.add(barang);
							}
						}
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/** End of WebService for retrieving list of Barang */

				if (!allResults2.isEmpty()) {

					if (allResults2.get(0).getTotal_item()
							+ allResults.get(0).getTotal_item() < Integer
								.parseInt(request.getParameter("qty"))
							|| Integer.parseInt(request.getParameter("qty")) <= 0) {
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
						
						/** Set WebService (REST) for update Barang */
						WebService _updateBarang = new WebService(hostname + "barang");
						_updateBarang.addParam("action", "updateCart");
						_updateBarang.addParam("id", String.valueOf(allResults.get(0).getId_item()));
						_updateBarang.addParam("new_value", String.valueOf(allResults2.get(0).getTotal_item() + (allResults
										.get(0).getTotal_item() - Integer
										.parseInt(request.getParameter("qty")))));
						_updateBarang.addHeader("GData-Version", "2");
						
						try {
							_updateBarang.execute(WebService.REQUEST_METHOD.POST);
							// TODO : Unsafe Operation, Need to check result!
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						/** End of WebService for update Barang */
						
						/** Set WebService (REST) for update Barang User */
						WebService _updateBarangUser = new WebService(hostname + "baranguser");
						_updateBarangUser.addParam("action", "updateCart");
						_updateBarangUser.addParam("id", String.valueOf(allResults.get(0).getId()));
						_updateBarangUser.addParam("new_value", request.getParameter("qty"));
						_updateBarangUser.addHeader("GData-Version", "2");
						
						try {
							_updateBarangUser.execute(WebService.REQUEST_METHOD.POST);
							// TODO : Unsafe Operation, Need to check result!
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						/** End of WebService for update Barang User */

						response.getWriter().write("Success: " + differences);

					}
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
