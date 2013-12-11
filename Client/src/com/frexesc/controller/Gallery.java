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

import com.frexesc.model.Barang;
import com.frexesc.model.KategoriBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

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
		Gson gson = new Gson();
		String json = null;
		JsonParser jsonParser = new JsonParser();
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (session.getAttribute("username") == null) {
			response.sendRedirect("../register");
		} else {
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

				System.out.println("asdf1"+request.getParameter("name"));
				if (request.getParameter("name") != null) {
					partial3 = " AND ( barang.nama_barang LIKE '%"
							+ request.getParameter("name") + "%' ) ";
				}
				
				
				System.out.println("asdf2"+request.getParameter("category"));
				if (request.getParameter("category") != null) {
					if (Integer.parseInt(request.getParameter("category")) != 0)
						partial4 = " AND barang.id_kategori="
								+ Integer.parseInt(request
										.getParameter("category")) + " ";
				}

				if (request.getParameter("price") != null) {
					if (Integer.parseInt(request.getParameter("price")) != 0)
						partial5 = " AND barang.harga_barang="
								+ Integer.parseInt(request
										.getParameter("price")) + " ";
				}

				if (page != 0) {
					page = page * 10;
				}
				String temp="http://localhost:8080/web-services/BS/barang/select2?p1="+partial1
						+ "&p2="+partial2 + "&p3="+partial3 + "&p4="+partial4 + "&p5="+partial5+"&page="+page;
				temp=temp.replace(" ","%20");
				System.out.println(temp);
				json = WebServicesKit
						.readUrl(temp);
				JsonArray barangArray = jsonParser.parse(json).getAsJsonArray();
				ArrayList<Barang> allResults= new ArrayList<Barang>();
				
				for (JsonElement barang : barangArray) {
					Barang barangObj = gson.fromJson(barang, Barang.class);
					allResults.add(barangObj);
				}
				json = WebServicesKit
						.readUrl("http://localhost:8080/web-services/BS/barang/select3?p3="+partial3
								+"&p4="+partial4+"&p5="+partial5);
				System.out.println("http://localhost:8080/web-services/BS/barang/select3?p3="+partial3
								+"&p4="+partial4+"&p5="+partial5);
				int jmlBrg= jsonParser.parse(json).getAsInt();
				if (request.getParameter("category") != null) {
					if (Integer.parseInt(request.getParameter("category")) != 0) {

						/** port */
						WebServicesKit webkit = new WebServicesKit();
						json = WebServicesKit
								.readUrl("http://localhost:8080/web-services/CategoryService/categoryservice/categories");
						jsonParser = new JsonParser();
						JsonArray categoryArray = jsonParser.parse(json)
								.getAsJsonArray();
						KategoriBean kategObj;
						for (JsonElement categ : categoryArray) {
							kategObj = gson.fromJson(categ, KategoriBean.class);
							System.out.println("debug admin gallery=>"
									+ kategObj.getName());
							if (Integer.parseInt(request
									.getParameter("category")) == kategObj
									.getId()) {
								request.setAttribute("category_name",
										kategObj.getName());
							}
						}
						/** port */

						/** old */
						// String query3 = "SELECT * FROM kategori WHERE id=" +
						// Integer.parseInt(request.getParameter("category"));
						// ResultSet rs3 =
						// connection.createStatement().executeQuery(query3);
						// rs3.next();
						// request.setAttribute("category_name",
						// rs3.getString("nama"));
						/** old */
					}
				}

				request.setAttribute("items", allResults);
				request.setAttribute("total_pages", ""+jmlBrg);

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
