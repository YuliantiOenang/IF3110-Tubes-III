package com.esc.servlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esc.beans.UserBean;
import com.esc.util.DbConnection;
import com.esc.util.JSONMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONMessage jsonMessage = null;
		if (req.getSession(true).getAttribute("id") == null) {
			jsonMessage = new JSONMessage(401);
		} else {
			String id = req.getParameter("id");
			try {
				Connection conn = DbConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM \"user\" WHERE id=" + id + " LIMIT 1");
				if (rs.next()) {
					UserBean user = new UserBean(Integer.parseInt(rs.getString("id")), rs.getString("username"), rs.getString("password"), rs.getString("handphone"), rs.getString("alamat"), rs.getString("provinsi"), rs.getString("kota"), rs.getString("kodepos"), rs.getString("email"), Integer.parseInt(rs.getString("role")), rs.getString("nama"), rs.getString("nomor_kartu"), rs.getString("nama_kartu"), rs.getString("expire_kartu"), Integer.parseInt(rs.getString("transaksi")));
					jsonMessage = new JSONMessage(200, new Gson().toJsonTree(user));
				} else {
					jsonMessage = new JSONMessage(404);
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonMessage = new JSONMessage(500);
			}
		}
		resp.getWriter().print(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONMessage jsonMessage = null;
		String updateQuery = null;
		if (req.getSession(true).getAttribute("id") == null) {
			jsonMessage = new JSONMessage(401);
		} else {
			String id = (String) req.getSession(true).getAttribute("id");
			if (req.getParameter("action").equals("profil")) {
				String password = req.getParameter("password");
				String name = req.getParameter("name");
				String telephone = req.getParameter("telephone");
				String address = req.getParameter("address");
				String province = req.getParameter("province");
				String city = req.getParameter("city");
				String postal = req.getParameter("postal");
				updateQuery = "UPDATE \"user\" SET nama='" + name + "', password='" + password + "', handphone='" + telephone + "', alamat='" + address + "', kota='" + city + "', provinsi='" + province + "', kodepos='" + postal + "' WHERE id='" + id + "'";
			} else if (req.getParameter("action").equals("kartu")) {
				String namaKartu = req.getParameter("nama_kartu");
				String nomorKartu = req.getParameter("nomor_kartu");
				String expireKartu = req.getParameter("expire_kartu");
				updateQuery = "UPDATE \"user\" SET nama_kartu='" + namaKartu + "', nomor_kartu='" + nomorKartu + "', expire_kartu='" + expireKartu + "' WHERE id=" + id;
			} else if (req.getParameter("action").equals("transaksi")) {
				updateQuery = "UPDATE \"user\" SET transaksi=transaksi+1 WHERE id=" + id;
			}
			try {
				Statement statement = DbConnection.getConnection().createStatement();
				statement.executeUpdate(updateQuery);
				jsonMessage = new JSONMessage(204);
			} catch (SQLException e) {
				e.printStackTrace();
				jsonMessage = new JSONMessage(500);
			} catch (URISyntaxException e) {
				e.printStackTrace();
				jsonMessage = new JSONMessage(500);
			}
		}
		resp.getWriter().print(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}
}
