package com.frexesc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.frexesc.model.UserBean;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * 
 * Servlet implementation class Payment
 * 
 */
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("../register");
		} else {
			try {
				String resp = HttpRequest.sendGet("/user?id=" + session.getAttribute("user_id"));
				UserBean userBean = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content"), UserBean.class);
				if (userBean.getNomor_kartu() == null) {
					/** Redirect to Credit Card page */
					response.sendRedirect("../card?from=payment");
				} else {
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("action", "transaksi"));
					HttpRequest.sendPut("/baranguser", params);

					// Update number of transaction
					List<NameValuePair> params2 = new ArrayList<NameValuePair>();
					params2.add(new BasicNameValuePair("action", "transaksi"));
					HttpRequest.sendPut("/user", params2);

					request.setAttribute("response", "Transaksi berhasil!");

					RequestDispatcher dispatcher;
					dispatcher = getServletContext().getRequestDispatcher("/barang/payment.jsp");
					dispatcher.forward(request, response);
				}
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
