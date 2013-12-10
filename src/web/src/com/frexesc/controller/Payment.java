package com.frexesc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.frexesc.Constants;
import com.frexesc.model.UserBean;
import com.frexesc.service.WebService;

/**
 * 
 * Servlet implementation class Payment
 * 
 */
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = Constants.HOSTNAME;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Payment() {
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
			String user_id = String.valueOf(session.getAttribute("user_id"));

			/** Set WebService (REST) for retrieving list of User */
			WebService _user = new WebService(hostname + "user");
			_user.addParam("action", "view_profile");
			_user.addParam("user_id", user_id);
			_user.addHeader("GData-Version", "2");
			try {
				_user.execute(WebService.REQUEST_METHOD.GET);
				String user = _user.getResponse();
				JSONParser parser = new JSONParser();
				JSONObject mainJSON = null;
				try {
					mainJSON = (JSONObject) parser.parse(user);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				if (mainJSON.get("status").equals("true")) {
					JSONObject data = (JSONObject) mainJSON.get("data");

					String noCard = "";
					String naCard = "";
					String exCard = "";

					if (data.get("nocard") != null)
						noCard = data.get("nocard").toString();
					if (data.get("nacard") != null)
						naCard = data.get("nacard").toString();
					if (data.get("excard") != null)
						exCard = data.get("excard").toString();

					UserBean active_user = new UserBean(
							data.get("username").toString(),
							data.get("password").toString(),
							data.get("email").toString(),
							data.get("name").toString(),
							data.get("telephone").toString(),
							data.get("address").toString(),
							data.get("province").toString(),
							data.get("city").toString(),
							data.get("postal").toString(),
							Integer.parseInt(data.get("role").toString()),
							noCard,
							naCard,
							exCard,
							Integer.parseInt(data.get("transaction").toString()));

					if (active_user.getNocard() == null
							|| active_user.getNocard().equals("")) {
						/** Redirect to Credit Card page */
						response.sendRedirect("../card?from=payment");
					} else {

						// Update status
						/**
						 * Set WebService (REST) for update Transaction (Barang
						 * User)
						 */
						WebService _updateBarang = new WebService(hostname
								+ "baranguser");
						_updateBarang.addParam("action", "updateTransaction");
						_updateBarang.addParam("id", String.valueOf(request
								.getSession(true).getAttribute("user_id")));
						_updateBarang.addHeader("GData-Version", "2");

						try {
							_updateBarang
									.execute(WebService.REQUEST_METHOD.POST);
							// TODO : Unsafe Operation, Need to check result!
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						/**
						 * End of WebService for update Transaction (Barang
						 * User)
						 */

						// Update number of transaction
						/** Set WebService (REST) for update Transaction */
						WebService _update = new WebService(hostname + "user");
						_update.addParam("action", "updateTransaction");
						_update.addParam("id", String.valueOf(request
								.getSession(true).getAttribute("user_id")));
						_update.addParam("number_of_transaction", String
								.valueOf((active_user.getTransaction() + 1)));
						_update.addHeader("GData-Version", "2");

						try {
							_update.execute(WebService.REQUEST_METHOD.POST);
							// TODO : Unsafe Operation, Need to check result!
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						/** End of WebService for update Transaction */

						request.setAttribute("response", "Transaksi berhasil!");

						RequestDispatcher dispatcher;
						dispatcher = getServletContext().getRequestDispatcher(
								"/barang/payment.jsp");
						dispatcher.forward(request, response);

						// redirect to gallery

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			/** End WebService (REST) for retrieving list of User */

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
