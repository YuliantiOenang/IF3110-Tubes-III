package com.frexesc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
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
import com.frexesc.model.KategoriBean;
import com.frexesc.service.WebService;

/**
 * 
 * Servlet implementation class Detail (Barang)
 * 
 */
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = Constants.HOSTNAME;

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
			ArrayList<BarangBean> allResults = new ArrayList<BarangBean>();

			/** Set WebService (REST) for retrieving list of Barang */
			WebService _barang = new WebService(hostname + "barang");
			_barang.addParam("action", "read");
			_barang.addParam("id", request.getParameter("id"));
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
						allResults.add(barang);
					}
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/** End of WebService for retrieving list of Barang */

			ArrayList<KategoriBean> allResults2 = new ArrayList<KategoriBean>();

			/** Set WebService (REST) for retrieving list of Kategori */
			WebService _kategori = new WebService(hostname + "kategori");
			_kategori.addParam("action", "readAll");
			_kategori.addHeader("GData-Version", "2");

			try {
				_kategori.execute(WebService.REQUEST_METHOD.GET);
				String listKategori = _kategori.getResponse();

				/*
				 * JSON Parser, using json_simple-1.1.jar
				 */
				JSONParser parser = new JSONParser();
				JSONObject mainJSON = null;
				try {
					mainJSON = (JSONObject) parser.parse(listKategori);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (mainJSON.get("status").equals("true")) {
					JSONArray infoKategori = (JSONArray) mainJSON.get("data"); // Get
					// info

					/** Suppress warning for Compilation level */
					@SuppressWarnings("unchecked")
					Iterator<JSONObject> iterator = infoKategori.iterator();
					while (iterator.hasNext()) {
						JSONObject jsonKategori = iterator.next(); // each
																	// kategori
						// info
						KategoriBean kategori = new KategoriBean(
								Integer.valueOf(String.valueOf(jsonKategori
										.get("id"))),
								(String) jsonKategori.get("name"));
						allResults2.add(kategori);
					}
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/** End of WebService for retrieving list of Kategori */

			request.setAttribute("items", allResults);
			request.setAttribute("categories", allResults2);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/barang/detail.jsp");
			dispatcher.forward(request, response);
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
