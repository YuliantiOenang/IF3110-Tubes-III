package com.frexesc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.BarangBean;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * 
 * Servlet implementation class Detail (Barang)
 * 
 */
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (session.getAttribute("username") == null) {
			response.sendRedirect("../register.jsp");
		} else {
			int id = 0;
			if (request.getParameter("id") != null) {
				id = Integer.valueOf(request.getParameter("id"));
			}
			try {
				String resp = HttpRequest.sendGet("/barang?id=" + id);
				BarangBean barangBean = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray().get(0), BarangBean.class);
				request.setAttribute("item", barangBean);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/barang/detail.jsp");
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
