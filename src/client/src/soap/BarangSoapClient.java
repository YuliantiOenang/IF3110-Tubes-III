package soap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BarangSoapClient
 */
@WebServlet("/BarangSoapClient")
public class BarangSoapClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarangSoapClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BarangSoapProxy bsp = new BarangSoapProxy();
		Integer id_kategori = Integer.parseInt(request.getParameter("kategori"));
		String nama = request.getParameter("nama_barang"); 
		Integer harga = Integer.parseInt(request.getParameter("harga_barang"));
		String gbr = request.getParameter("file");
		Integer stock = Integer.parseInt(request.getParameter("stok"));
		Integer ctr = Integer.parseInt(request.getParameter(""));
		String ket = request.getParameter("keterangan");
		bsp.createBarang(id_kategori, nama, harga, gbr, stock, ctr, ket);
	}

}
