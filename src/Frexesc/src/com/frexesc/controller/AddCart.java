package com.frexesc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.esc.soap.SoapServiceProxy;
import com.frexesc.model.BarangBean;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * 
 * Servlet implementation class AddCart
 * 
 */
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCart() {
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
			response.getWriter().write("Redirect: ../register");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.getWriter().write("Redirect: ../register");
		} else {
			try {
				response.setContentType("text/html"); // set Content Type for
														// AJAX
				String resp = HttpRequest.sendGet("/barang?id=" + request.getParameter("id_barang"));
				BarangBean barangBean = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray().get(0), BarangBean.class);
				if (Integer.valueOf(barangBean.getJumlah_barang()) < Integer.valueOf(request.getParameter("qty")) || Integer.valueOf(request.getParameter("qty")) <= 0) {
					response.getWriter().write("Failure: Transaksi tidak berhasil, qty yang dimasukkan tidak valid.");
				} else {
					String deskripsiTambahan = request.getParameter("deskripsi_tambahan");
					if (deskripsiTambahan == null)
						deskripsiTambahan = "";

					// Add to Cart here

					SoapServiceProxy ssp = new SoapServiceProxy();
					ssp.createBarangUser(0, Integer.parseInt(request.getParameter("id_barang")), Integer.parseInt((String) session.getAttribute("user_id")), 0, Integer.parseInt(request.getParameter("qty")), "0", deskripsiTambahan);

					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("action", "restock"));
					params.add(new BasicNameValuePair("id", request.getParameter("id_barang")));
					params.add(new BasicNameValuePair("jumlah", barangBean.getJumlah_barang() - Integer.parseInt(request.getParameter("qty")) + ""));
					HttpRequest.sendPut("/barang", params);

					response.getWriter().write("Success: Transaksi berhasil!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
