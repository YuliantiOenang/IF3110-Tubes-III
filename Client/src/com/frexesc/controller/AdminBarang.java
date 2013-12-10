package com.frexesc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.frexesc.model.Barang;
import com.frexesc.model.KategoriBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class AdminBarang
 */
@MultipartConfig
public class AdminBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// final String UPLOAD_DIRECTORY =
	// "C:/Users/James Jaya/workspace/Frexesc/WebContent/img/barang/";

	public AdminBarang() {
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
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher = null;
		if (session.getAttribute("role") == null) {
			response.sendRedirect("register");
		} else if (session.getAttribute("role").equals("1")) {
			DbConnection dbConnection = new DbConnection();
			if (request.getParameter("action").equals("edit")) {
				String category = request.getParameter("category");

				/** port */

				try {
					String json = WebServicesKit
							.readUrl("http://localhost:8080/web-services/CategoryService/categoryservice/categories");
					Gson gson = new Gson();
					JsonParser jsonParser = new JsonParser();
					JsonArray categoryArray = jsonParser.parse(json)
							.getAsJsonArray();
					ArrayList<KategoriBean> kategoris = new ArrayList<KategoriBean>();
					for (JsonElement categ : categoryArray) {
						KategoriBean kategObj = gson.fromJson(categ,
								KategoriBean.class);
						System.out.println("debug admin barang=>"
								+ kategObj.getName());
						kategoris.add(kategObj);
					}

					/** port */

					/** old */
					// String selectCQuery = "SELECT * FROM kategori";
					// try {
					// Statement cstmt = connection.createStatement();
					// ResultSet rsc = cstmt.executeQuery(selectCQuery);
					// ArrayList<KategoriBean> kategoris = new
					// ArrayList<KategoriBean>();
					// while (rsc.next()) {
					// kategoris.add(new KategoriBean(rsc.getInt("id"),
					// rsc.getString("nama")));
					// }
					/** old */
					try {
						json = WebServicesKit
								.readUrl("http://localhost:8080/web-services/BS/barang/select?idkat="
										+ category);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JsonArray barangArray = jsonParser.parse(json)
							.getAsJsonArray();
					ArrayList<Barang> barangs = new ArrayList<Barang>();
					for (JsonElement barang : barangArray) {
						Barang barangObj = gson.fromJson(barang, Barang.class);
						barangs.add(barangObj);
					}
					request.setAttribute("kategoris", kategoris);
					request.setAttribute("barangs", barangs);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispatcher = getServletContext().getRequestDispatcher(
						"/adminedit.jsp");
			} else if (request.getParameter("action").equals("add")) {
				dispatcher = getServletContext().getRequestDispatcher(
						"/adminadd.jsp");
			} else if (request.getParameter("action").equals("main")) {
				dispatcher = getServletContext().getRequestDispatcher(
						"/adminmain.jsp");
			} else if (request.getParameter("action").equals("pic")) {
				request.setAttribute("id", request.getParameter("id"));
				dispatcher = getServletContext().getRequestDispatcher(
						"/adminpic.jsp");
			}
			dispatcher.forward(request, response);
		} else if (session.getAttribute("role").equals("0")) {
			response.sendRedirect("index");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		String json = null;
		JsonParser jsonParser = new JsonParser();
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();
		if (request.getParameter("action").equals("add")) {
			Barang barang = new Barang(0, Integer.parseInt(request
					.getParameter("category")), request.getParameter("name"),
					null, Integer.parseInt(request.getParameter("price")),
					request.getParameter("description"),
					Integer.parseInt(request.getParameter("amount")));

			System.out.println("SR0");
			try {
				json = WebServicesKit
						.readUrl("http://localhost:8080/web-services/BS/barang/insert?idKat="
								+ barang.getId_category()
								+ "&nama="
								+ barang.getName()
								+ "&gambar="
								+ barang.getPicture()
								+ "&harga="
								+ barang.getPrice()
								+ "&keterangan="
								+ barang.getDescription()
								+ "&jumlah="
								+ barang.getTotal_item());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int id = jsonParser.parse(json).getAsInt();
			URL filename = null;
			filename = getServletContext().getResource("/img/barang/1.jpg");
			/* upload */
			System.out.println(filename.toString());
			Part filePart = request.getPart("photo");
			String fileName = getFileName(filePart);

			String[] sp = fileName.toString().split("\\.");
			sp[1] = sp[1].toLowerCase();
			OutputStream out = new FileOutputStream(new File(
					request.getRealPath("") + "\\img\\barang\\" + id + "."
							+ sp[1]));
			InputStream filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			/* end of upload */
			try {
				json = WebServicesKit
						.readUrl("http://localhost:8080/web-services/BS/barang/update?id="
								+ id + "&gambar=" + id + "." + sp[1]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int success = jsonParser.parse(json).getAsInt();
			if (success > 0) {
				response.sendRedirect("admin?action=main&result=success");
			} else {
				response.sendRedirect("admin?action=main&result=unsuccess");
			}
		} else if (request.getParameter("action").equals("update")) {
			System.out.println(request.getParameter("description"));
			Barang barang = new Barang(Integer.parseInt(request
					.getParameter("id")), Integer.parseInt(request
					.getParameter("category")), request.getParameter("name"),
					null, Integer.parseInt(request.getParameter("price")),
					request.getParameter("description"),
					Integer.parseInt(request.getParameter("amount")));
			try {
				json = WebServicesKit
						.readUrl("http://localhost:8080/web-services/BS/barang/update?id="
								+ barang.getId()
								+ "&idKat="
								+ barang.getId_category()
								+ "&nama="
								+ barang.getName()
								+ "&harga="
								+ barang.getPrice()
								+ "&keterangan="
								+ barang.getDescription()
								+ "&jumlah="
								+ barang.getTotal_item());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int success = jsonParser.parse(json).getAsInt();
			PrintWriter out = response.getWriter();
			if (success < 1) {
				out.print("not");
			} else {
				out.print("success");
			}
		} else if (request.getParameter("action").equals("delete")) {
			try {
				json = WebServicesKit
						.readUrl("http://localhost:8080/web-services/BS/barang/delete?id="
								+ request.getParameter("id"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (request.getParameter("action").equals("pic")) {
			String id = request.getParameter("id");
			String old = null;
			try {
				json = WebServicesKit
						.readUrl("http://localhost:8080/web-services/BS/barang/select?id="
								+ id);
				JsonArray barangArray = jsonParser.parse(json)
						.getAsJsonArray();
				ArrayList<Barang> barangs = new ArrayList<Barang>();
				for (JsonElement barang : barangArray) {
					Barang barangObj = gson.fromJson(barang, Barang.class);
					barangs.add(barangObj);
					old = barangObj.getPicture();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(old);
			Part filePart = request.getPart("photo");
			String fileName = getFileName(filePart);
			String[] sp = fileName.toString().split("\\.");
			sp[1] = sp[1].toLowerCase();
			if (old != "null") {
				old = request.getRealPath("") + "\\img\\barang\\" + old;
			} else {
				old = request.getRealPath("") + "\\img\\barang\\" + id + "."
						+ sp[1];
			}
			// OutputStream out = new FileOutputStream(new File(UPLOAD_DIRECTORY
			// + File.separator + id + "." + sp[1]));
			OutputStream out2 = new FileOutputStream(new File(old));
			InputStream filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				// out.write(bytes, 0, read);
				out2.write(bytes, 0, read);
			}
			/*
			 * if (out != null) { out.close(); }
			 */
			if (out2 != null) {
				out2.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			/* end of upload */
			try {
				json = WebServicesKit
						.readUrl("http://localhost:8080/web-services/BS/barang/update?id="
								+ id + "&gambar=" + id + "." + sp[1]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int success = jsonParser.parse(json).getAsInt();
			response.sendRedirect("close.jsp");
		}
	}
}
