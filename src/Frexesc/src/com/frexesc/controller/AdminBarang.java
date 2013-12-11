package com.frexesc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.esc.soap.SoapServiceProxy;
import com.frexesc.model.BarangBean;
import com.frexesc.model.KategoriBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher = null;
		if (session.getAttribute("role") == null) {
			response.sendRedirect("register");
		} else if (session.getAttribute("role").equals("1")) {
			if (request.getParameter("action").equals("edit")) {
				try {
					String category = request.getParameter("category");

					String bresp = HttpRequest.sendGet("/barang?kategori=" + category);
					Type tt2 = new TypeToken<List<BarangBean>>() {
					}.getType();
					List<BarangBean> bResults = new Gson().fromJson(new JsonParser().parse(bresp).getAsJsonObject().get("content").getAsJsonArray(), tt2);
					ArrayList<BarangBean> barangs = new ArrayList<BarangBean>();
					Iterator<BarangBean> it2 = bResults.iterator();
					while (it2.hasNext()) {
						barangs.add(it2.next());
					}

					String kresp = HttpRequest.sendGet("/kategori");
					ArrayList<KategoriBean> kategoris = new ArrayList<KategoriBean>();
					JsonArray jsonArray = new JsonParser().parse(kresp).getAsJsonObject().get("content").getAsJsonArray();
					for (int i = 0; i < jsonArray.size(); i++) {
						JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
						KategoriBean kategoribean = new KategoriBean(Integer.parseInt(jsonObject.get("id").getAsString()), jsonObject.get("nama").getAsString());
						kategoris.add(kategoribean);
					}
					request.setAttribute("kategoris", kategoris);
					request.setAttribute("barangs", barangs);
				} catch (Exception e) {
					e.printStackTrace();
				}
				dispatcher = getServletContext().getRequestDispatcher("/adminedit.jsp");
			} else if (request.getParameter("action").equals("add")) {
				dispatcher = getServletContext().getRequestDispatcher("/adminadd.jsp");
			} else if (request.getParameter("action").equals("main")) {
				dispatcher = getServletContext().getRequestDispatcher("/adminmain.jsp");
			} else if (request.getParameter("action").equals("pic")) {
				request.setAttribute("id", request.getParameter("id"));
				dispatcher = getServletContext().getRequestDispatcher("/adminpic.jsp");
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
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("action").equals("add")) {
			BarangBean barang = new BarangBean(0, Integer.parseInt(request.getParameter("category")), request.getParameter("name"), "gambar", Integer.parseInt(request.getParameter("price")), request.getParameter("description"), Integer.parseInt(request.getParameter("amount")));
			SoapServiceProxy ssp = new SoapServiceProxy();
			ssp.createBarang(0, barang.getId_kategori(), barang.getNama_barang(), barang.getGambar(), barang.getHarga_barang(), barang.getKeterangan(), barang.getJumlah_barang());
			int id = 0;
			try {
				String resp = HttpRequest.sendGet("/barang?nama=" + URLEncoder.encode(barang.getNama_barang(), "UTF-8"));
				BarangBean barangBean = new Gson().fromJson(new JsonParser().parse(resp).getAsJsonObject().get("content").getAsJsonArray().get(0), BarangBean.class);
				id = barangBean.getId();
			} catch (Exception e) {
				e.printStackTrace();
			}
			/* upload */
			Part filePart = request.getPart("photo");
			String fileName = getFileName(filePart);

			String[] sp = fileName.toString().split("\\.");
			sp[1] = sp[1].toLowerCase();
			OutputStream out = new FileOutputStream(new File(request.getRealPath("") + "\\img\\barang\\" + id + "." + sp[1]));
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
			
			boolean success = true;
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("action", "gambar"));
				params.add(new BasicNameValuePair("gambar", id + "." + sp[1]));
				params.add(new BasicNameValuePair("id", id + ""));
				HttpRequest.sendPut("/barang", params);
			} catch (Exception e) {
				e.printStackTrace();
				success = false;
			}
			if (success) {
				response.sendRedirect("admin?action=main&result=success");
			} else {
				response.sendRedirect("admin?action=main&result=unsuccess");
			}
		} else if (request.getParameter("action").equals("update")) {
			BarangBean barang = new BarangBean(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("category")), request.getParameter("name"), null, Integer.parseInt(request.getParameter("price")), request.getParameter("description"), Integer.parseInt(request.getParameter("amount")));
			PrintWriter out = response.getWriter();
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("action", "edit"));
				params.add(new BasicNameValuePair("id", barang.getId()+""));
				params.add(new BasicNameValuePair("category", barang.getId_kategori()+""));
				params.add(new BasicNameValuePair("name", barang.getNama_barang()));
				params.add(new BasicNameValuePair("price", barang.getHarga_barang()+""));
				params.add(new BasicNameValuePair("description", barang.getKeterangan()));
				params.add(new BasicNameValuePair("amount", barang.getJumlah_barang()+""));
				HttpRequest.sendPut("/barang", params);
				out.print("success");
			} catch (Exception e) {
				e.printStackTrace();
				out.print("not");
			}
		} else if (request.getParameter("action").equals("delete")) {
			try {
				HttpRequest.sendDelete("/barang?id=" + request.getParameter("id"));
				response.sendRedirect("./admin?action=main");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (request.getParameter("action").equals("pic")) {
			String id = request.getParameter("id");
			String old = null;
			try {
				String bresp = HttpRequest.sendGet("/barang?id=" + id);
				BarangBean barangBean = new Gson().fromJson(new JsonParser().parse(bresp).getAsJsonObject().get("content").getAsJsonArray().get(0), BarangBean.class);
				old = barangBean.getGambar();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(old);
			Part filePart = request.getPart("photo");
			String fileName = getFileName(filePart);
			String[] sp = fileName.toString().split("\\.");
			sp[1] = sp[1].toLowerCase();
			if (old != "null") {
				old = request.getRealPath("") + "\\img\\barang\\" + old;
			} else {
				old = request.getRealPath("") + "\\img\\barang\\" + id + "." + sp[1];
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
			if (out2 != null) {
				out2.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			/* end of upload */
			boolean success = true;
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("action", "gambar"));
				params.add(new BasicNameValuePair("gambar", id + "." + sp[1]));
				params.add(new BasicNameValuePair("id", id + ""));
				HttpRequest.sendPut("/barang", params);
			} catch (Exception e) {
				e.printStackTrace();
				success = false;
			}
			response.sendRedirect("close.jsp");
		}
	}
}
