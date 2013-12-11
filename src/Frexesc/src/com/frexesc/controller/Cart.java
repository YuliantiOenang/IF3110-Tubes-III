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
import com.frexesc.model.BarangUserBean;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * Servlet implementation class Cart
 * 
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
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
			try {
				String resp = HttpRequest.sendGet("/baranguser?action=chstatus&iduser=" + session.getAttribute("user_id"));
				String bresp = HttpRequest.sendGet("/barang");
				
				Type tt = new TypeToken<List<BarangUserBean>>(){}.getType();
				List<BarangUserBean> lResults = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray(), tt);
				ArrayList<BarangUserBean> allResults = new ArrayList<BarangUserBean>();
				Iterator<BarangUserBean> it = lResults.iterator();
				while (it.hasNext()) {
					allResults.add(it.next());
				}

				Type tt2 = new TypeToken<List<BarangBean>>(){}.getType();
				List<BarangBean> bResults = new Gson().fromJson(new JsonParser().parse(bresp).getAsJsonObject().get("content").getAsJsonArray(), tt2);
				ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();
				Iterator<BarangBean> it2 = bResults.iterator();
				while (it2.hasNext()) {
					allResults2.add(it2.next());
				}

				request.setAttribute("user_items", allResults);
				request.setAttribute("items", allResults2);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/barang/cart.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
