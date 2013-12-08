package com.frexesc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frexesc.Constants;
import com.frexesc.service.WebService;

/**
 * Servlet implementation class Card
 */
public class Card extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = Constants.HOSTNAME;

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession(true).getAttribute("user_id") == null) {
			response.sendRedirect("register");
		} else {
			getServletContext().getRequestDispatcher("/creditcard.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/** Set WebService (REST) for update Card */
		WebService _update = new WebService(hostname + "user");
		_update.addParam("action", "updateCard");
		_update.addParam("id", String.valueOf(request.getSession(true)
				.getAttribute("user_id")));
		_update.addParam("num", request.getParameter("num"));
		_update.addParam("name", request.getParameter("name"));
		_update.addParam("expired_date", request.getParameter("expired_date"));
		_update.addHeader("GData-Version", "2");

		try {
			_update.execute(WebService.REQUEST_METHOD.POST);
			// TODO : Unsafe Operation, Need to check result!
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/** End of WebService for update Card */

		if (request.getParameter("from") == null
				|| request.getParameter("from") == "")
			response.sendRedirect("index");
		else
			response.sendRedirect("./barang/payment");
	}

}
