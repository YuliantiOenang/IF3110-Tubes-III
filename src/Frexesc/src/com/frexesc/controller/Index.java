package com.frexesc.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.BarangBean;
import com.frexesc.model.KategoriBean;
import com.frexesc.model.TopfourBean;
import com.frexesc.model.UserBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * Servlet implementation class Index
 * 
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Notifikasi login gagal */
		if (request.getParameter("login") != null) {
			request.setAttribute("login", "gagal");
		}

		/* Login by cookie */
		Cookie[] cookies = request.getCookies();
		HttpSession sessions = request.getSession(true);
		boolean isLogin = false;
		String userid = null;
		String username = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("user_id")) {
					isLogin = true;
					userid = cookie.getValue();
				}
				if (cookie.getName().equals("username")) {
					username = cookie.getValue();
				}
			}
		}
		if (isLogin && sessions.getAttribute("user_id") == null) {
			try {
				String resp = HttpRequest.sendGet("/user?id=" + userid);
				UserBean userBean = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content"), UserBean.class);
				sessions.setAttribute("role", userBean.getRole() + "");
				sessions.setAttribute("user_id", userid);
				sessions.setAttribute("username", username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			String resp = HttpRequest.sendGet("/barang");
			String kresp = HttpRequest.sendGet("/kategori");

			Type tt = new TypeToken<List<BarangBean>>() {}.getType();
			List<BarangBean> lResults = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray(), tt);
			ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();
			Iterator<BarangBean> it = lResults.iterator();
			while (it.hasNext()) {
				allResults2.add(it.next());
			}

			ArrayList<KategoriBean> allResults3 = new ArrayList<KategoriBean>();
			JsonArray jsonArray = new JsonParser().parse(kresp).getAsJsonObject().get("content").getAsJsonArray();
			for (int i = 0; i < jsonArray.size(); i++) {
				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
				KategoriBean kategoribean = new KategoriBean(Integer.parseInt(jsonObject.get("id").getAsString()), jsonObject.get("nama").getAsString());
				allResults3.add(kategoribean);
			}
			String hresp = HttpRequest.sendGet("/barang?action=topfour");

			Type t = new TypeToken<List<TopfourBean>>(){}.getType();
			List<TopfourBean> fResults = new Gson().fromJson(new JsonParser().parse(hresp).getAsJsonObject().get("content").getAsJsonArray(), t);
			ArrayList<TopfourBean> topfours = new ArrayList<TopfourBean>();
			Iterator<TopfourBean> it3 = fResults.iterator();
			while (it3.hasNext()) {
				topfours.add(it3.next());
			}
			for (int i = 0; i < allResults3.size(); i++) {
				for (int j = 0; j < topfours.get(i).getIds().size(); j++) {
					if (allResults2.get(j).getId() == topfours.get(i).getIds().get(j)) {
						allResults3.get(i).setItemList(allResults2.get(j));
					}
				}
				while (allResults3.get(i).getItemList().size() < 4) {
					for (int j = 0; j < allResults2.size(); j++) {
						if (allResults2.get(j).getId_kategori() == allResults3.get(i).getId()) {
							long current_id = allResults2.get(j).getId();
							boolean is_exist = false;
							for (int k = 0; k < allResults3.get(i).getItemList().size(); k++) {
								if (allResults3.get(i).getItemList(k).getId() == current_id)
									is_exist = true;
							}
							if (!is_exist) {
								allResults3.get(i).setItemList(allResults2.get(j));
								if (allResults3.get(i).getItemList().size() == 4)
									break;
							}
						}
					}
				}
			}
			request.setAttribute("items", allResults3);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher;
		dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
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
