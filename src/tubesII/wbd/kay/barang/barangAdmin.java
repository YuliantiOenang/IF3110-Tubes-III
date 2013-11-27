package tubesII.wbd.kay.barang;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class barangAdmin
 */
@WebServlet("/barangAdmin")
public class barangAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean post;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public barangAdmin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		post = false;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action.equals("create")) {
			int kategori_barang = Integer.parseInt(request.getParameter("kategori_barang"));
			actionCreate(request, response, kategori_barang, null);
		} else if (action.equals("update")) {
			int id_barang = Integer.parseInt(request.getParameter("id_barang"));
			actionUpdate(request, response, id_barang, null);
		} else if (action.equals("delete")) {
			int id_barang = Integer.parseInt(request.getParameter("id_barang"));
			actionDelete(request, response, id_barang);
		} else
			out.print("<script>alert('Page not found');history.go(-1);</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		post = true;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = null;
		int kategori_barang = -1;
		int id_barang = -1;
		List<FileItem> items = null;
		try {
			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items)
				if (item.getFieldName().equals("action"))
					action = item.getString();
				else if (item.getFieldName().equals("kategori_barang"))
					kategori_barang = Integer.parseInt(item.getString());
				else if (item.getFieldName().equals("id_barang"))
					id_barang = Integer.parseInt(item.getString());
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		if (action.equals("create"))
			actionCreate(request, response, kategori_barang, items);
		else if (action.equals("update"))
			actionUpdate(request, response, id_barang, items);
		else
			out.print("<script>alert('Page not found');history.go(-1);</script>");
	}

	private void actionCreate(HttpServletRequest request, HttpServletResponse response, int kategori_barang, List<FileItem> items) {
		if (post) {
			Barang barang = new Barang();
			barang.n_beli = 0;
			barang.kategori_barang = kategori_barang;
			for (FileItem item : items)
				if (item.isFormField()) {
					if (item.getFieldName().equals("nama_barang"))
						barang.nama_barang = item.getString();
					if (item.getFieldName().equals("harga_barang"))
						barang.harga_barang = Integer.parseInt(item.getString());
					if (item.getFieldName().equals("keterangan"))
						barang.keterangan = item.getString();
					if (item.getFieldName().equals("stok"))
						barang.stok = Integer.parseInt(item.getString());
				} else {
					if (item.getFieldName().equals("gambar_barang")) {
						barang.gambar_barang = "/images/" + barang.nama_barang + "." + FilenameUtils.getExtension(item.getName());
						File file = new File(getServletContext().getRealPath(barang.gambar_barang));
						barang.gambar_barang = "."+barang.gambar_barang;
						try {
							item.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			if (Barang.find("SELECT * FROM barang WHERE nama_barang='" + barang.nama_barang + "'") != null) {
				try {
					response.getWriter().print("<script>alert('Nama barang sudah ada!');history.go(-1);</script>");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			barang.save();
			String url = "/kategori.jsp?laman=1&id=" + kategori_barang;
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher(url);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String url = "/barangAdminCreate.jsp?kategori_barang=" + kategori_barang;
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher(url);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void actionUpdate(HttpServletRequest request, HttpServletResponse response, int id_barang, List<FileItem> items) {
		if (post) {
			Barang barang = Barang.findByPk(id_barang);
			for (FileItem item : items)
				if (item.isFormField()) {
					if (item.getFieldName().equals("nama_barang"))
						barang.nama_barang = item.getString();
					if (item.getFieldName().equals("harga_barang"))
						barang.harga_barang = Integer.parseInt(item.getString());
					if (item.getFieldName().equals("keterangan"))
						barang.keterangan = item.getString();
					if (item.getFieldName().equals("stok"))
						barang.stok = Integer.parseInt(item.getString());
				} else {
					if (item.getFieldName().equals("gambar_barang") && !item.getName().equals("")) {
						barang.gambar_barang = "/images/" + barang.nama_barang + "." + FilenameUtils.getExtension(item.getName());
						File file = new File(getServletContext().getRealPath(barang.gambar_barang));
						barang.gambar_barang = "."+barang.gambar_barang;
						try {
							item.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			if (Barang.find("SELECT * FROM barang WHERE nama_barang='" + barang.nama_barang + "' AND id_barang<>" + barang.id_barang) != null) {
				try {
					response.getWriter().print("<script>alert('Nama barang sudah ada!');history.go(-1);</script>");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			barang.save();
			String url = "/kategori.jsp?laman=1&id=" + barang.kategori_barang;
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher(url);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Barang barang = Barang.findByPk(id_barang);
			request.setAttribute("barang", barang);
			String url = "/barangAdminUpdate.jsp";
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher(url);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void actionDelete(HttpServletRequest request, HttpServletResponse response, int id_barang) {
		Barang barang = Barang.findByPk(id_barang);
		int kategori_barang = barang.kategori_barang;
		barang.delete();
		String url = "/kategori.jsp?laman=1&id=" + kategori_barang;
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
