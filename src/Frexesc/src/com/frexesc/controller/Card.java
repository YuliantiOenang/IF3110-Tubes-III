package com.frexesc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * Servlet implementation class Card
 */
public class Card extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession(true).getAttribute("user_id") == null) {
			response.sendRedirect("register");
		} else {
			if (request.getParameter("from") != null) {
				request.setAttribute("from", request.getParameter("from"));
			}
			getServletContext().getRequestDispatcher("/creditcard.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String date = request.getParameter("expired_date");
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("action", "kartu"));
		params.add(new BasicNameValuePair("nama_kartu", name));
		params.add(new BasicNameValuePair("nomor_kartu", num));
		params.add(new BasicNameValuePair("expire_kartu", date));
		try {
			String resp = HttpRequest.sendPut("/user", params);
			if (resp.contains("204"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (request.getAttribute("from") == null || request.getAttribute("from") == "")
			response.sendRedirect("index");
		else
			response.sendRedirect("./barang/payment");
	}
}
