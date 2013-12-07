package adminController;

import java.io.IOException;
import java.sql.ResultSet;

import javaModel.Barang;
import javaModel.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class IndexAdmin
 */
@WebServlet({ "/admin/index", "/admin", "/admin/"})
public class IndexAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexAdmin() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Integer userRole = Helper.getUserRole(session);
		boolean isLogin = (userRole == 2);
		
		if (isLogin)
		{
			String kateg = request.getParameter("kateg");
			if (kateg != null)
			{
				Barang B = new Barang(DBA);
				String Query = "select barang.id, barang.nama, barang.harga, " +
						"barang.gambar, barang.stok, kategori.nama_kategori, kategori.gambar from barang" +
						" join kategori on barang.id_kategori = kategori.id and kategori.id="+kateg; //jangan lupa diubah ke per kategori
				B.executeQuery2(Query);
				request.setAttribute("barang", B);
			}
			
			DBA.executeQuery("select * from kategori");
			ResultSet RS = DBA.getQueryResult();
			
			request.setAttribute("listKategori",RS);

			request.setAttribute("includeJspContent", "/view/adminIndex.jsp");
			request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
		}
		else response.sendRedirect("/ruserba/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
