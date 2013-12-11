package com.frexesc.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.google.gson.reflect.TypeToken;

/**
 * 
 * Servlet implementation class DeleteBarang
 * 
 */
public class DeleteBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBarang() {
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
			int id = 0;
			id = Integer.parseInt(request.getParameter("id"));
			try {
				String resp = HttpRequest.sendGet("/baranguser?id=" + id);
				BarangUserBean barangUserBean = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject(), BarangUserBean.class);
				ArrayList<BarangUserBean> allResults = new ArrayList<BarangUserBean>();
				allResults.add(barangUserBean);

				String bresp = HttpRequest.sendGet("/barang?id=" + allResults.get(0).getId_barang());
				// String query2 = "SELECT * FROM barang WHERE id=" +
				// allResults.get(0).getId_barang();
				Type tt = new TypeToken<List<BarangBean>>() {
				}.getType();
				List<BarangBean> lResults = new Gson().fromJson(new JsonParser().parse(bresp).getAsJsonObject().get("content").getAsJsonArray().get(1).getAsJsonArray(), tt);
				ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();
				Iterator<BarangBean> it = lResults.iterator();
				while (it.hasNext()) {
					allResults2.add(it.next());
				}
				int jumlah_barang_akhir = allResults2.get(0).getJumlah_barang() + allResults.get(0).getJumlah_barang();
				
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("action", "restock"));
				params.add(new BasicNameValuePair("id", allResults.get(0).getId_barang()+""));
				params.add(new BasicNameValuePair("jumlah", jumlah_barang_akhir+""));
				HttpRequest.sendPut("/other", params);
				HttpRequest.sendDelete("/baranguser?id=" + id);
				response.sendRedirect("./cart");
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
