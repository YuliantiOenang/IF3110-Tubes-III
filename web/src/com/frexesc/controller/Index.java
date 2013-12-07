package com.frexesc.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.frexesc.model.BarangBean;
import com.frexesc.model.KategoriBean;
import com.frexesc.service.WebService;

/**
 * 
 * Servlet implementation class Index
 * 
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = "http://ruko.ap01.aws.af.cm/";

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

		/** Login by cookie */
		Cookie[] cookies = request.getCookies();
		HttpSession sessions = request.getSession(true);
		boolean isLogin = false;
		String userid = null;
		String username = null;
		String role = null;
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
				if (cookie.getName().equals("role")) {
					role = cookie.getValue();
				}
			}
		}
		
//		if (isLogin && sessions.getAttribute("user_id") == null) {
//			try {
//				ResultSet rs = new DbConnection()
//						.mySqlConnection()
//						.createStatement()
//						.executeQuery(
//								"SELECT role FROM user WHERE id='" + userid
//										+ "'");
//				rs.next();
//				sessions.setAttribute("role", rs.getString("role"));
//				sessions.setAttribute("user_id", userid);
//				sessions.setAttribute("username", username);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

		ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();

		/** Set WebService (REST) for retrieving list of Barang */
		WebService _barang = new WebService(hostname + "barang");
		_barang.addParam("action", "readAll");
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
			JSONArray infoBarang = (JSONArray) mainJSON.get("data"); // Get
																		// info

			/** Suppress warning for Compilation level */
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = infoBarang.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonBarang = iterator.next(); // each barang info
				BarangBean barang = new BarangBean(
						(Long) jsonBarang.get("id"),
						(Long) jsonBarang.get("id_category"),
						(String) jsonBarang.get("name"),
						(String) jsonBarang.get("picture"),
						Integer.valueOf(String.valueOf(jsonBarang.get("price"))),
						(String) jsonBarang.get("description"), Integer
								.valueOf(String.valueOf(jsonBarang
										.get("total_item"))));
				allResults2.add(barang);
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/** End of WebService for retrieving list of Barang */

		ArrayList<KategoriBean> allResults3 = new ArrayList<KategoriBean>();

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
			JSONArray infoKategori = (JSONArray) mainJSON.get("data"); // Get
																		// info

			/** Suppress warning for Compilation level */
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = infoKategori.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonKategori = iterator.next(); // each kategori
															// info
				KategoriBean kategori = new KategoriBean(Integer.valueOf(String
						.valueOf(jsonKategori.get("id"))),
						(String) jsonKategori.get("name"));
				allResults3.add(kategori);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/** End of WebService for retrieving list of Kategori */

		for (int i = 0; i < allResults3.size(); i++) {
			ArrayList<Integer> searchResults = new ArrayList<Integer>();

			/** Set WebService (REST) for retrieving list of Item Rank */
			WebService _rank = new WebService(hostname + "baranguser");
			_rank.addParam("action", "homeRank");
			_rank.addHeader("GData-Version", "2");

			try {
				_kategori.execute(WebService.REQUEST_METHOD.GET);
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
				JSONArray infoRank = (JSONArray) mainJSON.get("data"); // Get
																		// info

				/** Suppress warning for Compilation level */
				@SuppressWarnings("unchecked")
				Iterator<JSONObject> iterator = infoRank.iterator();
				while (iterator.hasNext()) {
					JSONObject jsonRank = iterator.next(); // each rank info
					searchResults.add(Integer.valueOf(String.valueOf(jsonRank
							.get("id"))));
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/** End of WebService for retrieving list of Item Rank */

			for (int j = 0; j < searchResults.size(); j++) {
				for (int k = 0; k < allResults2.size(); k++) {
					if (allResults2.get(j).getId() == searchResults.get(i)) {
						allResults3.get(i).setItemList(allResults2.get(j)); // push
						// back
					}
				}
			}

			while (allResults3.get(i).getItemList().size() < 4) {
				for (int j = 0; j < allResults2.size(); j++) {
					if (allResults2.get(j).getId_category() == allResults3.get(
							i).getId()) {
						// We need to check whether current ID has been
						// appeared
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
