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

import com.frexesc.model.BarangBean;
import com.frexesc.model.BarangUserBean;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * 
 * Servlet implementation class UpdateCart
 * 
 */
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCart() {
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
				if (request.getParameter("submit") != null) {
					int id = 0;
					id = Integer.parseInt(request.getParameter("id"));
					String resp = HttpRequest.sendGet("/baranguser?action=byid&id=" + id);
					
					BarangUserBean barangUserBean = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content"), BarangUserBean.class);
					ArrayList<BarangUserBean> allResults = new ArrayList<BarangUserBean>();
					allResults.add(barangUserBean);

					String bresp = HttpRequest.sendGet("/barang?id=" + allResults.get(0).getId_barang());
					
					BarangBean barangBean = new Gson().fromJson(new JsonParser().parse(bresp).getAsJsonObject().get("content").getAsJsonArray().get(0), BarangBean.class);
					ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();
					allResults2.add(barangBean);
					if (allResults2.get(0).getJumlah_barang() + allResults.get(0).getJumlah_barang() < Integer.parseInt(request.getParameter("qty")) || Integer.parseInt(request.getParameter("qty")) <= 0) {
						/** TODO : Show remaining stock */
						response.getWriter().write("Failure: Transaksi tidak berhasil, qty yang dimasukkan tidak valid. qty dikembalikan ke " + allResults.get(0).getJumlah_barang());
					} else {
						int differences = 0;
						differences = (Integer.parseInt(request.getParameter("qty")) - allResults.get(0).getJumlah_barang()) * allResults2.get(0).getHarga_barang();

						/** Update barang_user */
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("action", "restock"));
						params.add(new BasicNameValuePair("jumlah_barang", (allResults2.get(0).getJumlah_barang() + (allResults.get(0).getJumlah_barang() - Integer.parseInt(request.getParameter("qty"))) + "")));
						params.add(new BasicNameValuePair("id", allResults.get(0).getId_barang() + ""));
						HttpRequest.sendPut("/barang", params);

						/** Update barang */
						List<NameValuePair> params2 = new ArrayList<NameValuePair>();
						params2.add(new BasicNameValuePair("action", "edit"));
						params2.add(new BasicNameValuePair("id", allResults.get(0).getId() + ""));
						params2.add(new BasicNameValuePair("jumlah", Integer.parseInt(request.getParameter("qty")) + ""));
						HttpRequest.sendPut("/baranguser", params2);
						response.getWriter().write("Success: " + differences);
					}
				}
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
