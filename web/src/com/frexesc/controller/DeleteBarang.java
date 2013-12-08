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
 * Servlet implementation class DeleteBarang
 * 
 */
public class DeleteBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = "http://ruko.ap01.aws.af.cm/";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBarang() {
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
			ArrayList<BarangUserBean> allResults = new ArrayList<BarangUserBean>();

			/** Set WebService (REST) for retrieving list of Barang User */
			WebService _barangUser = new WebService(hostname + "baranguser");
			_barangUser.addParam("action", "read");
			_barangUser.addParam("id", request.getParameter("id"));
			_barangUser.addHeader("GData-Version", "2");

			try {
				_barangUser.execute(WebService.REQUEST_METHOD.GET);
				String listBarangUser = _barangUser.getResponse();

				/*
				 * JSON Parser, using json_simple-1.1.jar
				 */
				JSONParser parser = new JSONParser();
				JSONObject mainJSON = null;
				try {
					mainJSON = (JSONObject) parser.parse(listBarangUser);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (mainJSON.get("status").equals("true")) {
					JSONArray infoBarangUser = (JSONArray) mainJSON.get("data"); // Get
					// info

					/** Suppress warning for Compilation level */
					@SuppressWarnings("unchecked")
					Iterator<JSONObject> iterator = infoBarangUser.iterator();
					while (iterator.hasNext()) {
						JSONObject jsonBarangUser = iterator.next(); // each
																		// barang
						// user info
						BarangUserBean barangUser = new BarangUserBean(
								(Long) jsonBarangUser.get("id"),
								(Long) jsonBarangUser.get("id_item"),
								(Long) jsonBarangUser.get("id_user"),
								Integer.valueOf(String.valueOf(jsonBarangUser
										.get("status"))),
								Integer.valueOf(String.valueOf(jsonBarangUser
										.get("total_item"))),
								(String) jsonBarangUser.get("desicription"));

						allResults.add(barangUser);
					}
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/** End of WebService for retrieving list of Barang User */

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
						JSONObject jsonBarang = iterator.next(); // each barang
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
						allResults2.add(barang);
					}
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/** End of WebService for retrieving list of Barang */

			if (!allResults2.isEmpty()) {
				int jumlah_barang_akhir = allResults2.get(0).getTotal_item()
						+ allResults.get(0).getTotal_item();

				/** Set WebService (REST) for update Barang */
				WebService _updateBarang = new WebService(hostname + "barang");
				_updateBarang.addParam("action", "updateCart");
				_updateBarang.addParam("id",
						String.valueOf(allResults.get(0).getId_item()));
				_updateBarang.addParam("new_value",
						String.valueOf(jumlah_barang_akhir));
				_updateBarang.addHeader("GData-Version", "2");

				try {
					_updateBarang.execute(WebService.REQUEST_METHOD.POST);
					// TODO : Unsafe Operation, Need to check result!
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/** End of WebService for update Barang */

				/** Set WebService (REST) for delete Barang User */
				WebService _deleteBarangUser = new WebService(hostname
						+ "baranguser");
				_deleteBarangUser.addParam("action", "delete");
				_deleteBarangUser.addParam("id", request.getParameter("id"));
				_deleteBarangUser.addHeader("GData-Version", "2");

				try {
					_deleteBarangUser.execute(WebService.REQUEST_METHOD.POST);
					// TODO : Unsafe Operation, Need to check result!
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/** End of WebService for delete Barang User */

			}

			response.sendRedirect("./cart"); // back to previous
			// page

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
