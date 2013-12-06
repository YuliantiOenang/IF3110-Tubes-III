package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javaModel.Barang;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class BarangController
 */
public class BarangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA = new DatabaseAdapter();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String detail = request.getParameter("id");
		PrintWriter out = response.getWriter();
		if (detail == null)
		{
			out.println("<h1>Perintah aneh. . .</h1>");
		}
		else
		{
			Barang B = Barang.findByPk(Integer.parseInt(detail));
			if (B != null) {
    			out.println(B.nama);
    			out.println(B.harga);
			} else {
			    out.println("Barang tidak ditemukan");
			}
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
