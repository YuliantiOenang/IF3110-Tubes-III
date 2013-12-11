package com.esc.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esc.beans.KategoriBean;
import com.esc.util.DbConnection;
import com.esc.util.JSONMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class KategoriServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONMessage jsonMessage = null;
		try {
			Statement stmt = DbConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM kategori");
			ArrayList<KategoriBean> kategoriBeans = new ArrayList<KategoriBean>();
			while (rs.next()) {
				KategoriBean kategori = new KategoriBean(Integer.parseInt(rs.getString("id")), rs.getString("nama"));
				kategoriBeans.add(kategori);
			}
			jsonMessage = new JSONMessage(200, new Gson().toJsonTree(kategoriBeans));
		} catch (Exception e) {
			e.printStackTrace();
			jsonMessage = new JSONMessage(500);
		}
		resp.getWriter().print(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}
}
