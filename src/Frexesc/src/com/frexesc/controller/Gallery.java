package com.frexesc.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.BarangBean;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (session.getAttribute("username") == null) {
			response.sendRedirect("../register");
		} else {
			String url = "/catalog";
			// String resp = HttpRequest.sendGet("/catalog");

			int sort = 0;
			int jenisSort = 0;

			if (request.getParameter("sort") != null) {
				sort = Integer.valueOf(request.getParameter("sort"));
			}

			if (request.getParameter("jenisSort") != null) {
				jenisSort = Integer.valueOf(request.getParameter("jenisSort"));
			}
			ArrayList<String> params = new ArrayList<String>();
			try {
				if (sort != 0) {
					params.add("sort=" + sort);
				}
				if (jenisSort != 0) {
					params.add("jenisSort=" + jenisSort);
				}
				if (request.getParameter("name") != null) {
					params.add("name=" + request.getParameter("name"));
				}
				if (request.getParameter("category") != null) {
					if (Integer.parseInt(request.getParameter("category")) != 0) {
						params.add("category=" + request.getParameter("category"));
					}
				}
				if (request.getParameter("price") != null) {
					if (Integer.parseInt(request.getParameter("price")) != 0) {
						params.add("price=" + request.getParameter("price"));
					}
				}
				if (request.getParameter("page") != null) {
					params.add("page=" + Integer.valueOf(request.getParameter("page")));
				}
				for (int i = 0; i < params.size(); i++) {
					if (i == 0) {
						url += "?" + params.get(i);
					} else {
						url += "&" + params.get(i);
					}
				}
				String resp = HttpRequest.sendGet(url);
				/* Parse Response */
				String category = new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray().get(0).getAsString();
				String totalPages = new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray().get(2).getAsString();
				
				Type tt = new TypeToken<List<BarangBean>>(){}.getType();
				List<BarangBean> lResults = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray().get(1).getAsJsonArray(), tt);
				ArrayList<BarangBean> allResults = new ArrayList<BarangBean>();
				Iterator<BarangBean> it = lResults.iterator();
				while (it.hasNext()) {
					allResults.add(it.next());
				}
				//ArrayList<BarangBean> allResults = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray().get(1).getAsJsonArray(), new TypeToken<ArrayList<BarangBean>>() {
				
				System.out.println(new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray().get(1).getAsJsonArray());
				System.out.println(category + " " + totalPages + " " + allResults.get(0).getNama_barang());
				if (request.getParameter("category") != null) {
					if (Integer.parseInt(request.getParameter("category")) != 0) {
						request.setAttribute("category_name", category);
					}
				}

				request.setAttribute("items", allResults);
				request.setAttribute("total_pages", totalPages);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/barang/index.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
