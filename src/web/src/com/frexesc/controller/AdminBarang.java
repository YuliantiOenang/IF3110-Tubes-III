package com.frexesc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.frexesc.Constants;
import com.frexesc.model.BarangBean;
import com.frexesc.model.KategoriBean;
import com.frexesc.service.WebService;
import com.frexesc.soap.BarangSoapProxy;

/**
 * Servlet implementation class AdminBarang
 */
@MultipartConfig
public class AdminBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = Constants.HOSTNAME;

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
		} else if (session.getAttribute("role").toString().equals("1")) {
			if (request.getParameter("action").equals("edit")) {
				String category = request.getParameter("category");

				/** Set WebService (REST) for retrieving list of Kategori */
				WebService _listbarang = new WebService(hostname + "kategori");
				_listbarang.addParam("action", "readAll");
				_listbarang.addHeader("GData-Version", "2");

				ArrayList<KategoriBean> allResults1 = new ArrayList<KategoriBean>();
				ArrayList<BarangBean> allResults2 = new ArrayList<BarangBean>();
				try {
					_listbarang.execute(WebService.REQUEST_METHOD.GET);
					String res = _listbarang.getResponse();
					JSONParser parser = new JSONParser();
					JSONObject mainJSON = null;
					try {
						mainJSON = (JSONObject) parser.parse(res);
						if (mainJSON.get("status").equals("true")) {
							JSONArray infoBarang = (JSONArray) mainJSON
									.get("data");
							@SuppressWarnings("unchecked")
							Iterator<JSONObject> iterator2 = infoBarang
									.iterator();
							while (iterator2.hasNext()) {
								JSONObject jsonKategori = iterator2.next(); // each
																			// kategori
																			// info
								KategoriBean kategori = new KategoriBean(
										Integer.valueOf(String
												.valueOf(jsonKategori.get("id"))),
										(String) String.valueOf(jsonKategori
												.get("name")));
								allResults1.add(kategori);
							}
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (category != null) {
					try {
						/** Set WebService (REST) for retrieving list of barang */
						WebService _barang = new WebService(hostname + "barang");
						_barang.addParam("action", "edit");
						_barang.addParam("category", category);
						_barang.addHeader("GData-Version", "2");

						_barang.execute(WebService.REQUEST_METHOD.GET);
						String res = _barang.getResponse();
						JSONParser parser = new JSONParser();
						JSONObject mainJSON = null;
						try {
							mainJSON = (JSONObject) parser.parse(res);
							allResults1.clear();
							if (mainJSON.get("status").equals("true")) {
								JSONArray infoBarang = (JSONArray) mainJSON
										.get("barangs"); // Get
								JSONArray infoKategori = (JSONArray) mainJSON
										.get("kategoris");

								@SuppressWarnings("unchecked")
								Iterator<JSONObject> iterator1 = infoBarang
										.iterator();
								@SuppressWarnings("unchecked")
								Iterator<JSONObject> iterator2 = infoKategori
										.iterator();

								while (iterator2.hasNext()) {
									JSONObject jsonKategori = iterator2.next(); // each
																				// barang
																				// info
									KategoriBean kategori = new KategoriBean(
											Integer.valueOf(String
													.valueOf(jsonKategori
															.get("id"))),
											(String) String
													.valueOf(jsonKategori
															.get("name")));
									allResults1.add(kategori);
								}

								while (iterator1.hasNext()) {
									JSONObject jsonBarang = iterator1.next(); // each
																				// barang
																				// info
									BarangBean barang = new BarangBean(
											(Long) jsonBarang.get("id"),
											(Long) jsonBarang
													.get("id_category"),
											(String) jsonBarang.get("name"),
											(String) jsonBarang.get("picture"),
											Integer.valueOf(String
													.valueOf(jsonBarang
															.get("price"))),
											(String) jsonBarang
													.get("description"),
											Integer.valueOf(String
													.valueOf(jsonBarang
															.get("total_item"))));
									allResults2.add(barang);
								}
							}
						} catch (ParseException e) {
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				request.setAttribute("kategoris", allResults1);
				request.setAttribute("barangs", allResults2);
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

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("action").equals("add")) {
			BarangBean barang = new BarangBean(0, Integer.parseInt(request
					.getParameter("category")), request.getParameter("name"),
					null, Integer.parseInt(request.getParameter("price")),
					request.getParameter("description"),
					Integer.parseInt(request.getParameter("amount")));
			long id = 0;
			/** SOAP Invocation */
			BarangSoapProxy _barangSoap = new BarangSoapProxy();
			_barangSoap.addBarang(barang.getId_category(), barang.getName(),
					barang.getPicture(), barang.getPrice(),
					barang.getDescription(), barang.getTotal_item());

			/** REST for get ID */
			WebService _getID = new WebService(hostname + "barang");
			_getID.addParam("action", "readId");
			_getID.addParam("nama_barang", barang.getName());
			_getID.addHeader("GData-Version", "2");

			try {
				_getID.execute(WebService.REQUEST_METHOD.GET);
				String get_id = _getID.getResponse();
				/*
				 * JSON Parser, using json_simple-1.1.jar
				 */
				JSONParser parser = new JSONParser();
				JSONObject mainJSON = null;
				try {
					mainJSON = (JSONObject) parser.parse(get_id);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				id = Long.parseLong(mainJSON.get("data").toString());
				//filename = getServletContext().getResource(
				//		"/img/barang/" + barang.getPicture());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/** End of REST */

			/* upload */
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

			/** REST for Update Gambar */
			WebService _updateBarang = new WebService(hostname + "barang");
			_updateBarang.addParam("action", "updateGambar");
			_updateBarang.addParam("id", String.valueOf(id));
			_updateBarang.addParam("path", sp[1]);
			_updateBarang.addHeader("GData-Version", "2");

			try {
				_updateBarang.execute(WebService.REQUEST_METHOD.POST);
				// TODO : Unsafe Operation, Need to check result!
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/** End of REST */
			response.sendRedirect("admin?action=main&result=success");

		} else if (request.getParameter("action").equals("update")) {
			System.out.println(request.getParameter("description"));
			/** Set WebService (REST) for update Barang */
			BarangBean barang = new BarangBean(Integer.parseInt(request
					.getParameter("id")), Integer.parseInt(request
					.getParameter("category")), request.getParameter("name"),
					null, Integer.parseInt(request.getParameter("price")),
					request.getParameter("description"),
					Integer.parseInt(request.getParameter("amount")));

			WebService _updateBarang = new WebService(hostname + "barang");
			_updateBarang.addParam("action", "updateBarang");
			_updateBarang.addParam("id", String.valueOf(barang.getId()));
			_updateBarang.addParam("id_category",
					String.valueOf(barang.getId_category()));
			_updateBarang.addParam("name", barang.getName());
			_updateBarang.addParam("price", String.valueOf(barang.getPrice()));
			_updateBarang.addParam("description", barang.getDescription());
			_updateBarang.addParam("total_item",
					String.valueOf(barang.getTotal_item()));
			_updateBarang.addHeader("GData-Version", "2");

			try {
				_updateBarang.execute(WebService.REQUEST_METHOD.POST);
				// TODO : Unsafe Operation, Need to check result!
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/** End of WebService (REST) for update Barang */
		} else if (request.getParameter("action").equals("delete")) {
			/** Set WebService (REST) for delete Barang */
			WebService _deleteBarang = new WebService(hostname + "barang");
			_deleteBarang.addParam("action", "delete");
			_deleteBarang.addParam("id", request.getParameter("id"));
			_deleteBarang.addHeader("GData-Version", "2");

			try {
				_deleteBarang.execute(WebService.REQUEST_METHOD.POST);
				// TODO : Unsafe Operation, Need to check result!
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/** End of WebService for delete Barang */
			response.sendRedirect("./admin?action=main");
		} else if (request.getParameter("action").equals("pic")) {
			String id = request.getParameter("id");
			String old = null;

			ArrayList<BarangBean> allResults = new ArrayList<BarangBean>();
			/** Set WebService (REST) for retrieving list of Barang */
			WebService _barang = new WebService(hostname + "barang");
			_barang.addParam("action", "read");
			_barang.addParam("id", id);
			_barang.addHeader("GData-Version", "2");

			try {
				_barang.execute(WebService.REQUEST_METHOD.GET);
				String listBarang = _barang.getResponse();

				/*
				 * JSON Parser, using json_simple-1.1.jar
				 */
				JSONParser parser = new JSONParser();
				JSONObject mainJSON = null;
				try {
					mainJSON = (JSONObject) parser.parse(listBarang);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (mainJSON.get("status").equals("true")) {
					JSONArray infoBarang = (JSONArray) mainJSON.get("data"); // Get
					// info

					/** Suppress warning for Compilation level */
					@SuppressWarnings("unchecked")
					Iterator<JSONObject> iterator = infoBarang.iterator();
					while (iterator.hasNext()) {
						JSONObject jsonBarang = iterator.next(); // each barang
																	// info
						BarangBean barang = new BarangBean(
								(Long) jsonBarang.get("id"),
								(Long) jsonBarang.get("id_category"),
								(String) jsonBarang.get("name"),
								(String) jsonBarang.get("picture"),
								Integer.valueOf(String.valueOf(jsonBarang
										.get("price"))),
								(String) jsonBarang.get("description"),
								Integer.valueOf(String.valueOf(jsonBarang
										.get("total_item"))));
						allResults.add(barang);
					}
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/** End of WebService for retrieving list of Barang */

			old = allResults.get(0).getPicture();
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
			/** REST for Update Gambar */
			WebService _updateBarang = new WebService(hostname + "barang");
			_updateBarang.addParam("action", "updateGambar");
			_updateBarang.addParam("id", String.valueOf(id));
			_updateBarang.addParam("path", sp[1]);
			_updateBarang.addHeader("GData-Version", "2");

			try {
				_updateBarang.execute(WebService.REQUEST_METHOD.POST);
				// TODO : Unsafe Operation, Need to check result!
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/** End of REST */
			response.sendRedirect("close.jsp");
		}
	}
}
