package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.Barang;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * 
 * Servlet implementation class AddCart
 * 
 */
public class AddCart extends HttpServlet {
	Gson gson = new Gson();
	String json = null;
	JsonParser jsonParser = new JsonParser();
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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();

		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.getWriter().write("Redirect: ../register");
		} else {
			response.setContentType("text/html"); // set Content Type for AJAX
			try {
				json = WebServicesKit.readUrl("http://localhost:8080/web-services/BS/barang/select?id="+request.getParameter("id_barang"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JsonArray barangArray = jsonParser.parse(json).getAsJsonArray();
			List<Barang> barangList = new ArrayList<Barang>();
			for (JsonElement barang: barangArray) {
				Barang barangObj = gson.fromJson(barang, Barang.class);
				barangList.add(barangObj);
			}
			if (barangList.get(0).getTotal_item()< Integer
					.valueOf(request.getParameter("qty"))
					|| Integer.valueOf(request.getParameter("qty")) <= 0) {
				response.getWriter()
						.write("Failure: Transaksi tidak berhasil, qty yang dimasukkan tidak valid.");
			} else {
				String deskripsiTambahan = request
						.getParameter("deskripsi_tambahan");
				if (deskripsiTambahan == null)
					deskripsiTambahan = "";

				// Add to Cart here
				String query2 = "INSERT INTO barang_user (id_barang,id_user,status,jumlah_barang,deskripsi_tambahan) VALUES ("
						+ request.getParameter("id_barang")
						+ ", "
						+ session.getAttribute("user_id")
						+ ", 0, "
						+ request.getParameter("qty")
						+ ", \""
						+ deskripsiTambahan + "\")";
				//POST
				//String[] param = {"id", "user", "qty", "desc"};
				//String[] val= {"" + request.getParameter("id_barang") , "" + session.getAttribute("user_id"), "" +  request.getParameter("qty"), "" + //deskripsiTambahan};
				//ServiceParser.postUrl(ServiceParser.BASE_URL + "BarangUserService/baranguserService/insertbaranguser",param, val);
						

				// Update to Barang here
				try {
					json = WebServicesKit.readUrl("http://localhost:8080/web-services/BS/barang/update/id="
							+ request.getParameter("id_barang")
							+ "&jumlah="
							+ (barangList.get(0).getTotal_item() - Integer
									.parseInt(request.getParameter("qty"))));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.getWriter().write("Success: Transaksi berhasil!");
			}

		}

	}
}
