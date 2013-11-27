package tubesII.wbd.kay.barang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			actionCreate(request, response, kategori_barang);
		} else if (action.equals("update")) {
			int id_barang = Integer.parseInt(request.getParameter("id_barang"));
			actionUpdate(request, response, id_barang);
		} else if (action.equals("delete")) {
			int id_barang = Integer.parseInt(request.getParameter("id_barang"));
			actionDelete(request, response, id_barang);
		} else
			out.print("Page not found");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		post = true;
	}

	private void actionCreate(HttpServletRequest request, HttpServletResponse response, int kategori_barang) {
		if (post) {
			Barang barang = new Barang();
			barang.n_beli = 0;
			barang.kategori_barang = kategori_barang;
			barang.nama_barang = request.getParameter("nama_barang");
			barang.gambar_barang = request.getParameter("gambar_barang");
			barang.harga_barang = Integer.parseInt(request.getParameter("harga_barang"));
			barang.keterangan = request.getParameter("keterangan");
			barang.stok = Integer.parseInt(request.getParameter("stok"));
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
			String url = "/barangAdminCreate.jsp?kategori_barang="+kategori_barang;
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

	private void actionUpdate(HttpServletRequest request, HttpServletResponse response, int id_barang) {
		if (post) {
			Barang barang = Barang.findByPk(id_barang);
			barang.nama_barang = request.getParameter("nama_barang");
			barang.gambar_barang = request.getParameter("gambar_barang");
			barang.harga_barang = Integer.parseInt(request.getParameter("harga_barang"));
			barang.keterangan = request.getParameter("keterangan");
			barang.stok = Integer.parseInt(request.getParameter("stok"));
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
			request.setAttribute("barang",barang);
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
