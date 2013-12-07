package barangController;

import java.io.IOException;
import java.io.PrintWriter;

import javaModel.Barang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class DetailBarang
 */
@WebServlet("/barang/detail")
public class DetailBarang extends HttpServlet {
	//Debug agar ridho punya library
	private static final long serialVersionUID = 1L;
    private DatabaseAdapter DBA;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailBarang() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String detail = request.getParameter("id");
		if (detail == null)
		{
			PrintWriter out = response.getWriter();
			out.println("<h1>Perintah aneh. . .</h1>");
		}
		else
		{
			Barang B = new Barang(DBA);
			B.executeQuery("select * from barang where id="+detail);
			request.setAttribute("barang", B);
			request.setAttribute("includeJspContent", "/view/detailBarang.jsp");
			request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
